DROP TABLE IF EXISTS questions CASCADE;
DROP TABLE IF EXISTS answers CASCADE;
DROP TABLE IF EXISTS users CASCADE;

CREATE TABLE users
(
    id       SERIAL PRIMARY KEY,
    name     VARCHAR(255) UNIQUE,
    password VARCHAR(80)
);

CREATE TABLE questions
(
    id          SERIAL PRIMARY KEY,
    title       VARCHAR(80),
    description VARCHAR(255),
    created     TIMESTAMP WITHOUT TIME ZONE,
    user_id     INT,
    FOREIGN KEY (user_id)
        REFERENCES users (id)
);

CREATE TABLE answers
(
    id          SERIAL PRIMARY KEY,
    answer      VARCHAR(255),
    question_id INT,
    user_id     INT,
    FOREIGN KEY (question_id)
        REFERENCES questions (id),
    FOREIGN KEY (user_id)
        REFERENCES users (id)
);

INSERT INTO users (name, password)
VALUES ('Siyar', 'tevedurumteve');
INSERT INTO users (name, password)
VALUES ('Zoli', 'taborialpha');
INSERT INTO users (name, password)
VALUES ('Dénes', 'questionman');
INSERT INTO users (name, password)
VALUES ('Marci', '1_10_11_100');


INSERT INTO questions (title, description, created, user_id)
VALUES ('Are camels polyamouros?', 'Hi guys, I recently fell in love with a camel and i was wondering if it was possible for him to return my love and affection.', localtimestamp, 1);
INSERT INTO questions (title, description, created, user_id)
VALUES ('Wath is the best OOP? With Regards, D.', 'Description.', localtimestamp, 3);

INSERT INTO answers (answer, question_id, user_id)
VALUES ('No.', 1, 2);
INSERT INTO answers (answer, question_id, user_id)
VALUES ('I have made out with a camel already, but I might have dreamed that.', 1, 4);
INSERT INTO answers (answer, question_id, user_id)
VALUES ('Check out this juicy video about it!', 2, 3);
