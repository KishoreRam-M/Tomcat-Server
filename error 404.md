### Navigation Wrap-Up: The 404 Issue

When navigating within a web application, especially one packaged as a WAR (Web Application Archive) file, it's essential to understand how files and paths are structured and referenced. Missteps in navigation often lead to the common **404 'Not Found' error**, which occurs when the server cannot find the requested resource. Let's explore the causes and solutions to these navigation issues, using a sample web application structure as a reference.

---

### **Example Web Application Structure**

In this example, we have a web application deployed as `hi3.war` with the following structure:

```
hiTop.html    ## Welcome file at the top level
   |
+--+---------------------------+
|                              |
web-assets                 WEB-INF
  -- hiNested.html            | -- web.xml        ## Sets welcome file and aliases servlet
                            classes
                               |
                               p1
                                -- HiServlet.class ## Aliased as 'helloFromServlet'
```

### **Common Navigation Errors Leading to 404**

#### **Error in Linking to `hiNested.html`**

- **Original Link**:
  ```html
  <a href='web-assets/hiNested.html'>Nested hi</a>
  ```
  - This link correctly points to `hiNested.html` located in the `web-assets` subdirectory.

- **Modified Link**:
  ```html
  <a href='hiNested.html'>Nested hi</a>
  ```
  - **Issue**: The link now assumes `hiNested.html` is at the same directory level as `hiTop.html`, but it's actually in the `web-assets` subdirectory.
  - **Result**: Clicking this link results in a **404 error** because the server can't find `hiNested.html` at the expected location.

#### **Error in Linking to `hiTop.html`**

- **Original Link** (from `hiNested.html` to `hiTop.html`):
  ```html
  <a href='../hiTop.html'>Top-level hi</a>
  ```
  - This link uses a relative path to move up one directory level to reach `hiTop.html`.

- **Modified Link**:
  ```html
  <a href='hiTop.html'>Top-level hi</a>
  ```
  - **Issue**: The modified link assumes `hiTop.html` is within the `web-assets` subdirectory, leading to a navigation mismatch.
  - **Result**: A **404 error** occurs because `hiTop.html` is actually at the top level, not in `web-assets`.

---

### **Understanding the 404 Error**

The **404 'Not Found' error** is an HTTP response status code indicating that the server could not find the requested resource. This usually happens due to:

- Incorrect file paths in links.
- Files being moved or renamed without updating the references.
- Misconfigurations in the application's deployment structure.

### **Best Practices to Avoid Navigation Issues**

#### **Organising Files and Paths**

1. **Centralize Text Files**: 
   - Place all text files (HTML, stylesheets, JSP/JSF scripts) in the top-level directory of the deployed WAR file to simplify navigation and avoid path errors.

2. **Use Relative Paths Carefully**:
   - Ensure relative paths are accurately pointing to the correct directory level. For example:
     ```html
     <a href='web-assets/hiNested.html'>Nested hi</a>
     ```
   - Test all links after deployment to confirm they lead to the correct resources.

#### **Servlet Aliasing**

- **Alias Servlets in `web.xml`**:
  - Map servlet names to simpler URL patterns to make them easier to access and navigate.
  - Example `web.xml` entry:
    ```xml
    <servlet-mapping>
      <servlet-name>hiServlet</servlet-name>
      <url-pattern>/helloFromServlet</url-pattern>
    </servlet-mapping>
    ```
  - With this configuration, users can access `HiServlet` via `http://yourserver/helloFromServlet` instead of a longer, more complex URL.

#### **Testing and Validation**

- **Regular Testing**: 
  - Test navigation thoroughly in a development environment before deploying to production. This ensures that all paths are correct and no 404 errors will occur due to navigation issues.
- **Use Developer Tools**:
  - Most browsers have developer tools (accessible via F12) that can help track down 404 errors by showing which resources are not found and what paths were used.

---

### **Conclusion**

Effective navigation in web applications is crucial to ensure a seamless user experience. By understanding the structure of your application and carefully managing paths, you can avoid common issues like the 404 error. Centralizing files, using aliases for servlets, and thorough testing are key strategies to mitigate navigation problems. Following these best practices will help maintain a robust and user-friendly web application.