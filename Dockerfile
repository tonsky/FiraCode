FROM python:3

WORKDIR /opt

COPY requirements.txt .
COPY script/bootstrap_linux.sh script/
RUN script/bootstrap_linux.sh
