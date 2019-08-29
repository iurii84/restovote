DROP TABLE IF EXISTS winners;
DROP TABLE IF EXISTS meals;
DROP TABLE IF EXISTS restaurants;
DROP TABLE IF EXISTS userRoles;
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
    id        BIGINT      NOT NULL AUTO_INCREMENT,
    name      VARCHAR(30) NOT NULL,
    createdBy BIGINT      NOT NULL,
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

CREATE TABLE userRoles
(
    userId BIGINT      not null,
    role   VARCHAR(20) NOT NULL,
    CONSTRAINT user_roles_idx UNIQUE (userId, role),
    FOREIGN KEY (userId) REFERENCES users (id) ON DELETE CASCADE
) ENGINE = InnoDB;

ALTER TABLE meals
    ADD FOREIGN KEY (restoId) REFERENCES restaurants (id),
    ADD FOREIGN KEY (userId) REFERENCES users (id);


ALTER TABLE restaurants
    ADD FOREIGN KEY (createdBy) REFERENCES users (id);