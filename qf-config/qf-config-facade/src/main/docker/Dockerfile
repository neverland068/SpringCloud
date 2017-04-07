FROM java:8
VOLUME /tmp
RUN mkdir /app
ADD qf-config-facade-0.0.1-SNAPSHOT.jar /app/config.jar
ADD runboot.sh /app/
RUN bash -c 'touch /app/config.jar'
WORKDIR /app
RUN chmod a+x runboot.sh
EXPOSE 9888
CMD /app/runboot.sh