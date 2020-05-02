# SmartbeeExam1

This repository is for `Smartbee Java- SBI backend engineer exam`.

Online Demo on : https://smartbee-exam1.herokuapp.com/

My plan to complete this task as following :

- Create Heroku app : Because `Deploy to any cloud platform` is a nice to have option also very convincing. On the other hand, I leave Spring framework for a while and they provide some guides.
- Setting Spring Security : I only have experience about Apache Shiro, so I think making AA works first will reduce risk.
- Write Dao and test repository : To ensure main requirements can be done ASAP. Although I never use H2 database, but it shouldn't that hard.
- Write Swagger yaml : Because `Swagger integration` is a nice to have option and it can reduce time of crafting controller.
- Complete RESTful API and test service : Write service to connect controller and dao. Use Swagger UI to test.
- Apply privilege on RESTful API : To meet the requirements, RESTful API will response error message when permission denied.
- Create UI for CRUD : Build a React app to ensure we can successfully access RESTful API.

## Create Heroku app

Follow steps in reference, we can easily build a Spring Boot app on `https://smartbee-exam1.herokuapp.com/`.

### Reference
- https://devcenter.heroku.com/articles/deploying-spring-boot-apps-to-heroku
- https://docs.spring.io/spring-boot/docs/current/reference/html/getting-started.html#getting-started-installing-the-cli

## Setting Spring Security

The basic setting of Spring Security is surprising easy.
I follow the reference and create users in memory as following :

- `super` : password is `super`, role is `SUPER`.
- `manager` : password is `manager`, role is `MANAGER`.
- `operator` : password is `operator`, role is `OPERATOR`.

### Reference
- https://www.hangge.com/blog/cache/detail_2672.html
- https://www.hangge.com/blog/cache/detail_2674.html

## Write Dao and test repository

Even using H2 has some pitfall, I still think JPA is very nice to work with. The config method is more neat than Spring MVC.
Also, in-memory database is much more testable than old day. The schema as following :

```
CREATE TABLE COMPANY (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  address VARCHAR(200) NOT NULL,
  created_by VARCHAR(50) NOT NULL,
  created_at BIGINT NOT NULL,
  updated_by VARCHAR(50) NOT NULL,
  updated_at BIGINT NOT NULL,
  deleted NUMBER(1,0) NOT NULL,
  PRIMARY KEY(id)
);

CREATE TABLE CLIENT (
  id INT AUTO_INCREMENT PRIMARY KEY,
  company_id INT NOT NULL,
  name VARCHAR(100) NOT NULL,
  email VARCHAR(100) NOT NULL,
  phone VARCHAR(50) NOT NULL,
  created_by VARCHAR(50) NOT NULL,
  created_at BIGINT NOT NULL,
  updated_by VARCHAR(50) NOT NULL,
  updated_at BIGINT NOT NULL,
  deleted NUMBER(1,0) NOT NULL,
  PRIMARY KEY(id)
);
```

Note that I add `deleted` field in schema, because JpaRepository isn't suite for auto key generation.
So I just increase id manually, and it is can be done more easily by never deleting instance.

### Reference
- https://github.com/iamvickyav/spring-boot-data-H2-embedded
- https://www.baeldung.com/spring-jpa-test-in-memory-database
- https://www.baeldung.com/spring-boot-h2-database
- https://www.cnblogs.com/v1haoge/p/9959855.html

## Write Swagger yaml service

Although I have been working with Spring MVC for a long time, I still can't make Swagger's Jackson work with Spring Boot.
I believe there is some better solution, but I just avoid pitfall by removing data-time format from yaml.
For API design, I replace `C` of `CRUD` by the additional one for convenient.

### Reference
- https://voicebase.readthedocs.io/en/v3/how-to-guides/swagger-codegen.html
- https://editor.swagger.io/

## Complete RESTful API and test service

After generating controller, writing service is more straight forward.
All API use naive implement, but instance activity is decided by `deleted` field.
For unit test, I use SpringBootTest instead of mocking everything.

### Reference
- https://www.baeldung.com/spring-boot-testing

## Apply privilege on RESTful API

To set privilege on roles, simply add `antMatchers` for API path.

### Reference
- https://www.hangge.com/blog/cache/detail_2674.html

## Create UI for CRUD

To provide UI for testing our API, I use React and Material-UI to build a simple web page.
Although this layout isn't too complex, it still takes more time than I thought.
Mainly work on CORS and take time to find out that root path is redirected by Swagger UI.
The web page contains 5 tabs :

- Create Company : Create company datas by submiting form.
- Company Control : Read / Update / Delete company data.
- Create Client : Create client datas by submiting form.
- Client Control : Read / Update / Delete client data.
- Option : has logout button for testing with different roles.

### Reference

- https://www.baeldung.com/get-user-in-spring-security
- https://material-ui.com/zh/components/selects/
