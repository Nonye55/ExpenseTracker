DROP USER IF EXISTS 'trackeruser'@'localhost';
CREATE USER 'trackeruser'@'localhost' IDENTIFIED BY 'trackeruser123';
GRANT ALL PRIVILEGES ON expensetrackerdb.* TO 'trackeruser'@'localhost';

FLUSH PRIVILEGES;

DROP DATABASE IF EXISTS expensetrackerdb;
CREATE DATABASE expensetrackerdb;
