## Understanding HTTP Versions

The HyperText Transfer Protocol (HTTP) is a foundation of data communication for the World Wide Web. It allows for the transfer of information from a web server to a client (usually a web browser). Over time, HTTP has evolved through several versions, each improving upon the last to enhance performance, security, and functionality. This guide explores the different versions of HTTP, their key features, and their impact on web communication.

### What is HTTP?

HTTP (HyperText Transfer Protocol) is a protocol used for transferring hypertext requests and information on the internet. It is a request-response protocol where a client sends a request to a server, which then sends back a response. HTTP operates primarily over TCP/IP.

### Key HTTP Versions:

#### 1. HTTP/0.9

- **Introduced**: 1991
- **Purpose**: The first version of HTTP, designed for simple data exchange.
- **Key Features**:
  - Only supported GET method.
  - No HTTP headers or status codes.
  - Limited to transferring plain text.
  
#### 2. HTTP/1.0

- **Introduced**: 1996
- **Purpose**: To support more features and functionality than HTTP/0.9.
- **Key Features**:
  - Introduction of request and response headers.
  - Support for various HTTP methods: GET, POST, and HEAD.
  - Status codes and metadata were introduced.
  - Each request required a separate connection (non-persistent connections).

#### 3. HTTP/1.1

- **Introduced**: 1997
- **Purpose**: To improve upon HTTP/1.0 by addressing performance issues.
- **Key Features**:
  - **Persistent Connections**: Allowed multiple requests and responses to be sent over a single TCP connection.
  - **Chunked Transfers**: Enabled sending data in chunks, useful for dynamically generated content.
  - **Host Header**: Allowed hosting multiple domains on a single IP address.
  - **Pipelining**: Enabled sending multiple requests without waiting for each response, though not widely adopted due to implementation issues.

#### 4. HTTP/2

- **Introduced**: 2015
- **Purpose**: To enhance speed and efficiency, addressing limitations of HTTP/1.1.
- **Key Features**:
  - **Binary Protocol**: Unlike HTTP/1.1's text-based format, HTTP/2 uses a binary format for more efficient parsing.
  - **Multiplexing**: Allows multiple streams over a single connection, reducing latency.
  - **Header Compression**: Reduces overhead by compressing headers, especially for repeated headers across multiple requests.
  - **Server Push**: Enables the server to send resources proactively to the client.

#### 5. HTTP/3

- **Introduced**: 2020 (Standardised)
- **Purpose**: To further improve performance, particularly for connections over unreliable networks.
- **Key Features**:
  - **QUIC Protocol**: Uses QUIC (Quick UDP Internet Connections) instead of TCP for faster handshakes and better performance on lossy networks.
  - **Improved Security**: Built-in encryption with TLS 1.3, reducing latency associated with secure connections.
  - **Stream-Level Flow Control**: Improved handling of multiple streams over a single connection without the risk of one blocking others.

### Visualisation of HTTP Evolution:

```
HTTP/0.9   ----->  Simple data exchange, only GET method
HTTP/1.0   ----->  Introduced headers, status codes, multiple methods
HTTP/1.1   ----->  Persistent connections, chunked transfers, host header
HTTP/2     ----->  Binary protocol, multiplexing, header compression
HTTP/3     ----->  QUIC protocol, improved security, stream-level flow control
```

### Example Scenarios:

#### HTTP/1.1:

**Scenario**: Loading a website with multiple images.

- **Process**: The browser opens a connection to the server, sends a request for the webpage, and keeps the connection open for additional resources (like images).
- **Benefit**: Reduces the overhead of opening a new connection for each resource.

#### HTTP/2:

**Scenario**: Loading a complex web application with many resources (CSS, JavaScript files).

- **Process**: The browser sends multiple requests over a single connection using multiplexing, reducing load times.
- **Benefit**: Faster page loads due to reduced latency and overhead.

### Key Concepts:

- **Request-Response Cycle**: Client sends a request, server processes it, and sends back a response.
- **Headers**: Provide metadata about the request or response (e.g., content type, status codes).
- **Methods**: Actions to be performed on the resource (e.g., GET, POST).
- **Status Codes**: Indicate the result of the HTTP request (e.g., 200 OK, 404 Not Found).



