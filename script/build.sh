#!/bin/bash
set -o errexit -o nounset -o pipefail
cd "`dirname $0`"

./build_ttf.sh
./build_variable.sh
./build_woff2.sh
./build_woff.sh