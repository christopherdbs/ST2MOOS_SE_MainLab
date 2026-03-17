
3.1 

It activates the use of JPA and its predefined functions which enables the linking of java objects to the sql tables using annotations. It then helps to manipulate the database correctly based on these links (with Hibernate).

3.2.2.1

ProgrammerRepository is an interface that extends JpaRepository. JpaRepository has already predefined functions (and queries inside it) like findAll() for CRUD operations that we can then use on the Programmer entity. As such we don't need to write anything for now in the ProgrammerRepository.

3.2.3.1 

The Entity class generated annotations such as @Entity, @Table, @Id, @GeneratedValue or even @Column. These annotations indicate the role of the different elements in the class. For example @Id indicatess that the attribute is the primary key. The @Table indicates and maps the sql table to which the java class is related to.
The annotations are what make the link between the java class and the sql tables and enables Hibernate to use them with the predefined functions such as findById.

4.1.1 

The predefined methods to retrieve all programmers is the findAll() method.

4.1.2 

Even if it is possible technically, it is not recommended here as we are implementing a "Service" class layer that will handle the interactions with the repository. It enables better organisation, more flexibility and respect the Single Responsibility Principle.

4.1.4 

In my opinion @Service is used to indicate that this class is a service which is good to clearly identify what is the role of this class and it will give the possibility to use specific context feature such as context dependency injection.

4.1.7

In relation to the multi-stack architecture diagram, we did most of it except the view. We implemented the controller, the service, and the persistence layer and we have a DB.

4.1.8

It is not a good practice. It is practical as it enables to get an instance of a class that has @Service annotation without having to worry about instantiating the object when the applicaiton runs. It works. But at certain specific times, for example in large applications. It might happen rarely to not access the instance and get a NullPointerException.
Using constructor injection helps to give this extra security as it ensures the object is fully initialized before use. That is why it is consider as a better practice.

4.5 

The difference between PUT and PATCH is that PUT updates the entire object while PATCH is for partial modification. It means that if we use PUT, if you send only partial modification and not the entire object updated, the other values could be erased and set to null. 


5.2
It gives this error : 
Error resolving template [programmers/1], template might not exist or might not be accessible by any of the configured Template Resolvers
I think it is because HTML formular only supports GET and POST, which is why we couldn't do a delete action directly in the browser during last TP. 
Instead it will just try to make a GET of the page as seen in the error.