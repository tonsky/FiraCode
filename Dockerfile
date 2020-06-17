FROM python:3

WORKDIR /opt

RUN pip install -U Pillow==5.4.1 idna==2.8 requests==2.21.0 urllib3==1.24.1
RUN pip install pycairo
RUN pip install git+https://github.com/googlefonts/gftools
RUN pip install fontmake
RUN apt-get update && \
    apt-get install -y ttfautohint && \
    apt-get install -y woff2 && \
    apt-get install -y sfnt2woff-zopfli
RUN pip install fontbakery
