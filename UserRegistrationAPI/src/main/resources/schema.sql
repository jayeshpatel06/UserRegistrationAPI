DROP TABLE IF EXISTS USER;

CREATE TABLE USER (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  username VARCHAR(250) NOT NULL,
  pin INT DEFAULT 0,
  mobilenumber BIGINT DEFAULT 0,
  emailid VARCHAR(250) DEFAULT NULL
);