# kafka

This project need ojdbc jar file to be added to local maven repo

jar file is available in the repo


>mvn install:install-file -Dfile=ojdbc6.jar -DgroupId=com.oracle -DartifactId=ojdbc6 -Dversion=12.1.0.2 -Dpackaging=jar
