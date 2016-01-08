FROM centos:7
MAINTAINER Pedro Hos <pedro-hos@outlook.com>

ENV WILDFLY_VERSION 8.2.1.Final
ENV JBOSS_HOME /opt/jboss/wildfly

# Update Dependencies
RUN yum update -y && yum -y install xmlstarlet saxon augeas bsdtar unzip && yum clean all

# Install Java Dependencies
RUN yum -y install java-1.8.0-openjdk-devel && yum clean all

# Install Maven Dependencies
RUN yum -y install maven

# Add the WildFly distribution to /opt, and make wildfly the owner of the extracted tar content
# Make sure the distribution is available from a well-known place
RUN cd $HOME \
    && curl -O https://download.jboss.org/wildfly/$WILDFLY_VERSION/wildfly-$WILDFLY_VERSION.tar.gz \
    && tar xf wildfly-$WILDFLY_VERSION.tar.gz \
    && mkdir /opt/jboss \
    && mv $HOME/wildfly-$WILDFLY_VERSION $JBOSS_HOME \
    && rm wildfly-$WILDFLY_VERSION.tar.gz

# Ensure signals are forwarded to the JVM process correctly for graceful shutdown
ENV LAUNCH_JBOSS_IN_BACKGROUND true

# Add customization to mysql DS and Deploy
ADD customization $JBOSS_HOME/customization/

# Create folder
ADD . javaee-wildfly-mysql/
WORKDIR javaee-wildfly-mysql/
