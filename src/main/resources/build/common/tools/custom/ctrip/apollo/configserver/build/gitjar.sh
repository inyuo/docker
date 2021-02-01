#!/bin/sh
set -x
cd /opt/soft/version
git clone https://e.coding.net/king019/github/apollo.git
cd apollo
mvn versions:set -DnewVersion=release
cd scripts
sh ./build.sh
cd ..
cp ./apollo-configservice/target/apollo-configservice-release-github.zip /opt/soft/apollo-configservice-release-github.zip
mvn clean
rm -fr ~/.m2/repository