@echo off

cd ../../app-one-ui

npm install && npm run build

@rem mvn -f ../../app-one-ui/pom.xml install && mvn -f ../../app-one-server/pom.xml package