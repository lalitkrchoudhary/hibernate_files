Notes:
SpringBoot-MVC
===============
PreRequisite :: CoreJava + SpringCore + SpringDataJPA(JDBC,Hibernate) +
Servlet,JSP,JSTL(basics knowledge)
Different ways of Developing Java Based WebApplications
=======================================================
Model1Architecture
=> In this architecture either servlet or jsp components is used as main
components of webapplication
=> If servlet component is used, then jsp won't be used or vice-versa.
=> Here each main component contains multiple logics, ie no clear cut
seperation b/w logics.
=> It is not suitable for large scale applications.
Model2Architecture
=> MVC1 Architecture, MVC2 Architecture
=> Here we take support of multiple technologies in multiple layers to develop
the logics.
=> Suitable for Medium and Large scale applications.
=> M(model) V(view) C(Controller)
=> MVC2 Architecture is more industry standard.
=> All Webframeworks like Struts,JSF,Spring-MVC,Spring-Boot-MVC etc are given
based on MVC2 Architecture.
=> MVC means MVC2-Architecture only.
=> MVC3,MVC4,MVC5,MVC6 are no way related to java architecture, therse are
version of asp.net mvc
What is the difference b/w MVC1 and MVC2 Architecture?
=> In MVC1 we take single component(Servlet/jsp) acting as both view and
controller,but we take seperate components for other layers.
=> In MVC2 we take seperate component for View(jsp), seperate Component for
Controller(servlet) and seperate Componet for Model layer.

refer: Spring_mvc_01.png

W.r.t diagram
=============
1. Browser gives the request
2. Controller servlet traps and takes the request[Depending on the url pattern]
3. Using Navigation logic the Controller-Servlet passes the request to appropriate
components(Service,DAO)
4. The service,DAO component process the request.
5. DAO component interacts with Backend system(DB S/W) through model
6. The result generated will be transferred to Service and then it will be forwared
to controller.
7. The controller component passes the result to view component.
8. View component formats the result using Presentation logic.
9,10. The formatted results goes to browser as the response.
MVC2 Architecture pros and cons
===============================
Pros
a. Since there are mulitple layers in application layers we can say there is a
clear cut seperation b/w logics.
b. The modification done in one layer does not affect the other layers.
c. Maintainence and Enchancement of the project becomes easy.
d. Parallel development is possible so productivity is good.
e. It is industry standard architecture to develop java based medium scale and
large scale websites.

Cons
a. Since there is a parallel development we need more programmers.
b. Knowledge of multiple technologies is required.
MVC2 architecture rules or principles
=====================================
=> It is not just working with multiple technologies in mulitple layers, there
are set of rules we need to follow
a. Each layer is given to place bunch of logics, just place only such logics,
don't add anyother logics.
b. There can be multiple view comps, multiple model comps,But it is
recomended to take Single controller component.
c. All the operations must take place under the control of Controller
component.
d. View components must not interact with model component directly or
viceversa,they must interact with servlet component.
When we have MVC2 architecture to develop webapplications as layered applications,
what is the need of webapplication frameworks in java?
=> If we develop MVC2 architecture manually by using servlet,jsp technolgies then
a.Programmer should develop all the logics manually
b.Programmer should take care of navigation management
c.Programmer should take care of view management
d.Programmer should take care of data management.
e.Should remember and implement MVC2 rules
f.Chances of having boiler plate code.
To overcome the above limitations and to provide abstration over jee technologies
in webapplication development we can take the support of
MVC2 framework or java webapplication frameworks they are

a. struts -> from apache
b. JSF -> from SUNMS
c. Webwork -> from opensympohny
d. SpringMVC/SpringBoot MVC -> from interface21/pivotal team
e. ADF -> from Oracle corportation

Advantages of developing MVC2 architecture based webapplication development using
webapplication framework
a. Gives ready made Controller-Servlet,no need to write controller logics
manually.
b. Automatically implements maximum of MVC2 Rules
c. The ready made controller servlet can trap all or multiple request to
apply common system services like auditing,logging,security etc
note: ready made servlet will be given based on "FrontController" design
pattern, so it is called as "FrontControllerServlet".
d. FrontControllerServlet takes care of navigation management
e. FrontControllerServlet takes care of view management
f. FrontControllerServlet takes care of data management.
g. Lots of boiler plate code will be avoided.
Note: In Struts, the FrontControllerServlet name is "ActionServlet".
In JSF, the FrontControllerServlet name is "FacesServlet".
In SpringMVC, the FrontControllerServlet name is "DispatcherServlet".
IS MVC1,MVC2 and Model1 are they design patterns or architecutre?
=> These are architecure to develop the java based applications.

What is the difference b/w Architectrue and Design pattern?
=> Architecture speaks about involving multiple components and their flow
exeuction in the application development.
=> Design patterns speaks about the best solution for recurring problems in the
application development.
=> In the implementation of Architecture multiple design patterns will be used
eg: MVC2 Architecture speaks about how to involve multiple components in layered
web application development.
In each layer multiple Design patterns will be used to solve the commonly
recurring problems

Contoller layer :: FrontController,ApplicationController,Intercepting

filter etc ,design patterns will be applied.

View layer :: View Helper,CompositeView, .. design patterns will

be applied.

Model layer :: Service Delegate/Buisness Delegate, DAO and etc

design pattern will be applied.
What is FrontController Servlet?
=> The special web component/servlet component of MVC2 Architecture of java based
webapplication who can trap either all request or multiple
requests to apply common system services like auditing,logging,security etc and
also takes care of navigation management, view management
model/data management is caleld "FrontController Servlet".
Navigation Management => Decides the flow among Components.
View Management => Decides Which model/service/handler class results should
go to which view component(jsp or other component)
Data/model Management => Talks about how to store input values(form data) and how
to pass the generated results to various components keeping
them in particular scope.

