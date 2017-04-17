FROM java:8
VOLUME /tmp
RUN mkdir /app
ADD qf-msadmin-facade-0.0.1-SNAPSHOT.jar /app/msadmin.jar
ADD runboot.sh /app/
RUN bash -c 'touch /app/msadmin.jar'
WORKDIR /app
RUN chmod a+x runboot.sh
CMD /app/runboot.sh