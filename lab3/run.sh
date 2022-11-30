MARIADB_DRIVER="lib/mariadb-driver.jar"
APP="target/app.jar"

java -classpath "$APP:$MARIADB_DRIVER" com.lab3.Main
