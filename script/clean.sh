#!/bin/bash
set -o errexit -o nounset -o pipefail
cd "`dirname $0`/.."

rm -rf distr/ttf
rm -rf distr/variable_ttf
rm -rf distr/woff2
rm -rf distr/woff