#!/bin/sh
set -x
source /etc/profile
cd /root/tools
nohup java $JAVA_OPTS -jar  dubbo-provider.jar &

tail -f /docker.sh