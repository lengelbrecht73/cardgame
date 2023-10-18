#!/bin/bash

directory="../target"  # Replace with the path to the directory you want to check

if [ -d "$directory" ]; then
  java -jar ../target/cardgame-0.0.1-GA.jar FIVECARD
else
  ./build.sh
  java -jar ../target/cardgame-0.0.1-GA.jar FIVECARD
fi

