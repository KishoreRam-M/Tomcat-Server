### Navigation Basics for Deployed Web Applications

Navigating through a deployed web application involves understanding the structure of the web application and how different components, like HTML files, JSP/JSF scripts, servlets, and POJOs (Plain Old Java Objects), are accessed and managed. Let’s break down these concepts and explain how navigation works in a deployed web application, using simple language and examples.

---

### **Packed and Unpacked Deployment**

When a web application is deployed to a server like Tomcat, it can be in a **packed** or **unpacked** form:

1. **Packed Deployment**: The web application is packaged as a `.war` file (Web Application Archive), similar to a `.zip` file. It contains all the necessary files and directories compressed into one file.
2. **Unpacked Deployment**: The contents of the `.war` file are extracted into a directory structure on the server. This structure is hierarchical, resembling a local file system.

**Example of Unpacked Directory Structure**:
```
myApp/
   ├── index.html
   ├── about.jsp
   ├── WEB-INF/
   │   ├── web.xml
   │   ├── classes/
   │   │   └── com/
   │   │       └── example/
   │   │           └── MyServlet.class
   │   └── lib/
   └── images/
       └── logo.png
```

### **Navigation in Web Applications**

Navigating through the web application involves accessing different resources like HTML files, JSP scripts, servlets, and images through URLs.

1. **HTML and JSP/JSF Scripts**:
   - These files are accessed using URLs similar to navigating through local directories.
   - **Example**:
     - For an HTML file: `http://localhost:8080/myApp/index.html`
     - For a JSP file: `http://localhost:8080/myApp/about.jsp`

2. **Servlets**:
   - Servlets are Java classes that handle HTTP requests. They are deployed under the `WEB-INF/classes` directory.
   - They are typically not accessed directly using their class name but through an alias defined in the `web.xml` file.
   - **Example of `web.xml` entry**:
     ```xml
     <servlet>
         <servlet-name>MyServlet</servlet-name>
         <servlet-class>com.example.MyServlet</servlet-class>
     </servlet>
     <servlet-mapping>
         <servlet-name>MyServlet</servlet-name>
         <url-pattern>/myServlet</url-pattern>
     </servlet-mapping>
     ```
   - Accessing the servlet via URL: `http://localhost:8080/myApp/myServlet`

### **Servlets vs. POJOs**

1. **Servlets**:
   - **Definition**: Servlets are Java classes that extend the `HttpServlet` class and are designed to handle HTTP requests and responses.
   - **Navigation**: They can be accessed through URLs, making them HTTP endpoints.
   - **Example**: `http://localhost:8080/myApp/myServlet`

2. **POJOs**:
   - **Definition**: POJOs are regular Java objects used for business logic, data processing, or utility purposes. They are not designed to handle HTTP requests directly.
   - **Navigation**: POJOs are not accessed via URLs. They are used internally by servlets or other components of the application.

**Directory Structure for Servlets and POJOs**:
```
WEB-INF/
   ├── classes/
   │   ├── com/
   │   │   ├── example/
   │   │   │   ├── MyServlet.class  # Servlet
   │   │   │   └── Utility.class    # POJO
   │   │   └── anotherpackage/
   │   │       └── AnotherClass.class
   └── lib/
```

### **Using Aliases for Servlets**

To simplify navigation and make URLs more user-friendly, servlets are often given aliases in the `web.xml` file. This alias allows users to access the servlet using a simple URL path.

**Example of Alias in `web.xml`**:
```xml
<servlet>
    <servlet-name>MyServlet</servlet-name>
    <servlet-class>com.example.MyServlet</servlet-class>
</servlet>
<servlet-mapping>
    <servlet-name>MyServlet</servlet-name>
    <url-pattern>/simplePath</url-pattern>
</servlet-mapping>
```
**Accessing the servlet**: `http://localhost:8080/myApp/simplePath`

### **Key Points to Remember**

1. **Hierarchy**: The directory structure of a deployed web application follows a hierarchical format, with the `WEB-INF` directory being crucial for holding configuration files, classes, and libraries.
2. **Servlet Mapping**: Servlets need to be mapped in the `web.xml` file to be accessed via URLs.
3. **Difference Between Servlets and POJOs**:
   - Servlets handle HTTP requests and are mapped to URLs.
   - POJOs are utility classes used internally and not accessed via URLs.

### **Visual Aids**

- **Hierarchy of Web Application**:
  ```
  myApp/
     ├── index.html
     ├── about.jsp
     ├── WEB-INF/
     │   ├── web.xml
     │   ├── classes/
     │   │   └── com/
     │   │       └── example/
     │   │           └── MyServlet.class
     │   └── lib/
     └── images/
         └── logo.png
  ```

- **Servlet Mapping in `web.xml`**:
  ```xml
  <servlet>
      <servlet-name>MyServlet</servlet-name>
      <servlet-class>com.example.MyServlet</servlet-class>
  </servlet>
  <servlet-mapping>
      <servlet-name>MyServlet</servlet-name>
      <url-pattern>/myServlet</url-pattern>
  </servlet-mapping>
  ```

Understanding these navigation basics will help you manage and access different components of a web application efficiently, ensuring smooth user interaction and application functionality.