# Simple Task #1

> *hint: This can be tested with Postman or preferable by creating a unit test  
> When you're creating a unit test, it might help to use MockMvc   
help: https://spring.io/guides/gs/testing-web/*

## Task:
Create a simple REST-API that returns a JSON with an array of objects wit the following data: 


> Firstname: Anna  
> Lastname: Hansen  
> Age: 28  
> Citizenship: Danish
> 
> Firstname: Mark  
> Lastname: Eriksen  
> Age: 30  
> Citizenship: Norwegian
>
> Firstname: Fritz  
> Lastname: Petersen  
> Age: 48  
> Citizenship: German

The REST-API must be secured with Basic Authentication. 

Use the following credentials

> Username: admin  
> Password: admin


## Extra Task:

Create a simple REST-API that receives the generated JSON of the first task and puts the data into POJOs and prints them 
well formatted to the console. 

