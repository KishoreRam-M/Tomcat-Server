# HTTP (HyperText Transfer Protocol) Basics for Websites and Services

## Introduction

HTTP (HyperText Transfer Protocol) is a protocol used for transferring data over the web. It is the foundation for any data exchange on the Web, and it is a protocol used by web browsers to fetch websites and by web servers to serve them.

### HTTP vs. WebSockets

While HTTP is commonly used for general web traffic, WebSockets, which rely on TCP (Transmission Control Protocol), are used for more interactive, real-time communications. Before diving into WebSockets, understanding HTTP is essential.

### Other Protocols

Protocols like SMTP (Simple Mail Transfer Protocol) handle email but are not related to HTTP. For instance, Tomcat is a web server, not an email server, so it handles HTTP requests rather than SMTP.

## HTTP Basics

HTTP is built on top of TCP and operates as a request-response protocol. There are two primary types of messages in HTTP:

1. **Request**
2. **Response**

### HTTP Requests

- **Request Methods**: These are verbs indicating the desired action:
  - **POST**: Create
  - **GET**: Read
  - **PUT**: Update
  - **DELETE**: Delete

This forms the CRUD operations:

- **Create**: POST
- **Read**: GET
- **Update**: PUT
- **Delete**: DELETE

#### Depiction of a Request:

```plaintext
                  Request Message
Client ------------------------> Server

- URLs typed into the browser's input box or clicked hyperlinks typically generate GET requests.
- Forms submitted from a browser typically generate POST requests.
- Modern browsers usually only support GET and POST methods.
- RESTful web services support all four CRUD operations and are commonly used by programs rather than browsers.
```

### HTTP Responses

After receiving a request, the server sends back a response message:

```plaintext
                  Response Message
Client <------------------------ Server
```

#### Example:

- **URL**: `http://localhost:8080/kishoreramm.html`
  - **URI**: `/greet/kishoreramm.html`
  - **Method**: GET

When the client sends a GET request for `/greet/kishoreramm.html`, the server reads and returns the requested page.

### Stateless Nature of HTTP

HTTP is considered a stateless protocol, meaning it doesn’t retain information about previous requests. However, mechanisms like cookies and header elements help manage state across multiple requests. Web applications maintain state to support conversations across several requests and responses. Tomcat, for example, uses components like the 'session map' to help maintain state.

## Format of HTTP Requests and Responses

### HTTP Request Format

1. **Start Line**: Indicates the method, URI, and HTTP version.

   - Example: `POST /skiServ/dataVerifier HTTP/1.1`

2. **Headers**: Key/value pairs that provide additional information about the request.

   - Example: `Content-Type: application/x-www-form-urlencoded`

3. **Body**: Contains the data to be sent to the server. Only POST and PUT requests have a body, while GET and DELETE do not.

### HTTP Response Format

1. **Start Line**: Indicates the HTTP version, status code, and a short message.

   - Example: `HTTP/1.1 200 OK`

2. **Headers**: Key/value pairs that provide additional information about the response.

   - Example: `Server: Apache-Coyote/1.1`

3. **Body**: Contains the data returned by the server, such as HTML content, JSON, or other formats.

By understanding these fundamental concepts, you'll have a solid foundation to build more advanced web applications and services.
