CREATE SCHEMA IF NOT EXISTS periodicals;


CREATE TABLE IF NOT EXISTS periodicals.users
(
    id              SERIAL    NOT NULL PRIMARY KEY,
    firstname       TEXT      NOT NULL,
    surname         TEXT      NOT NULL,
    email           TEXT      NOT NULL,
    phone           TEXT NOT NULL
    );


CREATE TABLE IF NOT EXISTS periodicals.periodicals
(
    id         SERIAL NOT NULL PRIMARY KEY,
    title TEXT   NOT NULL,
    body  TEXT,
    category   TEXT,
    created_date TIMESTAMP NOT NULL

);

CREATE TABLE IF NOT EXISTS periodicals.subscription
(
    id         SERIAL NOT NULL PRIMARY KEY,
    user_id    INT  NOT NULL,
    periodical_id    INT  NOT NULL,
    subscription_added_date TIMESTAMP NOT NULL,
    FOREIGN KEY (user_id) REFERENCES periodicals.user (id),
    FOREIGN KEY (periodical_id) REFERENCES periodicals.periodicals (id)

);

commit ;


