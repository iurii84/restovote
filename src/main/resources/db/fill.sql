DELETE
FROM meals;
DELETE
FROM restaurants;
DELETE
FROM users;
DELETE
FROM winners;




INSERT INTO users(id, name, email, password, restoId, dateTimeOfVote)
VALUES (1, 'Iuri', 'iurii@gmail.com', '123', 2, '2019-07-22 21:10:07'),
       (2, 'Tanea', 'tanea@gmail.com', '321', 1, '2019-07-22 19:15:48');

INSERT INTO restaurants (id, name, createdBy)
VALUES (1, 'Super Resto', 1),
       (2, 'Super++ Resto', 1);

INSERT INTO meals(id, description, price, restoid, userid)
VALUES (1, 'eggs', 130, 1, 1),
       (2, 'super breakfast', 340, 2, 1),
       (3, 'breakfast in resto id1', 500, 1, 1);

INSERT INTO winners(id, date)
VALUES (2, '2019-07-05'),
       (1, '2019-07-14');