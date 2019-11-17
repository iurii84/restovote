# restovote (in-progress...)
Design and implement a REST API using Hibernate/Spring/SpringMVC (or Spring-Boot) without frontend.
The task is:

Build a voting system for deciding where to have lunch.

2 types of users: admin and regular users
Admin can input a restaurant and it's lunch menu of the day (2-5 items usually, just a dish name and price)
Menu changes each day (admins do the updates)
Users can vote on which restaurant they want to have lunch at
Only one vote counted per user
If user votes again the same day:
If it is before 11:00 we assume that he changed his mind.
If it is after 11:00 then it is too late, vote can't be changed
Each restaurant provides new menu each day.

As a result, provide a link to github repository.

It should contain the code and README.md with API documentation and curl commands to get data for voting and vote.


## Realisation
**1.** First, the users have to register
```
curl -X POST -H "Content-type: application/json" -d '{
      "name": "Steve Jobs",
      "email": "steve@jobs.com",
      "password": "stevespassword"
   }' 'http://localhost:8080/restovote/user'
   ```
   By default all users are not authorised by Admin and belongs to **ROLE_USER** group
   
**2.**   After, Admin has to authorise the new users:
```
curl -X POST \
  http://localhost:8080/restovote/admin/users/authorise/3 \
  -H 'Authorization: Basic aXVyaWlAZ21haWwuY29tOjEyMzEyMzEyMw==' \
  -H 'Content-Type: application/json' \
```

**3.** This time, Admin create new restaurants
```
curl -X POST \
  http://192.168.0.110:8080/restovote/resto \
  -H 'Authorization: Basic aXVyaWlAZ21haWwuY29tOjEyMzEyMzEyMw==' \
  -H 'Content-Type: application/json' \
  -d '{
      "name": "my new super-puper restaurant"
 }'
```

**4.** After the participating restaurants are created - Admin create the meals, that belongs to restaurants.
```
curl -X POST \
  'http://localhost:8080/restovote/admin/meal?restoId=2' \
  -H 'Authorization: Basic aXVyaWlAZ21haWwuY29tOjEyMzEyMzEyMw==' \
  -H 'Content-Type: application/json' \
  -d '{
      "description": "superMeal2",
      "price": 187
   }'
```
**5.** Users can see all participating restaurants
**6.** Users now can see the menu of each restaurant