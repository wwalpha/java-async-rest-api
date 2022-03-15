# Asynchronous Rest API Sample

## Features
- Use H2 database to store status
	- maven dependency: com.h2database
- Auto create table
	- spring.jpa.properties
- Auto generate JPA classes
	- maven plugin
	
## Steps
- Start Application with Eclipse
- Run **`POST http://localhost:8080/create`** to get the new task id
- Run **`GET http://localhost:8080/status?id=XX`** to get the latest task status

## Sample with VSCode plugin

```
POST http://localhost:8080/create

Response:
HTTP/1.1 200 
Content-Type: text/plain;charset=UTF-8
Content-Length: 1
Date: Tue, 15 Mar 2022 03:27:55 GMT
Connection: close

1


GET http://localhost:8080/status?id=1

Reponse:
HTTP/1.1 200 
Content-Type: text/plain;charset=UTF-8
Content-Length: 6
Date: Tue, 15 Mar 2022 03:28:32 GMT
Connection: close

Finish
```