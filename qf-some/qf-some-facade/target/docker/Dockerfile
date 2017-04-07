FROM java:8
VOLUME /tmp
RUN mkdir /app
ADD qf-some-facade-0.0.1-SNAPSHOT.jar /app/some.jar
ADD runboot.sh /app/
RUN bash -c 'touch /app/some.jar'
WORKDIR /app
RUN chmod a+x runboot.sh
EXPOSE 9083
CMD /app/runboot.sh