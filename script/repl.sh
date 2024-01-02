#!/bin/bash
set -o errexit -o nounset -o pipefail
dir=`dirname $0`
cd $dir/..

clojure -M -m user