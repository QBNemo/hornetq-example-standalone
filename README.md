
#### Introduction
--------------------
This hornetQ demo shows a standalone HornetQ JMS communicate with a spring-mvc web application. The spring-mvc is a minimal configuration 
possible running. Adding only a dispatcher servlet and a application-context.xml.

The controller class will send a message to the HornetQ and then ask for that same message later and display in hello.jsp

#### Prerequisite
--------------------
Download latest hornetQ server from http://hornetq.jboss.org/downloads.html.

#### Configure hornetQ JMS
------------------------
Copy the config/hornetq-jms.xml to your local hornetQ JMS.

#### Start the HornetQ JMS
--------------------------
HORNET_HOME\bin\run.bat

#### Start the wepapp
---------------------------

Open up http://localhost:8080/webapp/hellohornet

