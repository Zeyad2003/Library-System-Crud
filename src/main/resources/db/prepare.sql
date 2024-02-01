-- Create the user
CREATE USER IF NOT EXISTS 'fawry-intern'@'%' IDENTIFIED BY 'fawry';

-- Grant all privileges to the user
GRANT ALL PRIVILEGES ON *.* TO 'fawry-intern'@'%' WITH GRANT OPTION;

-- Create the database
CREATE DATABASE IF NOT EXISTS `library-system`;

-- Switch to the newly created database
USE `library-system`;
