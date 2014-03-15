Minion
======
Minion is an application that helps developers manage the server infrastructure that powers their
apps. Minion is impartial to whether the infrastructure is bare metal and in a data center or
in the cloud.

Concepts
========
Minion revolves around a few simple, but universal concepts in the infrastructure world.

* __Server__ - A Server is a computer that will be used to vend an application. Servers,
    traditionally, have been bare metal but are now of the more common cloud variety.
* __Server Class__ - A Server Class defines the specifications of the actual server.
    Classes define the different CPU, RAM, Disk and other configurations that are
    available as a fully provisioned Server.
* __Server Group__ - A Server Group is an arbitrary way to group a collection of Servers.
    Common examples include development, staging and production or can be as detailed as
    a group for each type of application. 

Colophon
========
Minion makes use of the following libraries:

* Language: __[Java](http://www.oracle.com/technetwork/java/index.html)__
* Build Tool: __[Maven](http://maven.apache.org)__
* ORM: __[Hibernate](http://www.hibernate.org/)__  
* Web Framework: __[Spring Framework](http://projects.spring.io/spring-framework/)__
* DB Migrations: __[Flyway DB](http://flywaydb.org)__
