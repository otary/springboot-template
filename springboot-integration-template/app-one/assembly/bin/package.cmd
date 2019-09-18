@echo off

cd ../../app-one-ui && npm install && npm run build && cd ../app-one-server && mvn package && cd .. && copy app-one-server\target\*.jar assembly\lib\
