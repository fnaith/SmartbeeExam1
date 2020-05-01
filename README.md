# SmartbeeExam1

This repository is for `Smartbee Java- SBI backend engineer exam`.
My plan to complete this task as following :

- Create Heroku app : Because `Deploy to any cloud platform` is a nice to have option also very convencing. On the other hand, I leave Spring framework for a while and they provide some guides.
- Setting Spring Security : I only have experince about Apache Shiro, so I think making AA works first will reduce risk.
- Write Dao and test : To ensure main requirements can be done ASAP. Althoug I never use H2 database, but it shouldn't that hard.
- Write Swagger yaml : Because `Swagger integration` is a nice to have option and it can reduce time of crafting controller.
- Complete RESTful API : Connect controller and dao dirctly. Use Postman to test.
- Create UI for CRUD : Build a React app to ensure we can successfully access RESTful API.
- Apply privilege on RESTful API : To meet the requirements, RESTful API will response error message when permission denied.
- Adjust error handling for UI : Add alert when to handle error message.

## Create Heroku app

Follow steps in reference, we can easily build a Spring Boot app on `https://smartbee-exam1.herokuapp.com/`.

### Reference
- https://devcenter.heroku.com/articles/deploying-spring-boot-apps-to-heroku
- https://docs.spring.io/spring-boot/docs/current/reference/html/getting-started.html#getting-started-installing-the-cli

## Setting Spring Security

The basic setting of Spring Security is surpicesing easy. 
I follow the reference and create users in memory as following :

- `spuer` : password is `super`, role is `SUPER`.
- `manager` : password is `manager`, role is `MANAGER`.
- `operator` : password is `operator`, role is `OPERATOR`.

Note that all  

### Reference
- https://www.hangge.com/blog/cache/detail_2672.html
- https://www.hangge.com/blog/cache/detail_2674.html

## Write Dao and test

Even using H2 has some pitfall, I still think JPA is very nice to work with. The config method is more neat than Spring MVC.
Also, in-memory db is mush more testing than old day. The schema as following :

```
CREATE TABLE COMPANY (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  address VARCHAR(200) NOT NULL,
  created_by VARCHAR(50) NOT NULL,
  created_at Date NOT NULL,
  updated_by VARCHAR(50) NOT NULL,
  updated_at Date NOT NULL,
  PRIMARY KEY(id)
);

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
  PRIMARY KEY(id)
);
```

### Reference
- https://github.com/iamvickyav/spring-boot-data-H2-embedded
- https://www.baeldung.com/spring-jpa-test-in-memory-database
- https://www.baeldung.com/spring-boot-h2-database
- https://www.cnblogs.com/v1haoge/p/9959855.html

## Write Swagger yaml

TODO

## Complete RESTful API

TODO

## Create UI for CRUD

TODO

## Apply privilege on RESTful API

TODO

## Adjust error handling for UI

TODO
