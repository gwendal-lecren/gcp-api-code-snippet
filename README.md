 gcp-api-code-snippet
============================

The goal of this repo is to play with the different products/services of the GCP

[ae-docs]: https://cloud.google.com/appengine/docs/java/

## Prerequisites
* [Java 8](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
* [Maven](https://maven.apache.org/download.cgi) (at least 3.5)
* Git
* [Google Cloud SDK](https://cloud.google.com/sdk/) (aka gcloud)

## Setup

    gcloud init
    gcloud auth application-default login

## Compile
* locally:
    `mvn clean package`
* dev:
    `mvn clean package -P dev`

As you add / modify the source code (`src/main/java/...`) it's very useful to add
[unit testing](https://cloud.google.com/appengine/docs/java/tools/localunittesting)
to (`src/main/test/...`).  The following resources are quite useful:

* [Junit4](http://junit.org/junit4/)
* [Mockito](http://mockito.org/)


## Google Cloud useful commands
* `gcloud projects list`
* `gcloud config get-value project`
* `gcloud config set project tidy-ivy-127308`
* `gcloud auth login`


## IntelliJ IDEA configuration
* Use IDEA Lombok plugin
* Use the IDEA Google Cloud plugin