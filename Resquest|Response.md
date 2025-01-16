### HTTP Request Explanation

An **HTTP request** is made by a client (e.g., a web browser or a tool like Postman) to a server to perform a specific action. It consists of the following parts:

1. **Start Line**: Indicates what the client wants to do.
   - **HTTP Method**: Defines the action (e.g., `GET`, `POST`, `PUT`, `DELETE`).
   - **URI**: The resource's path the client wants to interact with (e.g., `/skiServ/dataVerifier`).
   - **HTTP Version**: Specifies the version of the protocol (e.g., `HTTP/1.1`).

   Example: `POST /skiServ/dataVerifier HTTP/1.1`

2. **Headers**: Provide additional information about the request.
   - Format: `Key: Value`
   - Example: `Content-Type: application/x-www-form-urlencoded`

3. **Body**: Contains data sent to the server (only for `POST` and `PUT` requests).
   - **GET** and **DELETE** requests do not have a body.

   Example body for a `POST` request:
   ```
   username=john&password=12345
   ```

### HTTP Response Explanation

An **HTTP response** is sent from the server back to the client, indicating the outcome of the request. It consists of:

1. **Start Line**: Provides the status of the response.
   - **HTTP Version**: Specifies the version of the protocol used (e.g., `HTTP/1.1`).
   - **Status Code**: Indicates the result of the request (e.g., `200 OK` means success).
   - **Status Message**: Human-readable message corresponding to the status code.

   Example: `HTTP/1.1 200 OK`

2. **Headers**: Provide metadata about the response.
   - Format: `Key: Value`
   - Example: `Server: Apache-Coyote/1.1`

3. **Body**: Contains the data returned by the server, which could be an HTML page, JSON data, etc.
   - Example body for a response returning HTML content:
   ```html
   <html>
     <body>
       <h1>Success</h1>
     </body>
   </html>
   ```

### Example

#### HTTP Request (POST):
```
POST /skiServ/dataVerifier HTTP/1.1
Content-Type: application/x-www-form-urlencoded
Content-Length: 27

username=john&password=12345
```

#### HTTP Response:
```
HTTP/1.1 200 OK
Server: Apache-Coyote/1.1
Content-Type: text/html

<html>
  <body>
    <h1>Success</h1>
  </body>
</html>
```
