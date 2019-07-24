DROP TABLE IF EXISTS winners;
DROP TABLE IF EXISTS meals;
DROP TABLE IF EXISTS restaurants;
DROP TABLE IF EXISTS users;

DROP TABLE IF EXISTS hibernate_sequence;

CREATE TABLE meals
(
    id          BIGINT       NOT NULL AUTO_INCREMENT,
    description VARCHAR(100) NOT NULL,
    price       BIGINT       NOT NULL,
    restoId     BIGINT       NOT NULL,
    userId      BIGINT       NOT NULL,
    PRIMARY KEY (id)
) ENGINE = InnoDB;

CREATE TABLE restaurants
(
    id   BIGINT      NOT NULL AUTO_INCREMENT,
    name VARCHAR(30) NOT NULL,
    PRIMARY KEY (id)
) ENGINE = InnoDB;

CREATE TABLE users
(
    id             BIGINT       NOT NULL AUTO_INCREMENT,
    name           VARCHAR(20)  NOT NULL,
    dateTimeOfVote DATETIME(6)  NOT NULL,
    email          VARCHAR(20)  NOT NULL,
    password       VARCHAR(100) NOT NULL,
    restoId        BIGINT       NOT NULL,
    PRIMARY KEY (id)
) ENGINE = InnoDB;

CREATE TABLE winners
(
    id   BIGINT NOT NULL AUTO_INCREMENT,
    date DATE   NOT NULL,
    PRIMARY KEY (id)
) ENGINE = InnoDB;

ALTER TABLE meals
    ADD FOREIGN KEY (restoId) REFERENCES restaurants (id),
    ADD FOREIGN KEY (userId) REFERENCES users (id);