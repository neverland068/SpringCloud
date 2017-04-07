FROM java:8
VOLUME /tmp
RUN mkdir /app
ADD qf-person-facade-0.0.1-SNAPSHOT.jar /app/person.jar
ADD runboot.sh /app/
RUN bash -c 'touch /app/person.jar'
WORKDIR /app
RUN chmod a+x runboot.sh
EXPOSE 9082
CMD /app/runboot.sh