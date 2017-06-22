#!/bin/bash -x

sbt fullOptJS
cp target/scala-2.12/toon-brew*.js js/

