#API's

//To register new Role 
http:localhost:9090/createRole

//To register new User
http:localhost:9090/createUser

//To generate JWT Token
http:localhost:9090/authenticate



#Exceptions
601 = Header Received in the token is null.
602= token expired
603= User credentials sent for token generation are invalid 

