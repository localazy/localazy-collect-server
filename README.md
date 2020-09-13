# Localazy Collect Server

An extremely simple server for collecting data through HTTP POST. 


## Why?

Sometimes, we need to collect data about available locales, supported plural types, etc. from different devices such as mobile phones, tablets, etc.

It's easier to automate it with a simple server like this. Uploading raw POST data and processing them from another place is often less complicated than handling files on the device, etc.

Also, it allows, with the correct setup, collecting data from remote locations. 

## Run

`docker run --rm -v /your/path:/opt/data -p 7000:7000 localazy/collect_server:latest`

The internal server in the container runs on port 7000 and stores data to folder `/opt/data`.

## Upload data

The raw data of the POST request send to `http://yoururl:7000/anything-you-want` are stored to file `/opt/data/anything-you-want` in the container.

## Obtain data

GET request to `http://yoururl:7000/anything-you-want` returns data (content of file `/opt/data/anything-you-want`).
