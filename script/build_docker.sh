#!/bin/bash
set -o errexit -o nounset -o pipefail
cd "`dirname $0`/.."

docker build -t tonsky/firacode .

PWD=`pwd`
docker run --rm -v $PWD:/opt/FiraCode tonsky/firacode ./FiraCode/script/build