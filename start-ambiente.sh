docker-compose down

docker rmi -f $(docker images | grep ms | awk '{print $3}')

mvn clean install

docker-compose up -d
