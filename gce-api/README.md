 gce-api
============================

The goal of this module is to play with google cloud endpoints deployed on appengine-standard environment

   
## Running locally

    mvn appengine:run in folder gce-api for the gce-api module (will be deployed on localhost:8080)

## Deploying

    mvn package appengine:deploy -P dev


## Browse API
* locally
    * http://localhost:8080/_ah/api/explorer (see troubleshooting section)
* dev
    * https://tidy-ivy-127308.appspot.com/_ah/api/explorer


## Endpoints
Regenerate and redeploy the OpenAPI configuration the first time, and whenever the configuration details in the @Api annotation is modified.

## Regenerate the OpenAPI configuration
The file `target/generated-sources/openapi.json` will be created.
First move to the maven gce-api module: `cd gce-api`
* locally
    * no need
* dev
    * `mvn endpoints-framework:openApiDocs -P dev`

## Deploy the OpenAPI configuration
It gives access to the Endpoints dashboard on Google Cloud Platform.
/!\ Needs the billing activated.
First move to the maven gce-api module: `cd gce-api`
* locally
    * no need
* dev
    * `gcloud --project=tidy-ivy-127308 endpoints services deploy target/generated-sources/openapi.json`
