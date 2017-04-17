FROM java:8
VOLUME /tmp
RUN mkdir /app
ADD qf-turbine-facade-0.0.1-SNAPSHOT.jar /app/turbine.jar
ADD runboot.sh /app/
RUN bash -c 'touch /app/turbine.jar'
WORKDIR /app
RUN chmod a+x runboot.sh
CMD /app/runboot.sh