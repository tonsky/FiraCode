#!/bin/bash
set -o errexit -o nounset -o pipefail
cd "`dirname $0`/.."

sudo apt update
sudo apt install -y python3.8 python3-setuptools python3.8-dev pkg-config zlib1g ttfautohint woff2 sfnt2woff-zopfli

sudo python3.8 -m easy_install pip
python3.8 -m pip install virtualenv --user
python3.8 -m virtualenv venv
source venv/bin/activate

export PKG_CONFIG_PATH="/usr/local/opt/libffi/lib/pkgconfig"
python3.8 -m pip install -r requirements.txt