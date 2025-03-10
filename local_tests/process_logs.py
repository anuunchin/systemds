import sys
import os
import re

def process_log(file_path: str, output_file: str) -> None:
    elapsed_times = []

    with open(file_path, "r") as f:
        lines = f.readlines()

        for i in range(len(lines) - 1):
            if "ELAPSED TIME" in lines[i]:
                elapsed_time = float(lines[i + 1].strip())
                elapsed_times.append(elapsed_time)
    
    if len(elapsed_times) != 12:
        print(f"Skipping {file_path}: Not enough ELAPSED TIME entries ({len(elapsed_times)} found)")
        return

    last_10_avg = sum(elapsed_times[-10:]) / 10

    with open(output_file, 'a') as out_f:
        out_f.write(f"{file_path}, {last_10_avg:.6f}\n")

    print(f"Processed {file_path}: Average of last 10 ELAPSED TIME values = {last_10_avg:.6f}")


if __name__ == "__main__":
    script_dir = os.path.dirname(os.path.abspath(__file__))
    output_file = os.path.join(script_dir, "processed_results.csv")

    if not os.path.exists(output_file):
        with open(output_file, 'w') as f:
            f.write("file,average_time\n")

    for file_name in os.listdir(script_dir):
        file_path = os.path.join(script_dir, file_name)
        if file_name.endswith(".log") and file_path != output_file:
            process_log(file_path, output_file)

    print(f"\nResults saved in: {output_file}")
