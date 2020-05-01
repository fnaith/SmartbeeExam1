DROP TABLE IF EXISTS COMPANY;

CREATE TABLE COMPANY (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  address VARCHAR(200) NOT NULL,
  created_by VARCHAR(50) NOT NULL,
  created_at Date NOT NULL,
  updated_by VARCHAR(50) NOT NULL,
  updated_at Date NOT NULL,
  deleted NUMBER(1,0) NOT NULL,
  PRIMARY KEY(id)
);

DROP TABLE IF EXISTS CLIENT;

CREATE TABLE CLIENT (
  id INT AUTO_INCREMENT PRIMARY KEY,
  company_id INT NOT NULL,
  name VARCHAR(100) NOT NULL,
  email VARCHAR(100) NOT NULL,
  phone VARCHAR(50) NOT NULL,
  created_by VARCHAR(50) NOT NULL,
  created_at Date NOT NULL,
  updated_by VARCHAR(50) NOT NULL,
  updated_at Date NOT NULL,
  deleted NUMBER(1,0) NOT NULL,
  PRIMARY KEY(id)
);
