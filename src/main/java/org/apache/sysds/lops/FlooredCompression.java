package org.apache.sysds.lops;

import org.apache.sysds.common.Types.DataType;
import org.apache.sysds.common.Types.ExecType;
import org.apache.sysds.common.Types.OpOp1;
import org.apache.sysds.common.Types.ValueType;
import org.apache.sysds.runtime.instructions.InstructionUtils;

public class FlooredCompression extends Lop {
    public static final String OPCODE = "floor_compress";

    private final int _singletonLookupKey;
    private final int _numThreads;

    public enum CompressConfig {
        TRUE, FALSE, COST, AUTO, WORKLOAD;

        public boolean isEnabled() {
            return this != FALSE;
        }

        public boolean isWorkload() {
            return this == WORKLOAD;
        }
    }

    public FlooredCompression(Lop input, DataType dt, ValueType vt, ExecType et, int singletonLookupKey, int numThreads)
    {   
        super(Lop.Type.Checkpoint, dt, vt);
//        Unary floorLop = new Unary(input, OpOp1.FLOOR, dt, vt, et, numThreads, false);
//        addInput(floorLop);
//        floorLop.addOutput(this);
        
		addInput(input);
        input.addOutput(input);
        lps.setProperties(inputs, et);
        _singletonLookupKey = singletonLookupKey;
        _numThreads = numThreads;
    }

    @Override
    public String toString() {
        return OPCODE;
    }

	@Override
	public String getInstructions(String input1, String output) {
		StringBuilder sb = InstructionUtils.getStringBuilder();
		sb.append(getExecType());
		sb.append(Lop.OPERAND_DELIMITOR);
		sb.append(OPCODE);
		sb.append(OPERAND_DELIMITOR);
		if(getInputs().get(0) instanceof FunctionCallCP &&
			((FunctionCallCP)getInputs().get(0)).getFunctionName().equalsIgnoreCase("transformencode") ){
			sb.append(getInputs().get(0).getOutputs().get(0).getOutputParameters().getLabel());
		}
		else{
			sb.append(getInputs().get(0).prepInputOperand(input1));
		}
		sb.append(OPERAND_DELIMITOR);
		if(getInputs().get(0) instanceof FunctionCallCP && 
			((FunctionCallCP)getInputs().get(0)).getFunctionName().equalsIgnoreCase("transformencode") ){
			sb.append(getInputs().get(0).getOutputs().get(0).getOutputParameters().getLabel());
		}
		else{
			sb.append(prepOutputOperand(output));
		}
		if(_singletonLookupKey != 0){
			sb.append(OPERAND_DELIMITOR);
			sb.append(_singletonLookupKey);
		}

		if(getExecType().equals(ExecType.CP) || getExecType().equals(ExecType.FED)){
			sb.append(OPERAND_DELIMITOR);
			sb.append(_numThreads);
		}
		
		return sb.toString();
	}
}
