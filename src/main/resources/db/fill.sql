DELETE
FROM meals;
DELETE
FROM restaurants;
DELETE
FROM users;
DELETE
FROM winners;



INSERT INTO users(id, name, email, password, authorisedByAdmin, restoId, dateTimeOfVote)
VALUES (1, 'Iuri Ostrikov', 'iurii@gmail.com', '{noop}123123123', TRUE, 2, '2019-07-22 21:10:07'),
       (2, 'Tatiana Tcaci', 'tanea@gmail.com', '{noop}321321321', TRUE, 1, '2019-07-22 19:15:48');

INSERT INTO userroles(role, userId)
VALUES ('ROLE_ADMIN', 1),
       ('ROLE_USER', 2);

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