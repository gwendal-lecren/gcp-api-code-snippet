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
    
## Running locally

    mvn appengine:run in folder core for the core module (will be deployed on localhost:8080)

## Deploying

    mvn package appengine:deploy -P dev


As you add / modify the source code (`src/main/java/...`) it's very useful to add
[unit testing](https://cloud.google.com/appengine/docs/java/tools/localunittesting)
to (`src/main/test/...`).  The following resources are quite useful:

* [Junit4](http://junit.org/junit4/)
* [Mockito](http://mockito.org/)

## Browse API
* locally
    * http://localhost:8080/_ah/api/explorer (see troubleshooting section)
* dev
    * https://tidy-ivy-127308.appspot.com/_ah/api/explorer

## Google Cloud useful commands
* `gcloud projects list`
* `gcloud config get-value project`
* `gcloud config set project tidy-ivy-127308`
* `gcloud auth login`

## Endpoints
Regenerate and redeploy the OpenAPI configuration the first time, and whenever the configuration details in the @Api annotation is modified.

## Regenerate the OpenAPI configuration
The file `target/generated-sources/openapi.json` will be created.
First move to the maven core module: `cd core`
* locally
    * no need
* dev
    * `mvn endpoints-framework:openApiDocs -P dev`

## Deploy the OpenAPI configuration
It gives access to the Endpoints dashboard on Google Cloud Platform.
/!\ Needs the billing activated.
First move to the maven core module: `cd core`
* locally
    * no need
* dev
    * `gcloud --project=tidy-ivy-127308 endpoints services deploy target/generated-sources/openapi.json`

## IntelliJ IDEA configuration
* Use IDEA Lombok plugin
* Use the IDEA Google Cloud plugin