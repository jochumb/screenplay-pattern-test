# Screenplay Pattern test
Experimenting with Screenplay pattern in Serenity, testing simple Twitter functionality

## Project setup
The features folder contrains two stories implemented using the screenplay pattern.

1. Login
..* uses the serenity-screenplay-webdriver module, has most of seleniums features covered
..* classes in the web directory
2. Search
..* uses the twitter API and the serenity-screenplay module, needs some code to bind the two
..* classes in the api directory

## Configure
Rename twitter.properties.example and twitter4j.properties.example (delete .example) and fill with valid values.

## Run
mvn verify