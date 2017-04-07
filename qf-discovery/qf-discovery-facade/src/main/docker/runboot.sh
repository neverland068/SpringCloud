#10.0.2.15为各个discovery所在的宿主机ip，由于是互相注册所以不能在link中使用，会出现循环依赖的错误，每个discovery向宿主机暴露接口，所以通过宿主机来访问
echo "10.0.2.15   discovery1" >> /etc/hosts
echo "10.0.2.15   discovery2" >> /etc/hosts
echo "10.0.2.15   discovery3" >> /etc/hosts
sleep 10
java -Djava.security.egd=file:/dev/./urandom -jar /app/discovery.jar
