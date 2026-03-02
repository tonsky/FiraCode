#!/bin/bash
set -o errexit -o nounset -o pipefail
cd "$(dirname "$0")/.."

if [ "$(id -u)" -eq 0 ]; then
  SUDO=""
else
  SUDO="sudo"
fi

$SUDO apt-get update
$SUDO apt-get install -y pkg-config zlib1g-dev ttfautohint woff2 sfnt2woff-zopfli

pip install -r requirements.txt
