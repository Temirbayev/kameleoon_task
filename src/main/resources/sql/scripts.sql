-- CREATE database kameleoon;
--
-- drop table quote cascade;
--
-- drop table roles cascade;
--
-- drop table users_roles cascade;
--
-- drop table vote cascade;
--
-- drop table users cascade;


CREATE TABLE roles
(
    id   BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    role VARCHAR(255),
    CONSTRAINT pk_roles PRIMARY KEY (id)
);

CREATE TABLE users
(
    id           BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    name         VARCHAR(255),
    email        VARCHAR(255),
    password     VARCHAR(255),
    created_date date,
    CONSTRAINT pk_users PRIMARY KEY (id)
);

CREATE TABLE users_roles
(
    users_id BIGINT NOT NULL,
    roles_id BIGINT NOT NULL
);

ALTER TABLE users_roles
    ADD CONSTRAINT fk_userol_on_roles FOREIGN KEY (roles_id) REFERENCES roles (id);

ALTER TABLE users_roles
    ADD CONSTRAINT fk_userol_on_users FOREIGN KEY (users_id) REFERENCES users (id);




CREATE TABLE quote
(
    id            BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    content       VARCHAR(255),
    created_date  date,
    modified_date date,
    user_id       BIGINT,
    CONSTRAINT pk_quote PRIMARY KEY (id)
);

ALTER TABLE quote
    ADD CONSTRAINT FK_QUOTE_ON_USER FOREIGN KEY (user_id) REFERENCES users (id);

CREATE TABLE vote
(
    id        BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    vote_type VARCHAR(255),
    quote_id  BIGINT,
    users_id  BIGINT,
    CONSTRAINT pk_vote PRIMARY KEY (id)
);

ALTER TABLE vote
    ADD CONSTRAINT FK_VOTE_ON_QUOTE FOREIGN KEY (quote_id) REFERENCES quote (id);

ALTER TABLE vote
    ADD CONSTRAINT FK_VOTE_ON_USERS FOREIGN KEY (users_id) REFERENCES users (id);
-- ROLES
INSERT INTO roles (role) VALUES ('ROLE_USER');
INSERT INTO roles (role) VALUES ('ROLE_ADMIN');
-- USERS
INSERT INTO users (name, email, password, created_date)
VALUES ('qwe', 'qwe', '$2a$10$ZBjSJ1mqwLe8ax9o8/utUetcMQ9iFyZSsght4M00y3anfBd.rpKAm', CURRENT_DATE); -- password qwe
INSERT INTO users (name, email, password, created_date)
VALUES ('asd', 'asd', '$2a$10$LJ0f7EVyPEb9B/eYXWo7kuMa34QYAvWJfh0TsvsfO3cR/i1n1XbEi', CURRENT_DATE); -- password asd
--ROLES
INSERT INTO users_roles (users_id, roles_id) VALUES (1, 1); -- qwe получает роль ROLE_USER
INSERT INTO users_roles (users_id, roles_id) VALUES (1, 2); -- qwe получает роль ROLE_ADMIN
INSERT INTO users_roles (users_id, roles_id) VALUES (2, 2); -- asd получает роль ROLE_USER
--QUOTE
INSERT INTO quote (content, created_date, user_id) VALUES ('You must be the change you wish to see in the world.', CURRENT_DATE, 1);
INSERT INTO quote (content, created_date, user_id) VALUES ('Well done is better than well said.', CURRENT_DATE, 2);
INSERT INTO quote (content, created_date, user_id) VALUES ('Spread love everywhere you go. Let no one ever come to you without leaving happier..', CURRENT_DATE, 2);
INSERT INTO quote (content, created_date, user_id) VALUES ('Darkness cannot drive out darkness: only light can do that. Hate cannot drive out hate: only love can do that.', CURRENT_DATE, 2);
INSERT INTO quote (content, created_date, user_id) VALUES ('Do one thing every day that scares you.', CURRENT_DATE, 2);
INSERT INTO quote (content, created_date, user_id) VALUES ('Well done is better than well said.', CURRENT_DATE, 1);
--VOTE
INSERT INTO vote (vote_type, quote_id, users_id) VALUES ('UPVOTE', 1, 1);
INSERT INTO vote (vote_type, quote_id, users_id) VALUES ('DOWNVOTE', 1, 2);