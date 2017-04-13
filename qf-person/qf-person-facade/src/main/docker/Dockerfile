FROM java:8
RUN mkdir /app
RUN mkdir -p /home/logs/logback/qf-person
ADD qf-person-facade-0.0.1-SNAPSHOT.jar /app/person.jar
ADD runboot.sh /app/
RUN bash -c 'touch /app/person.jar'
WORKDIR /app
RUN chmod a+x runboot.sh
CMD /app/runboot.sh