#!/bin/bash

for i in $(seq 1 500)
do
    curl -s http://localhost:83
    echo
done
