FROM  king019/centos:res

MAINTAINER king019

RUN dnf -y install  java-11-openjdk-devel
RUN dnf -y install  maven
RUN dnf -y install  git
RUN dnf -y install  curl


RUN curl -fsSL https://get.docker.com | bash -s docker --mirror Aliyun


RUN echo 'export JAVA_HOME=/usr/lib/jvm/java-11-openjdk' >> /etc/profile
RUN echo 'export PATH=$JAVA_HOME/bin:$PATH' >> /etc/profile




COPY docker.sh /docker.sh
COPY docker_run.sh /docker_run.sh
RUN chmod 755 /*.sh
CMD /docker.sh
