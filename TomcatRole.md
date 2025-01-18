**Tomcat and the Types of Web Applications It Can Handle**

### Understanding Tomcat's Role in Web Applications

**Tomcat: A Java-Centric Application Server**

Apache Tomcat is an open-source implementation of the Java Servlet, JavaServer Pages, and Java Expression Language technologies. It serves as a web container for running web applications written in Java. However, its capabilities extend beyond just Java-centric applications.

#### Java and Tomcat:
- **Java Language**: Java is a high-level programming language known for its portability across different platforms. Code written in Java is compiled into bytecode using `javac` (Java Compiler).
- **Java Virtual Machine (JVM)**: The JVM interprets bytecode and executes it on any device or operating system that has a JVM installed.

Tomcat, written in Java, operates by handling web applications that are compiled into JVM-compatible bytecode. This means it can manage applications written not only in Java but also in other languages that compile to JVM bytecode, such as JRuby (Ruby), Clojure, and Scala.

**Tomcat Extensions**
- **TomEE**: An extension of Tomcat, Apache TomEE integrates additional Java EE (Enterprise Edition) components like an EJB (Enterprise JavaBeans) container. This allows for more complex and high-level enterprise applications to be deployed as WAR (Web Application Archive) files.

### Types of Web Applications Tomcat Can Handle

Web applications served by Tomcat can be broadly classified into three categories: websites, web services, and web sockets. While these categories offer distinct functionalities, many modern web applications combine elements from all three.

#### 1. Websites
- **HTML-Centric**: Traditional websites primarily deliver static and dynamic HTML content to users. These sites often include various web assets such as documents, stylesheets (CSS), scripts (JavaScript), and images.
- **Example**: A company’s homepage with a blog section, image galleries, and contact forms.

#### 2. Web Services
- **Data and Functionality Providers**: Web services expose functionalities and data to other applications or services over the web. They often follow principles like REST (Representational State Transfer) or SOAP (Simple Object Access Protocol).
  - **REST**: Uses standard HTTP methods like GET, POST, PUT, DELETE to perform operations. It's widely used for its simplicity and scalability.
  - **SOAP**: A protocol that allows for the exchange of structured information in a platform-independent manner. It's known for its robustness in enterprise environments.
- **Example**: A REST API that provides weather data to various client applications.

#### 3. Web Sockets
- **Persistent Connections**: Unlike traditional HTTP connections, web sockets establish a persistent, bi-directional communication channel over a single TCP connection. This reduces the overhead associated with the request/response model of HTTP.
  - **Use Cases**: Real-time applications such as chat rooms, online gaming, live notifications, and financial tickers.
- **Example**: A live chat application that updates in real-time without needing to refresh the page.

### Mixed Use Cases in Deployed Web Applications

Modern web applications often blend these categories to provide rich and dynamic user experiences.

- **Chat Room Web Application**: Combines HTML content for the user interface with web sockets to enable real-time messaging.
- **E-commerce Website**: Contains HTML pages for product listings and utilizes web services for operations like fetching product details and processing payments. Web sockets might be used for features like live customer support.

### Example Web Applications

#### Example 1: Blog Platform
- **Components**:
  - Static HTML for blog posts.
  - REST APIs for fetching posts and user data.
  - Web sockets for real-time notifications about new comments or likes.

#### Example 2: Weather Dashboard
- **Components**:
  - HTML/CSS/JavaScript for the user interface.
  - RESTful web service to fetch weather updates.
  - Web sockets to push live weather alerts.

#### Example 3: Online Gaming Platform
- **Components**:
  - HTML for game interface.
  - Web services for player statistics and game settings.
  - Web sockets for real-time multiplayer interactions.

### Visualisation of Tomcat's Handling of Web Applications

**Diagram**:
```
               +------------------------+
               |      Apache Tomcat      |
               +------------------------+
                     /         |         \
                    /          |          \
       Websites (HTML)   Web Services   Web Sockets
          |                  |                |
  Static/Dynamic         REST/SOAP        Real-Time
   Content               APIs             Updates
```

In conclusion, Apache Tomcat is a versatile server capable of handling various types of web applications. Its Java-centric nature ensures broad compatibility, while its extensions and support for mixed application types make it a robust choice for modern web development.

**A Sample Web Service: predictionsRS**

### Overview of predictionsRS Web Service

**Description**:
The `predictionsRS` is a sample web service designed to demonstrate a simple RESTful service with no dependency on an external database. It uses the JAX-RS framework, specifically the Metro Jersey implementation, and the Jackson library for JSON processing.

### Key Components and Dependencies

**Dependencies**:
- **JAX-RS Implementation**: Metro Jersey, which provides tools to create RESTful web services.
  - **HTTP Verbs**: Supports standard CRUD operations:
    - **Create**: POST
    - **Read**: GET
    - **Update**: PUT
    - **Delete**: DELETE
- **JSON Library**: Jackson library is used for generating JSON responses.

### Contents of `predictionsRS.war`

**WAR File Structure**:
- **WEB-INF/web.xml**: Deployment descriptor for configuring the servlet.
- **Classes**:
  - `Prediction.class`: POJO class with `who` and `what` properties.
  - `PredictionsList.class`: Manages a list of `Prediction` instances.
  - `PredictionsRS.class`: Controller class for request dispatching.
  - `RestfulPrediction.class`: Connects with the Metro Jersey framework.
- **Data**:
  - `predictions.db`: Plaintext list of predictions.
- **Libraries**:
  - Jackson libraries (`jackson-annotations.jar`, `jackson-core.jar`, `jackson-databind.jar`).
  - Metro Jersey libraries (`jersey-core.jar`, `jersey-server.jar`, `jersey-servlet.jar`).

### Configuration File: web.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>  
<web-app>  
   <servlet>  
      <servlet-name>jersey</servlet-name>  
      <servlet-class>com.sun.jersey.spi.container.servlet.ServletContainer</servlet-class>  
      <load-on-startup>1</load-on-startup>
   </servlet>      
</web-app>  
```

### Testing with `curl` Commands

**Sample `curl` Commands**:
- **Read All Predictions**:
  ```bash
  curl --request GET http://localhost:8080/predictionsRS/resourcesP/json
  ```
- **Read Specific Prediction (in XML)**:
  ```bash
  curl --request GET http://localhost:8080/predictionsRS/resourcesP/xml/6
  ```
- **Create a New Prediction**:
  ```bash
  curl --request POST --data "who=TS Eliot&what=This is the way the world ends" \
       http://localhost:8080/predictionsRS/resourcesP/create
  ```
- **Delete a Prediction**:
  ```bash
  curl --request DELETE http://localhost:8080/predictionsRS/resourcesP/delete/33
  ```

This comprehensive overview of the `predictionsRS` web service highlights the practical implementation of RESTful principles using Tomcat and associated libraries.

