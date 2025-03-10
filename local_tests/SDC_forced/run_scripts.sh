#!/bin/bash

if [-z "$1"]; then
    echo "Usage: $0 [Fused|NonFused]"
    exit 1
fi

LOG_SUFFIX="$1"

for i in {1..12}
do
    ./bin/systemds local_tests/simpleTest.dml >> local_tests/simpleTest${LOG_SUFFIX}.log
done


for i in {1..12}
do
    ./bin/systemds local_tests/simpleTest1.dml >> local_tests/simpleTest${LOG_SUFFIX}1.log
done


for i in {1..12}
do
    ./bin/systemds local_tests/simpleTest2.dml >> local_tests/simpleTest${LOG_SUFFIX}2.log
done


for i in {1..12}
do
    ./bin/systemds local_tests/simpleTest3.dml >> local_tests/simpleTest${LOG_SUFFIX}3.log
done
