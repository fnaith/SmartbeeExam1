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

## Setting Spring Security

Follow steps in reference, we can easily build a Spring Boot app on `https://smartbee-exam1.herokuapp.com/`.

### Reference
- https://devcenter.heroku.com/articles/deploying-spring-boot-apps-to-heroku
- https://docs.spring.io/spring-boot/docs/current/reference/html/getting-started.html#getting-started-installing-the-cli
