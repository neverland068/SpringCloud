FROM java:8
VOLUME /tmp
RUN mkdir /app
ADD qf-discovery-facade-0.0.1-SNAPSHOT.jar /app/discovery.jar
ADD runboot.sh /app/
RUN bash -c 'touch /app/discovery.jar'
WORKDIR /app
RUN chmod a+x runboot.sh
CMD /app/runboot.sh