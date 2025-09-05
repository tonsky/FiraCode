FROM python:3.10

WORKDIR /opt

RUN pip install --upgrade Pillow==11.0.0 idna==2.8 requests==2.32.3 urllib3==2.2.3 pycairo==1.20.1 gftools==0.7.4 fontmake==2.4.0 fontbakery==0.8.0 protobuf==3.20.1
RUN apt-get update && \
    apt-get install -y ttfautohint && \
    apt-get install -y woff2 && \
    apt-get install -y sfnt2woff-zopfli

COPY . /opt

VOLUME [ "/opt/distr" ]