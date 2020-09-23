#!/bin/sh
echo "$DOCKER_PASSWORD" | docker login --username "$DOCKER_USERNAME" --password-stdin

echo "$DOCKER_PASSWORD" | docker login -u "$ALIYUN_USERNAME" registry.cn-shanghai.aliyuncs.com --password-stdin
echo "$DOCKER_PASSWORD" | docker login -u "$ALIYUN_USERNAME" registry.cn-huhehaote.aliyuncs.com --password-stdin
echo "$DOCKER_PASSWORD" | docker login -u "$ALIYUN_USERNAME" registry.cn-shenzhen.aliyuncs.com --password-stdin
echo "$DOCKER_PASSWORD" | docker login -u "$ALIYUN_USERNAME" registry.cn-hangzhou.aliyuncs.com --password-stdin
echo "$DOCKER_PASSWORD" | docker login -u "$ALIYUN_USERNAME" registry.cn-beijing.aliyuncs.com --password-stdin