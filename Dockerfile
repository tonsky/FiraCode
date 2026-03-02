FROM python:3

WORKDIR /opt

COPY requirements.txt .
RUN pip install -r requirements.txt
RUN apt-get update && \
    apt-get install -y ttfautohint && \
    apt-get install -y woff2 && \
    apt-get install -y sfnt2woff-zopfli