=> Once the front controller is involved in MVC2 Architecture webapplication,there
will be only one servlet in the entire webapplication that is
FrontController servlet.
=> We keep java classes as "Handler/Controller/Action" classes in webapplications
either to process the request directly or to delegate the
request to service class by taking from FrontController-Servlet.
Note:
a. FrontController is only Servlet Component.
b. Handler/Controller/DAO classes are plain java classes.
c. View components are generally JSP/html/Thymleaf etc...
refer:: Spring_mvc_01.png

Note:
With respect to diagram

a. To make front controller servlet trapping multiple requests take the

support of extension match or directory match url pattern

eg::Extension Match :: *.do, *.ineuron, *.all,....
eg::Directory Match :: /x/y/* , /abc/ijk/*,

/nitin/ineuron/*

b. To make front controller servlet trapping all the request take the

support of "/".
What is the difference b/w FrontController and Controller/Handler/Action classes in
MVC2Architecture and FrontController Design Pattern?

FrontController

=> It is a web component(generally it is a servlet/filter web

component)

=> Traps either all request/multiple requests and applies common System

Services.

=> Generally managed by Servlet Container.
=> Gets request,response object that are created and given by Servlet

Container.

=> The main method containing logics are servlet life cycle methods or

convinence methods like doXXXX(,,)

=> Genernally it is one per entire MVC application.

Controller/Handler/Action

=> It is a java class(Spring bean in SpringMVC)
=> Either directly contains request processing logics or contains

logics to delegate request to service class.

=> Managed by JVM of WEbServer(normal webapplication), In case of

SpringMVC webapplication it is managed by IOC Container.

=> Gets request,response object that are passed by FrontController
=> Normally have methods that contains buisness logic or delegation

logic are called "handler" methods.

=> Generally it is one per module.

Note:
=> In SpringMVC/SpringBoot-MVC the FrontController is "DispatcherServlet" which is
ready made ServletComponent.
=> Every Servlet Component(Either Pre-defined/readymade/user-defined)must be
configured with Servlet Container and also must be linked
with url pattern(either with "/" or with "directory/extension" match
urlpattern).
3 ways of Servlet Configuration with Servlet Container
======================================================
1. Declarative approach

=> It is done by using web.xml file
=> if the servlet component is ready made and xml config are allowed in

apps.

eg:: DispatcherServlet configuration in XML driven

SpringMVC apps and in XML + Annotation apps.
<web-app>
<servlet>
<servlet-name>dispatcher</servlet-name>
<servlet-class>org.springframework.web.servlet.DispatcherServlet</

servlet-class>

<init-param>
<param-name>contextConfigLocation</param-name>
<param-value>/WEB-INF/dispatcher-servlet.xml</param-value>
</init-param>
<load-on-startup>1</load-on-startup>
</servlet>
<!-- Set up URL mapping for Spring MVC Dispatcher Servlet -->
<servlet-mapping>
<servlet-name>dispatcher</servlet-name>
<url-pattern>/</url-pattern>
</servlet-mapping>
</web-app>

2. Annotation driven approach

=> It is done by using @WebServlet
=> If the servlet component is userdefined then we can configure in

annotation drive approach

eg: Building webapplication using Model1,MVC1,MVC2

and having FrontController in those applications.
@Configuration
@ComponentScan({ "in.ineuron.web" })
public class MVCconfig extends WebMvcConfigurerAdapter {
}
import
org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletIn
itializer;
public class WebInitializer extends
AbstractAnnotationConfigDispatcherServletInitializer {
@Override
protected Class<?>[] getRootConfigClasses()
{
// TODO Auto-generated method stub
return null;
}
@Override
protected Class<?>[] getServletConfigClasses()
{
// TODO Auto-generated method stub
return new Class[] { MVCconfig.class };
}
@Override
protected String[] getServletMappings()
{
// TODO Auto-generated method stub
return new String[] { "/" };
}
}
3.Programmatic approach

=> It is done using ServletContext.addServlet("") method
=> It is useful to configure PreDefined/Readymade servlet Component in

webapplication where xml configuration are not allowed.

eg: In 100%code driven SpringMVC apps,In SpringBoot

MVC apps xml configuration are not allowed, so to configure

DispatcherServlet Component this programmatic

approach will be used either directly or indirectly.
Different approaches to develop SpringMVC applications
======================================================
1. Declartive Cfgs Approach(XML driven cfgs) ======> web.xml file we configure
DispatcherServlet
2. Annotation Cfgs Approach(XML + Annotation driven cfgs) ====> In useredefined
class, with @Configuration set we configure "DispatcherServlet"
3. 100%code driven configuration

4. SpringBoot MVC appps
Note::
=> In 1st,2nd approach DispatcherServlet will be configured using web.xml
=> In 3rd,4th approach DispatcherServlet will be configured using
Programatic/DynamicApproach
=> The source code of DispatcherServlet doesn't contains @WebServlet Annotation.
=> All SpringMVC/SpringBootMVC applications that are developed in different
approaches are based on MVC2Architecture and
FrontController(Dispatcher Servlet) design pattern.
While building SpringMVC/SpringBootMVC applications we need to use the following
annotations while developing handler classes
a. @Controller => To make java class as SpringBean + handler/controller
class
b. @RequestMapping => To mark java method of @Controller class as handler
method having requestpath and request mode/method(POST/GET)

Note: As of now browser can send only 2 types

of request[GET(default)/POST]
eg#1.
@Controller
public class LoginController{
@RequestMapping(value="/login" method =RequestMethod.GET)
public String login(parameters...){

//logic for validation or logic to delegate the request to

service class
}
}
The possible parameters for Handler method arguments are
a. javax.servlet.ServletRequest
b. javax.servlet.ServletResponse
c. @PathVariable
d. @RequestParam
e. @RequestHeader
f. @RequestAttribute
g. @ModelAttribute
h. Errors,BindingResult
i. @SessionAttribute
The possible return types of Handler methods
a. String
b. View
c. Model
d. @ModelAttribute
e. ModelAndView
f. void
SpringBoot MVC Flow/Spring MVC Flow
===================================
=> It is designed around Dispatcher Servlet which is predefined FrontController
Servlet Component.
=> All the activities in SpringMVC takes place under the control or monitoring of
DispatcherServlet Component.
Note:
=> DispatcherServlet takes the support of HandlerMapping Component to link the

given request with Handler method of Controller class.
DispatcherServlet gives Requestpath and RequestMode to HandlerMapping Component
and gets the RequestMappingInfo object having
Controller class beanid and HandlerMethod signature.
=> DispatcherServlet takes the support of ViewResolver Component to map the given
request related results to one of View Component
and gets View Object having physical view component name and location.
=> In SpringMVC View component is Abstract Entity ie we can take any things in
view component like jsp/html/freemarker,velocity components.

refer:: Spring-mvc-01.png

Note::
EmbededEnvironment
==================
Application---> Started =======> JRE,TomcatContainer(virtual)
|

Stopped <======= JRE(removed) TomcatContainer(removed)

W.r.t Diagram
=============
1. Programmer deploys SpringMVC/SpringBootMVC application in webserver or webapps.
2. Deployment activities takes place which involves IOC container
creation ,DispatcherServlet registration with ServletContainer
Pre-Instantiation of Singleton scope spring beans like Controller
class,handlermapping,viewResolvers,Service class,DAO class etc.
In the mean time necessary dependancy injection also takes place.
3. Browser gives request to deployed springmvc application.
4. The frontcontroller(DispatcherServlet) traps the request and applies the common
system services on the request
like logging,auditing,tracking etc,...
5. DispatcherServlet hands over the request to HandlerMapping component to map
incoming request with handler method of handler/controller
class and gets RequestMapping object from HandlerMapping component having
Controller class bean id and HandlerMethod signature(it uses lot
of reflection api code internally).
6. DispatcherServlet takes controller bean class id from the recieved
RequestMapping object and gets the Controller class object from
DispatcherServlet created IOC container.DispatcherServlet also prepares the
necessary objects based on the method signature of the
handled method collected from RequestMapping Info object.
7. DispatcherServlet calls handler method having necessary object as the arguments
on the above received Controller class object.
8. The handler method of the controller class either directly process the request
or takes the support of service/DAO and keeps the result
in a scope(prefereablly in request scope)
9. The handler method of Controller class returns LVN(logical view name) back to
Dispatcher Servlet.
10. DispatcherSerlvet gives LVN to ViewResolver
11. ViewResolver map/link LVN to PhysicalView component and returns View Object
having PhysicalViewName and location.
12. DispatcherServlet gets PhysicalViewName and location from the recieved View
Object and send the control to Physical view component
using rd.forward(,) to format the results gathered from particular
scope(preferabley request scope) using presentation logics.
These formatted results goes back to DispatcherServlet.
13. DispatcherServlet sends the formatted result to browser as the response.

HandlerMapping
==============
=> This component takes the incoming request through DispatcherServlet and maps
the request with appropriate handler method of appropriate
handler/controller class by matching the incoming url path with handler request
method path using reflection api and returns
"RequestMappingInfo" object back to DispatcherServlet having the mapped
controller class bean id and handlerMethod signature.
=> All HandlerMapping comps are the classes implementing
org.springframework.web.servlet.HandlerMapping(I)
=> Generally we work with ready made "HandlerMapping" components

a. BeanNamedUrlHandlerMapping[Default in XML driven configuration]
b. RequestMappingHandlerMapping[Default in annotation driven

configuration,100%code driven configuration,SpringBootMVC]

c. ControllerClassHandlerMapping
d. SimpleUrlHandlerMapping

etc...

<beans>
<bean id="handlerMapping"
class="org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping"/>
<beans>
ViewResolver
============
=> This componet takes the recieve logicalViewName with physical view component
returns View Object having the name and location of physical
view component back to dispatcher servlet.
=> It can collects the inputs either in the form of xml file(XMl driven
configuration) or from properties file(SpringBoot App)
=> ViewResolver Components are the classes that implements an interface called
"org.springframework.web.servlet.ViewResolver(I)"
=> Generally we work with ready made "ViewResolver" components

a. UrlBasedViewResolver
b. InternalResourceViewResolver(default in SpringBootMVC)
c. ResourceBundleViewResolver
d. XmlViewResolver
e. TilesViewResolver
f. FreeMarkerViewResolver
g. BeanNameViewResolver
Note: No default ViewResolver in xml,annotationdriver and
100%drivenconfiguration
<bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
<property name="prefix">
<value>/WEB-INF/</value>
</property>
<property name="suffix">
<value>.jsp</value>
</property>
</bean>
=> InternalViewResolver is capable of taking jsp,html,servlet component placed in
private area of view component through html,jsp components
are not configured in "urlpatttern".
=> In SpringMVC,SpringBootMVC we generally take "jsp" comps as the view component

and it is even recomeneded to keep those jsp components in
"private" area.
Note: Outside of WEB-INF area is called public area of webapplication,the request
to these components can be given directly without giving
mapping details to ServletContainer.
Inside WEB-INF area is called private area of webapplication, the request to
private are components must be given only after giving
mapping details to ServletContainer.
Advantages of placing jsp components in private area
====================================================
=> Helps to hide technology of the webapplication becoz the jsp files names does
not appear in the request urls,so many things does not
appear in the browser address bars.This helps to protect apps from hackers and
jackers.
=> Protects the source code of the jsp components from outsiders
=> If the jsp component is developed to display request scope data given by
servlet component, then direct request to jsp component by
by keeping jsp in public area may give null values or ugly values.[so to stop
that place jsp comp in private area]

refer:: spring-mvc_01.png

=> In our SpringMVC/SpringBoot-MVC keeps jsp component in private area like [WEB-
INF\pages] then InternalResourceViewResolver needs 3 details

to locate these jsp components.

a. Location of jsp components as the prefix info
b. suffix of jsp components
c. jsp filename as the LVN

application.properties
======================
spring.mvc.view.prefix =/WEB-INF/pages/ #location of view
spring.mvc.view.suffix = .jsp #Extension of Technology
Note: In SpringBoot-MVC Apps the following components comes automatically so we
need not develop them
a. DispatcherServlet
b. IOC-Container
c. HandlerMapping
d. ViewResolver

To get all these we need to go for a starter file called "spring-
boot-starter-web".

**************************************************************SECOND PHASE NOTES FOR SPRING MVC**********************************************************************

Control Flow of SpringBootMVC
============================
1. Programmer deploys SpringMVC/SpringBootMVC application in webserver or webapps
2. Deployment activities takes place which involves IOC container
creation,DispatcherServlet registration with ServletContainer
Pre-Instantiation of Singleton scope spring beans like Controller
class,handlermapping,viewResolvers,Service class,DAO class etc.
In the mean time necessary dependancy injection also takes place
3. Browser gives request to deployed springmvc application
4. The frontcontroller(DispatcherServlet) traps the request and applies the common
system services on the request
like logging,auditing,tracking etc,...
5. DispatcherServlet hands over the request to HandlerMapping component to map
incoming request with handler method of handler/controller
class and gets RequestMapping object from HandlerMapping component having
Controller class bean id and HandlerMethod signature(it uses lot
of reflection api code internally)
6. DispatcherServlet takes controller bean class id from the recieved
RequestMapping object and gets the Controller class object from
DispatcherServlet created IOC container.DispatcherServlet also prepares the
necessary objects based on the method signature of the
handled method collected from RequestMapping Info object.
7. DispatcherServlet calls handler method having necessary object as the arguments
on the above received Controller class object.
8. The handler method of the controller class either directly process the request
or takes the support of service/DAO and keeps the result
in a scope(prefereablly in request scope)
9. The handler method of Controller class returns LVN(logical view name) back to
Dispatcher Servlet.
10. DispatcherSerlvet gives LVN to ViewResolver
11. ViewResolver map/link LVN to PhysicalView component and returns View Object
having PhysicalViewName and location.
12. DispatcherServlet gets PhysicalViewName and location from the recieved View
Object and send the control to Physical view component
using rd.forward(,) to format the results gathered from particular
scope(preferabley request scope) using presentation logics.
These formatted results goes back to DispatcherServlet.
13. DispatcherServlet sends the formatted result to browser as the response.
Keypoints about SpringBootMVC application
=========================================
=> SpringBoot MVC can be developed as Standalone webapp or deployable
webapplication in webserver/Application Server.
=> SpringBoot MVC Standalone web application means nothing but webapplication that
uses "tomcat embeded server" so no need of arranging
any external server explicitly[Good in development,testing environment]
=> This application comes as a jar file,here SpringApplication.run() itself creates
tomcat embeded server along with IOC container creation
and DispatcherServlet Registration, no need of sepearte ServletInitializer
class.
=> SpringBootMVC deployable webapplication is nothing but webapplication that is
deployable in any webserver as normal war file.
=> Here Seperate ServletInitializer class is required extending from
SpringBootServlet Initializer to create IOCcontainer and register
DispatcherServlet dynamically.
=> In both the cases IOC container created is
"AnnotationConfigWebApplicationContext".

Note:: While creating Spring-boot-mvc project if we select the type as "war", then
the starter files will create 2 java files

a. Main class cum Configuration class having @SpringBootApplication
=> The main() class is not required if we are running our

App as Deployable webapplication using External
Tomcatserver/any other server

b. ServletInitializer extending SpringBootServletInitializer
=> This class is not required if we are running our

application as standalone webapplication using embeded server.
BootMVCProj1-DisplayingHomePage
|=> src/main/java

|=> in.ineuron
|=>

BootMvcProj1DisplayingHomePageApplication(@SpringBootApplication)
|=> ServletInitializer(extends

SpringBootServletInitializer)

Note: If we run springboot application as standalone app,then the
SpringApplication.run() method takes care of multiple activities like

a. Creating an Embeded tomcat server
b. Creating an IOC container
c. Creating an DispatcherServlet having IOC-container
d. Creating an ErrorFilter classes objects
e. Registering DispatcherServlet,ErrorFilters dynamically with Servlet

Container

so on.....

=> By default SpringBootMVC Apps runs without ContextPath, To provide ContextPath
for those Apps we need to add one special entry in application.properties
application.properties
======================
server.servlet.context-path=/FirstApp
spring.mvc.view.prefix = /WEB-INF/pages
spring.mvc.view.suffix = .jsp
server.port = 9999
old url :: http://localhost:9999/index.jsp
new url :: http://localhost:9999/FirstApp/index.jsp
Note: Embeded tomcat server is not taking index.jsp as the default welcome file,
but external tomcat server will take
Only standalone execution of springbootmvc app takes the cfg "ContextPath"
from application.properites file
The deployable webapplication execution in external server takes the project
name as the "ContextPath".
If we are running SpringBootMVC app as a deployable app in external server,
then we can comment main() of @SpringBootApplication class
If we are running SpringBootMVC app as a standalone app using embeded server
then we can remove "ServletInitalizer" class.
In order to get welcomepage/home page of the spring mvc app without typing
index.jsp in the browser address(stanadlone webapp) or to avoid index.jsp,we need
to take the handler method that give LVN of home page having request path="/".
eg::
@Controller

public class ShowHomeController {
@RequestMapping(value = "/", method = RequestMethod.GET)
public String showHomePage() {
return "home"; //WEB-INF/pages/home.jsp[delete index.jsp avaialble in

public area]
}
}
request url:: http://localhost:9999/FirstApp/
output:: Welcome to SpringMVC
Working with Handler Methods
============================
=> If the handlerMapping method return type is "String" then it returns only "LVN"
to dispatcher Servlet.
=> If the handlerMapping method return type is "ModelAndView" then it return
"Model Attributes" and "LogicalViewName" to DispatcherServlet.
=> If the DispatcherServlet receives ModelAndView Class Object from the Handler
method then it makes the model attribute
as the request scope data and it gives the recieved LVN to ViewResolver.
=> Taking ModelAndView is a legacy approach, go for alternative.
application.properties
======================
server.port=9999
spring.mvc.view.prefix=/WEB-INF/pages/
spring.mvc.view.suffix=.jsp
server.servlet.context-path=/SecondApp
eg#1.
@RequestMapping(value="/",method = RequestMethod.GET)
public String showHome() {

return "home";//WEB-INF/pages/home.jsp

}
Usage of ModelAndView
=====================
@RequestMapping(value = "/wish",method = RequestMethod.GET)
public ModelAndView generateMessage() {

String msg = service.generateWishMessage();
ModelAndView mav = new ModelAndView();
mav.addObject("wmg", msg);
mav.setViewName("display");// WEB-INF/pages/display.jsp
return mav;

}
request url:: http://localhost:9999/SecondApp/
Usage of Model(I)
================
@RequestMapping(value = "/wish", method = RequestMethod.GET)
public String generateMessage(Model model) {
System.out.println("SharedMemory object class name is :: " +
model.getClass().getName());
String msg = service.generateWishMessage();
model.addAttribute("wmg",msg);
return "display"; //WEB-INF/pages/display.jsp

}
Usage of Map<String,Object>[BestApproach as it is Non-Invasive]
===============================================================
@RequestMapping(value = "/wish", method = RequestMethod.GET)
public String generateMessage(Map<String,Object> model) {
System.out.println("SharedMemory object class name is :: " +
model.getClass().getName());
String msg = service.generateWishMessage();
model.put("wmg",msg);
return "display";
}
Making the return type as void
==============================
@RequestMapping(value = "/wish", method = RequestMethod.GET)
public void generateMessage(Map<String, Object> model) {
System.out.println("SharedMemory object class name is :: " +
model.getClass().getName());
String msg = service.generateWishMessage();
model.put("wmg", msg);//WEB-INF/pages/wish.jsp
}
If the handler method return type is void,it takes the incoming request path as
excluding("/") as LVN by using "RequestToViewNameTranslator"
concept internally.
eg:: incoming reuqest is "/wish", then it takes "wish" as LVN.
Behind the scenes
=================
=> DispatcherServlet creates one SharedMemory called "BindingAwareModelMap" object
to maintain model attributes having request scope.
=> By exposing this BindingAwareModelMap objects to handler methods as a parameter
we can add model data attributes to it
(default scope is request)
=> All view components belonging to same request scope can read and use model
attributes data.
Note: If we are using InternalResourceViewResolver in SpringMVC applications, then
all the view components must be in the same location
(prefix) and in same technology(suffix).
To keep different view comps in different locations and in different
technologies take the support of Multiple view resolvers.
Sending the response directly to the browser without using DispatcherServlet
============================================================================
@RequestMapping(value="/wish", method = RequestMethod.GET)
public void generateWishMessage(HttpServletResponse response) throws Excpetion{
String msg = service.generateWishMessage();
PrintWriter out = response.getWriter();
response.setContentType("text/html");
pw.println("<b>WishMessage is :: "+msg+"</b>");
return ;
}

@RequestMapping(value="/wish", method = RequestMethod.GET)
public String generateWishMessage(HttpServletResponse response) throws Excpetion{
String msg = service.generateWishMessage();
PrintWriter out = response.getWriter();
response.setContentType("text/html");
pw.println("<b>WishMessage is :: "+msg+"</b>");
return null;
}
These type of handler methods are so useful when we perform "FileDownloading"
activities.
eg::
@RequestMapping(value="/wish", method = RequestMethod.GET)
public Model generateWishMessage(){
String msg = service.generateWishMessage();
Model model = new ExtendedModelMap();
model.addAttribute("wmg",msg);
return model;
}
Taking Model as the return type of HandlerMethod is a bad practise,because of the
following reasons
a. We should know the process of Creation Model object explicitly
b. Internally created SharedMemory(BindingAwareModelMap) will be wasted
c. There is no control on LVN, we are forced to take the request uri as the
logical name.
Taking Model as the parameter of the HandlerMethod is a good practise,because of
the following reasons
a. Full Control of LVN.
b. Creating BindingAwareModelMap object as the sharedmemory is taken care by
DispatcherServlet
c. Creating parameter type reference variable pointing to the sharedmemory is
also taken care by DispatcherServlet.
d. Internally created SharedMemory(BindingAwareModelMap) will not be wasted.

e. Taking Parameter type as HashMap or Map we make Handler methods as "Non-
Invasive".

We need to consider the following points while giving requestpath to handler
methods of Controller class
===================================================================================
======================
a. The request path of handler method must start with "/".
b. The request path of handler method is caseSensitive.
eg::
@Controller
public class TestController{
@RequestMapping(value= "/REPORT)
public String showReport(Map<String,Object> map){

;;;;

}
@RequestMapping(value= "/report)
public String showReport1(Map<String,Object> map){

;;;;;

}
}
requestURL :: http://localhost:9999/ThirdApp/REPORT ===> showReport()
requestURL :: http://localhost:9999/ThirdApp/report ===> showReport1()
c. Multiple request have same request path with different request methods like
POST/GET
@Controller
public class TestController {
@GetMapping
public String showHome() {
System.out.println("TestController.showHome()");
return "home";
}
@RequestMapping(value="/report",method = RequestMethod.GET)
public String showReport(Map<String,Object> map) {
System.out.println("TestController.showReport(-)");
return "display";
}
@RequestMapping(value="/report",method = RequestMethod.POST)
public String showReport1(Map<String,Object> map) {
System.out.println("TestController.showReport1(-)");
return "display1";
}
}
home.jsp
========
<%@ page isELIgnored="false" %>
<!--POST REQUEST-->
<form action="report" method="POST">
<input type="submit" value="send"/>
</form>
<br>
<a href="report">link1</a> <!--GET REQUEST-->
display1.jsp
============
<h1 style="color:red;text-align:center"> from display1.jsp </h1>
display.jsp
===========
<h1 style="color:red;text-align:center"> from display.jsp </h1>
Note:: Instead of using @RequestMapping by specifiying requestmode GET/POST we can
directly use "@PostMapping" and "GetMapping".
d. Taking @RequestMapping without requestpath takes "/" as default path
@GetMapping("/")
public String showHome() {
System.out.println("TestController.showHome()");
return "home";
}
is equal to

@GetMapping
public String showHome() {
System.out.println("TestController.showHome()");
return "home";
}
e. One Handler class can have multiple request paths
@GetMapping(value={"/report","/report1","/report2"})
public String showReport(Map<String,Object> map) {

System.out.println("TestController.showReport(-)");
return "display";

}
requestURL :: http://localhost:9999/ThirdApp/report ===> showReport()
requestURL :: http://localhost:9999/ThirdApp/report1 ===> showReport()
requestURL :: http://localhost:9999/ThirdApp/report2 ===> showReport()
f. RequestMapping with Mode should be unique with respect to controller class.
@GetMapping(value={"/report"})
public String showReport(Map<String,Object> map) {

System.out.println("TestController.showReport(-)");
return "display";

}
@GetMapping(value={"/report"})
public String showReport1(Map<String,Object> map) {

System.out.println("TestController.showReport1(-)");
return "display";

}
=======================================================================
@GetMapping
public String showHome() {
System.out.println("TestController.showHome()"); =====> urlPattern :: / and
RequestMode :: GET
return "home";
}
@GetMapping
public String showHome1() {
System.out.println("TestController.showHome()"); =====> urlPattern :: / and
RequestMode :: GET
return "home";
}
===================================================================
g. In SpringMVC max two methods can be taken without requestpath(One with GET
request and another one with POST request)
@PostMapping
public String showHome() {
System.out.println("TestController.showHome()");
return "home";
}
@GetMapping
public String showHome1() {
System.out.println("TestController.showHome1()");
return "home";

}
h. If two controller class have two handler methods with same request type and
request mode then we need to differentiate them at the
Controller level using "global request path"
@Controller
public class DemoController {
@GetMapping(value={"/report"})
public String generateReport(Map<String,Object> map) {
return "display";
}
}
@Controller
public class TestController {
@GetMapping(value={"/report"})
public String generateReport(Map<String,Object> map) {
return "display";
}
}
Solution
========
@Controller
@RequestMapping("/demo")//global requestpath
public class DemoController {
@GetMapping(value={"/report"})
public String generateReport(Map<String,Object> map) {
return "display";
}
}
@Controller
@RequestMapping("/test")//global requestpath
public class TestController {
@GetMapping(value={"/report"})
public String generateReport(Map<String,Object> map) {
return "display";
}
}
requestURL :: http://localhost:9999/ThirdApp/demo/report ===>
DemoController.generateReport()
requestURL :: http://localhost:9999/ThirdApp/test/report ===>
TestController.generateReport()
j. We cannot take ServletContext,ServletConfig object as a parameter of handler
method becoz they are global objects which go for
@Autowired injections more over they are not valid parameter types for handler
methods,but we can take HttpSession type
parameter in handler methods.
@Controller
@RequestMapping("/demo")
public class DemoController {
@GetMapping(value={"/report"})
public String generateReport(Map<String,Object> map,HttpSession ses) {
System.out.println("DemoController.generateReport(-)");
System.out.println("Session Id:"+ses.getId());

return "display";
}
}



***********************************************************************THIRD PHASE NOTES FOR SPRING MVC****************************************************************

eg#1.
@Controller
@RequestMapping("/")
public class LoginController{
@GetMapping(value="")
public String <methodName>(Map<String,Object> model,....){
return "";
}
@PostMapping(value="")
public String <methodName>(Map<String,Object> model,....){
return "";
}
}
The possible parameters for Handler method arguments are
a. javax.servlet.ServletRequest
b. javax.servlet.ServletResponse
c. @PathVariable
d. @RequestParam
e. @RequestHeader
f. @RequestAttribute
g. @ModelAttribute
h. Errors,BindingResult
i. @SessionAttribute
The possible return types of Handler methods
a. String
b. View
c. Model
d. @ModelAttribute
e. ModelAndView
f. void

DataBinding and DataRendering
=============================
DataBinding :: The process of writing input values(form data/request parameter
data) to java class object is called "DataBinding".
DataRendering :: The process of giving controller generated/gathered
results/outputs after executing buisness logic to viewcomponents through
SharedMemory (BindingAwareModelMap object) is called

"DataRendering".
Note:
DataBinding => Binding the data from view component to controller in the form of
java class object called Model class object.
DataRendering=> Passing data/results/outputs from Controller to view Component as
ModelAttributes through SharedMemory called
BindingAwareModelMap object.

Passing different types of results/ouputs/data in DataRendering
a. Passing simplevalues
b. Passing array/collections

c. Passing collection of Model/Buisness Object
d. Passing single Object of Model/Buisness Object/Entity class.
Note: Model(I) comes from SpringFramework, where as Model is Bo/Entity class.
Reading Simple values
=====================
@Controller
public class TestController {
@GetMapping("/report")
public String showReport(Map<String,Object> map) {
System.out.println("TestController.showReport()");
map.put("name", "kohli");
map.put("age", 35);
map.put("address", "RCB");
return "show_report";
}
}
show_report.jsp
===============
<h1 style="color:red; text-align: center;"> READING SIMPLE VALUES</h1>
<b>NAME IS :: ${name}</b><br/>
<b>AGE IS :: ${age}</b><br/>
<b>ADDR IS :: ${address}</b><br/>
Passing arrays and collection values from controller class to view component in
DataRendering process
===================================================================================
==================
package in.ineuron.controller;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class TestController {
@GetMapping("/report")
public String showReport(Map<String, Object> map) {
System.out.println("TestController.showReport()");
String nickNames[] = new String[] { "sachin", "saurav", "dravid",

"kohli" };

Set<Long> mobilePhonesSet = new HashSet<Long>();
mobilePhonesSet.add(9999999L);
mobilePhonesSet.add(8888888L);
List<String> coursesList = List.of("java", "spring", "spring boot",

"hibernate");

Map<String, Long> idsMap = Map.of("aadhar", 4543535L, "voterId",

53543543534L, "panNo", 4545355454L);

//Creating a ModelAttributes
map.put("nickNames", nickNames);
map.put("phonesInfo", mobilePhonesSet);
map.put("coursesInfo", coursesList);
map.put("idsInfo", idsMap);
return "show_report";
}
}
show_report.jsp
===============
<b>Arrays Data</b>
<br />
<c:forEach var="name" items="${nickNames}">
${name }<br />
</c:forEach>
<hr />
<b>List Data</b>
<br />
<c:forEach var="course" items="${coursesInfo}">
${course }<br />
</c:forEach>
<hr />
<b> Phone number (set)::</b>
<br>
<c:forEach var="phone" items="${phonesInfo}">
${phone} <br>
</c:forEach>
<hr/>
<b> ids Info (Map)::</b>
<br>
<c:forEach var="id" items="${idsInfo}">
${id.key} ===> ${id.value} <br>
</c:forEach>
Passing List of Model class Objects to view component from Controller Using
DataRendering Process
===================================================================================
==============
Employee.java
=============
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
private Integer eno;
private String ename;
private String desg;
private Double salary;
}
TestController.java
===================

@Controller
public class TestController {
@GetMapping("/report")
public String showReport(Map<String, Object> map) {
System.out.println("TestController.showReport()");
List<Employee> empsList = List.of(new Employee(10, "sachin", "batsman",

90000.0),

new Employee(7, "dhoni", "keeper", 190000.0), new

Employee(18, "kohli", "captain", 180000.0));
map.put("empsInfo", empsList);
return "show_report";
}
}
show_report.jsp
===============
<table border="1" align="center">
<tr>
<th>eno</th>
<th>ename</th>
<th>desg</th>
<th>salary</th>
</tr>
<c:forEach var="emp" items="${empsInfo}">
<tr>
<td>${emp.eno}</td>
<td>${emp.ename}</td>
<td>${emp.desg}</td>
<td>${emp.salary}</td>
</tr>
</c:forEach>
</table>
Passing single model class object as a model attribute from controller to view
component in data rendering process
===================================================================================
===============================
Employee.java
=============
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
private Integer eno;
private String ename;
private String desg;
private Double salary;
}
TestController.java
===================
@Controller
public class TestController {
@GetMapping("/report")
public String showReport(Map<String, Object> map) {
System.out.println("TestController.showReport()");

Employee employee = new Employee(10, "sachin", "batsman", 90000.0);
map.put("emp", employee);
return "show_report";
}
}
show_report.jsp
===============
<table border="1" align="center">
<tr>
<th>eno</th>
<th>ename</th>
<th>desg</th>
<th>salary</th>
</tr>
<tr>
<td>${emp.eno}</td>
<td>${emp.ename}</td>
<td>${emp.desg}</td>
<td>${emp.salary}</td>
</tr>
</table>
Conclusion of DataRendering in SpringBootMVC App
================================================
=> It is the process of passing data from controller class handler methods to view
components through DispatcherServlet using Sharedmemory
called "BindingAwareModelMap".
DataBinding
===========
=> It is the process of giving the view comps supplied input values to handler
methods of controller class

View to controller data passing :: Data Binding
Controller to View data passing :: Data Rendering

Binding can be done in 2 ways
=============================
a. Binding form data to handler method of controller class as the Model/Command
class Object using "@ModelAttribute".It is also called as
"FormBinding/RequestWrapping".
b. Binding hyperlink generated additional request param values to handler method
of Handler class using "@RequestParam".It is also called as
"RequestParam Binding".
a. Binding form data to handler method of controller class as the Model object
using "@ModelAttribute".
Model class/JavaBean class
==========================
=> The java bean class whose object holds form component values of form page is
called "Model class".
For form binding/data binding we need to follow the operations
=> Count form components in form page and take same no of properties in Model
class
=> Make sure that form component names and Model class attributes names should
match.

=> Add getter and setter methods for the Properties of the Model class
=> Take Handler method in Handler class having @ModelAttribute<model class type>
parameter.
register.jsp
============
<form method="POST">
<table align="center">
<tr><td>Employee number:: </td> <td><input type="text" name="eno">
</td></tr>
<tr><td>Employee name:: </td> <td><input type="text" name="ename">
</td></tr>
<tr><td>Employee address:: </td> <td><input type="text" name="eadd">
</td></tr>
<tr><td>Employee salary:: </td> <td><input type="text" name="salary">
</td></tr>
<tr><td colspan="2"><input type="submit" value="register"> </td> </tr>
</table>
</form>
Employee.java
=============
@Data
public class Employee {
private int eno;
private String ename;
private String eadd="hyd";
private float salary;
public Employee() {
System.out.println("Employee:: 0-param constructor");
}
}
@Controller
public class EmployeeController {
@PostMapping("/emp_register")
public String regiserEmployee(Map<String,Object> map,@ModelAttribute("emp")
Employee emp) {
//read and use form data from model class object or send to service class
System.out.println(emp);
return "result";
}
}
Internal Operations of FormBinding
==================================
1. End user fills up the formpage and submit the request
2. Dispatcher servlet traps and take the request
3. Dispatcher Servlet gets handler method signature through "RequestMappingInfo"
component.
4. Dispatcher Servlet noticies @ModelAttribute("emp") Employee emp type parameter
and it understands to perform Databinding/FormBinding
by taking Employee class as the Model class.
5. Creates a Model class Object having the name given in the @ModelAttribute("emp")
as the object name

Employee emp = new Employee()
Note: If @ModelAttribute is taken without param then it takes the Model

class name like Employee and create the Object having

class name as the object name with the first letter lowercase.

eg: Employee employee = new Employee();

6. Reads the data using request.getParameter("") and it performs the necessary
conversion according to the Model class properties using
PropertyEditors
7. Writes the received and converted form data to Model class object using setter
methods
8. Dispatcher servlet creates another necessary objects like BindingAwareModelMap
Object and calls handler method having those objects
and Model class object(emp).
Note:
Generally we take two handler methods in Controller class with respect to form page
operation
a. First Handler method in GET Mode to Lanuch Form page.
b. Second Handler method in POST mode to process from page submission request.
For both the handler methods we can take same request path with

different request mode(recomended)

If the above request handler methods are having two different requests

path then the request mode are your choice.
Taking same request path for both handler methods[Form launching and submit request
processing form page]
=> Taking action attribute in <form ..> becomes optional.
=> When form page is launched we take initial data from Model class object
properties and We can display in form page components as
initial values.[It is possible if form page is designed using spring suplied
jsp tags]
EmployeeController.java
=======================
@Controller
public class EmployeeController {
@GetMapping("/")
public String showHome() {
return "home";
}
@GetMapping("/emp_register")
public String showForm() {
return "register";
}
@PostMapping("/emp_register")
public String regiserEmployee(Map<String, Object> map, @ModelAttribute
Employee emp) {

// read and use form data from model class object or send to service

class

System.out.println(emp);
return "result";
}
}
Employee.java
=============
@Data

@NoArgsConstructor
@AllArgsConstructor
public class Employee {
private Integer eno;
private String ename;
private String eadd;
private Double salary;
}
home.jsp
========
<h1 style="text-align: center">
<a href="emp_register">Register Employee</a>
</h1>
register.jsp
============
<form method="POST">
<table align="center">
<tr><td>Employee number:: </td> <td><input type="text" name="eno">
</td></tr>
<tr><td>Employee name:: </td> <td><input type="text" name="ename">
</td></tr>
<tr><td>Employee address:: </td> <td><input type="text" name="eadd">
</td></tr>
<tr><td>Employee salary:: </td> <td><input type="text" name="salary">
</td></tr>
<tr><td colspan="2"><input type="submit" value="register"> </td> </tr>
</table>
</form>
</body>
</html>
result.jsp
==========
<center>

<h1 style="color: red; text-align: center">Result page</h1>
<b>form data :: ${employee} </b> <br> <a href="./">home</a>

</center>
If we use HTML Forms, then by default we will have support only for
"OneWayBinding".[Form to Model class Object]
To get the support of TwoWayBinding then we need to go for "SpringMVC jsp
taglibraries".[Form->Model, Model->Form]
SpringMVC taglibrary
===================
1. Generic Taglibrary

<%@ taglib prefix="form" uri="http://www.springframework.org/tags" %>

2. Form tag library

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"

%>

refer:: BootMVCPro6-DataBindingAppUsingSpringTagLibrary
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" isELIgnored="false"%>

Home.jsp
========
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
</head>
<body>
<center>
<h1 style="color: red; text-align: center;">Employee Registration
Page</h1>
<form:form method ="POST" modelAttribute="emp">
<table>
<tr>
<th>ENO</th>
<td><form:input path='eno' /></td>
</tr>
<tr>
<th>ENAME</th>
<td><form:input path='ename' /></td>
</tr>
<tr>
<th>EDESG</th>
<td><form:input path='edesg' /></td>
</tr>
<tr>
<th>SALARY</th>
<td><form:input path='salary' /></td>
</tr>
<tr>
<td></td>
<td><input type='submit' value='register'></td>
</tr>
</table>
</form:form>
</center>
</body>
</html>
Employee.java
=============
@Data
public class Employee {
private Integer eno;
private String ename="sachin";
private String edesg;
private Double salary;
}
EmloyeeController.java
======================
@Controller
public class EmployeeController {
@GetMapping("/register")
public String showForm(@ModelAttribute("emp") Employee employee) {

return "home";
}
@PostMapping("/register")
public String registerEmployee(Map<String, Object> model,
@ModelAttribute("emp") Employee employee) {

System.out.println("EmployeeController.registerEmployee()");
System.out.println(employee);
model.put("employee", employee);
return "result";
}
}
result.jsp
==========
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<h1 style='color:red; text-align: center;'>EMPLOYEE DATA</h1>
<table border='1'>
<tr>
<th>ENO</th>
<td>${employee.eno}</td>
</tr>
<tr>
<th>ENAME</th>
<td>${employee.ename}</td>
</tr>
<tr>
<th>EDESG</th>
<td>${employee.edesg}</td>
</tr>
<tr>
<th>SALARY</th>
<td>${employee.salary}</td>
</tr>
</table>
</center>
</body>
</html>
What is the difference b/w HTML Tags vs SpringMVC jsp tags?
HTML tags
=========
a. Supports one way binding(Form -> Model)
b. Given by W3C
c. Defult request method type is "GET"
d. These tags are executed by HTML interpreter
e. Not recomended to use in SpringMVC
SpringMVC jsp tags

=================
a. Supports two way binding(Form-> Model,Model-> Form)
b. Given by Pivotal team
c. Default request method type is "POST"
d. JSP tags will be converted to HTML tags having the values collected from Model
object as th initial values
e. Recomended to use in SpringMVC
DataBinding using @RequestParam
===============================
=> The request param in the query string either directly or by using hyperlink can
be bound to handler method params of controller class
by using the support of "@RequestParam" Annotation.

case1::http://localhost:9999/DataBindingApp/data?sno=10
@GetMapping("/data")
public String bindData(Map<String, Object> model, @RequestParam Integer
sno,@RequestParam String sname) {

System.out.println("DataBindingController.bindData()");
System.out.println("SNO is :: "+sno);
System.out.println("SNAME is :: "+sname);
return "show_data";

}
output:: Exception
case2:: http://localhost:9999/DataBindingApp/data?sno=10
@GetMapping("/data")
public String bindData(Map<String, Object> model, @RequestParam Integer
sno,@RequestParam(required = false)String sname) {

System.out.println("DataBindingController.bindData()");
System.out.println("SNO is :: "+sno);
System.out.println("SNAME is :: "+sname);
return "show_data";

}
output:: sno = 10 sname =
case3::http://localhost:9999/DataBindingApp/data?sno=10
@GetMapping("/data")
public String bindData(Map<String, Object> model, @RequestParam Integer
sno,@RequestParam(defaultValue="sachin") String sname) {

System.out.println("DataBindingController.bindData()");
System.out.println("SNO is :: "+sno);
System.out.println("SNAME is :: "+sname);
return "show_data";

}
output : sno = 10 sname=sachin
