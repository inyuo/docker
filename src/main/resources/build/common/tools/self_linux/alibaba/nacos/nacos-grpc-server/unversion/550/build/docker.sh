#!/bin/sh
set -x
source /etc/profile
echo 'notice' >/opt/soft/notice.txt
cd /opt/soft
nohup java $JAVA_OPTS -jar /opt/soft/sshm_boot_cloud_grpc_provider-release.jar >>log.txt &

tail -f /docker.sh
