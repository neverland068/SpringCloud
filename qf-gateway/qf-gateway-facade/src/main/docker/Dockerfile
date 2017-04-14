FROM java:8
VOLUME /tmp
RUN mkdir /app
ADD qf-gateway-facade-0.0.1-SNAPSHOT.jar /app/gateway.jar
ADD runboot.sh /app/
RUN bash -c 'touch /app/gateway.jar'
WORKDIR /app
RUN chmod a+x runboot.sh
CMD /app/runboot.sh