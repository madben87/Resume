# Resume

**This web project demonstrates my programming skills in Java. This project was created in the framework, Spring MVC, and assembled with the help of builder automatic Maven. Project Security is provided with the help of Spring Security, in particular user authentication.**

##Project Architecture:

![screenshot of sample](http://s48.radikal.ru/i119/1702/a7/74eaa6345f1a.png)

**Main page is available for any non-authorized user, where you can find all the information about me and my skills. It is also possible to write a letter to me that will be sent to my e-mail and written in the application
database.**

**Spring-controller «EmailController» is responsible for sending messages and recording them in a database.**

**When you go to admin page you must pass authorization. Spring Security ensures the safety of the whole project.**

**Administrator can chat with the ability to view incoming messages and send a reply to the email address specified by the user. Loading incoming messages from the database and sending messages implemented by JQuery Ajax technology and controller «AjaxController».**

**For storing user and messages information is used relational MySQL database with links between tables "One-to-Many":**

![screenshot of sample](http://s020.radikal.ru/i702/1702/51/efeac2e7eeb2.png)

##To copy a project:

`$ git clone git://github.com/madben87/Resume.git`
