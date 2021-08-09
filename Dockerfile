FROM python:3

WORKDIR /opt

RUN pip install --upgrade Pillow==5.4.1 idna==2.8 requests==2.21.0 urllib3==1.24.1 pycairo==1.20.1 gftools==0.7.4 fontmake==2.4.0 fontbakery==0.8.0
RUN apt-get update && \
    apt-get install -y ttfautohint && \
    apt-get install -y woff2 && \
    apt-get install -y sfnt2woff-zopfli