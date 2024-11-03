#!/bin/bash

echo "Creating jar"
mvn clean package || exit 1
mv target/today-1.0-SNAPSHOT.jar target/today.jar

echo "Packaging jar as deb file"
jpackage --input target/ \
         --name today \
         --main-jar today.jar \
         --main-class io.natewilcox.App \
         --type deb \
         --description "A utility that wraps around the wikipedia API and pulls the daily feed" || exit 1

echo "Installing deb"
mv today_1.0_amd64.deb today.deb
sudo dpkg -i today.deb

echo "Success"
exit 0
