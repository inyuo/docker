#!/bin/sh
set -x
source /etc/profile
cd /root/tools
nohup java  $JAVA_OPTS -jar share_sentinel_apollo-1.0-SNAPSHOT.jar &
nohup sh /curlRun.sh $SERVER_PORT  &
nohup sh /curlRun.sh $SERVER_PORT  &
tail -f /docker.sh
