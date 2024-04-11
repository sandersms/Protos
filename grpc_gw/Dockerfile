FROM python:latest

WORKDIR /src

COPY . /src/
RUN pip3 install google-api-python-client psutil grpcio grpcio-tools

# command docker will execute once container has started
CMD ["python3", "./NetServer.py"]