# spring-boot-data-mongo-db
Spring Boot MongoDB CRUD example with Maven

```
We will build a Spring Boot MongoDB Rest CRUD API for a Tutorial application in that:

Each Tutorial has id, title, description, published status.
Apis help to create, retrieve, update, delete Tutorials.
Apis also support custom finder methods such as find by published status or by title.

```
```
These are APIs that we need to provide:

Methods	Urls	Actions
POST	/api/tutorials	create new Tutorial
GET	/api/tutorials	retrieve all Tutorials
GET	/api/tutorials/:id	retrieve a Tutorial by :id
PUT	/api/tutorials/:id	update a Tutorial by :id
DELETE	/api/tutorials/:id	delete a Tutorial by :id
DELETE	/api/tutorials	delete all Tutorials
GET	/api/tutorials/published	find all published Tutorials
GET	/api/tutorials?title=[keyword]	find all Tutorials which title contains keyword

– We make CRUD operations & finder methods using Spring Data MongoDB.
– Rest Controller will be created with the help of Spring Web MVC.
```

```
Tutorial data model class corresponds to entity and table tutorials.
TutorialRepository is an interface that extends MongoRepository for CRUD methods and custom finder methods. It will be autowired in TutorialController.
TutorialController is a RestController which has request mapping methods for RESTful requests such as: getAllTutorials, createTutorial, updateTutorial, deleteTutorial, findByPublished…
Configuration for Spring Data MongoDB is in application.properties.
pom.xml contains dependencies for Spring Boot Web MVC and Spring Data MongoDB.

```


```
Our Data model is Tutorial with four fields: id, title, description, published.
In model package, we define Tutorial class.
```
```
@Document annotation helps us override the collection name by “tutorials”.
```
```
Let’s create a repository to interact with Tutorials from the database.
In repository package, create TutorialRepository interface that extends MongoRepository.
```
```
Now we can use MongoRepository’s methods: save(), findOne(), findById(), findAll(), count(), delete(), deleteById()… without implementing these methods.
```
```
We also define custom finder methods:
– findByTitleContaining(): returns all Tutorials which title contains input title.
– findByPublished(): returns all Tutorials with published having value as input published.

The implementation is plugged in by Spring Data MongoDB automatically.
```
```
Finally, we create a controller that provides APIs for creating, retrieving, updating, deleting and finding Tutorials.
```

```
– @CrossOrigin is for configuring allowed origins.
– @RestController annotation is used to define a controller and to indicate that the return value of the methods should be be bound to the web response body.
– @RequestMapping("/api") declares that all Apis’ url in the controller will start with /api.
– We use @Autowired to inject TutorialRepository bean to local variable.

```

```

*Create Operation*
We use @PostMapping annotation for handling POST HTTP requests.
A new Tutorial will be created by MongoRepository.save() method.
```

```
*Retrieve Operations*
We use @GetMapping annotation for handling GET HTTP requests, then Repository’s findAll(), findByTitleContaining(title), findByPublished() method to get the result.

getAllTutorials(): returns List of Tutorials, if there is title parameter, it returns a List in that each Tutorial contains the title
getTutorialById(): returns Tutorial by given id
findByPublished(): return published Tutorials
```
```
*Update Operation*
@PutMapping will help us handle PUT HTTP requests.
– updateTutorial() receives id and a Tutorial payload.
– from the id, we get the Tutorial from database using findById() method.
– then we use the payload and save() method for updating the Tutorial.
```
```
*Delete Operation*
We use @DeleteMapping for DELETE HTTP requests.
There are 2 methods:

deleteTutorial(): delete a Tutorial document with given id
deleteAllTutorials(): remove all documents in tutorials collection
The operations is done with the help of MongoRepository’s deleteById() and deleteAll() method.
```
