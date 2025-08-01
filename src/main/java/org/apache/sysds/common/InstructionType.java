/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.sysds.common;

public enum InstructionType {
	AggregateBinary,
	AggregateTernary,
	AggregateUnary,
	UaggOuterChain,
	Binary,
	Unary,
	Builtin,
	Ternary,
	BuiltinNary,
	ParameterizedBuiltin,
	MultiReturnParameterizedBuiltin,
	Variable,
	Reorg,
	Reshape,
	Dnn,
	Quaternary,
	FCall,
	Append,
	Rand,
	StringInit,
	Ctable,
	CentralMoment,
	Covariance,
	QSort,
	QPick,
	MatrixIndexing,
	MultiReturnBuiltin,
	MultiReturnComplexMatrixBuiltin,
	Partition,
	Compression,
	DeCompression,
	QuantizeCompression,
	SpoofFused,
	Prefetch,
	EvictLineageCache,
	Broadcast,
	TrigRemote,
	Local,
	Sql,
	MMTSJ,
	PMMJ,
	MMChain,
	Union,

	//SP Types
	MAPMM,
	MAPMMCHAIN,
	TSMM2,
	CPMM,
	RMM,
	ZIPMM,
	PMAPMM,
	Reblock,
	CSVReblock,
	LIBSVMReblock,
	Checkpoint,
	MAppend,
	RAppend,
	GAppend,
	GAlignedAppend,
	CumsumAggregate,
	CumsumOffset,
	BinUaggChain,
	Cast,
	TSMM,
	AggregateUnarySketch,
	PMM,
	MatrixReshape,
	Write,
	Init,
}
