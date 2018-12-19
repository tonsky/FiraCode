#!/bin/bash -x

# Remove Retina from webfonts
rm distr/FiraCode-Retina.eot   2> /dev/null
rm distr/FiraCode-Retina.woff  2> /dev/null
rm distr/FiraCode-Retina.woff2 2> /dev/null

# Move to folders
mv distr/*.eot distr/eot/      2> /dev/null
mv distr/*.woff distr/woff/    2> /dev/null
mv distr/*.woff2 distr/woff2/  2> /dev/null
mv distr/*.ttf distr/ttf/      2> /dev/null
mv distr/*.otf distr/otf/      2> /dev/null

# Install OTF version
cp distr/otf/*.otf ~/Library/Fonts/

# Pack zip archive
cd distr
find . -not -name ".*" | xargs zip ../FiraCode.zip
cd ..
