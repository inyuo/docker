#!/bin/bash


dnf install -y autoconf automake libtool curl make gcc-c++ unzip
mkdir -p /opt/soft/compile/protobuf
cd /opt/soft/compile/protobuf
cd protobuf
git clone https://e.coding.net/king019/github/protobuf.git
 ./configure --prefix=/usr
make
make install
cd /
protoc --version