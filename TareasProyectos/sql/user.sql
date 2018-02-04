use mysql;
CREATE USER 'projsuser'@'localhost' IDENTIFIED BY 'passproj';
GRANT ALL PRIVILEGES ON projectsdb.* TO 'projsuser'@'localhost';
FLUSH PRIVILEGES;