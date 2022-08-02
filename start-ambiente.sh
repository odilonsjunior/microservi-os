
docker rm -f $(docker ps -aq) &> /dev/null

docker rmi -f $(docker images | grep ms | awk '{print $3}') &> /dev/null

mvn clean install

docker-compose down

docker-compose build --no-cache

docker-compose up -d
