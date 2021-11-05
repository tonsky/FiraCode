#!/bin/bash
set -o errexit -o nounset -o pipefail
cd "`dirname $0`/.."

VERSION="$(git describe --tags)"
FILE="Fira_Code_v$VERSION.zip"
rm -f $FILE

pushd distr
find . -not -name ".*" | xargs zip ../$FILE
popd

ls -lah $FILE