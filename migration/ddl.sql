CREATE TABLE Employee (
    id int PRIMARY KEY,
    first_name varchar(50),
    last_name varchar(50),
    email varchar(50) UNIQUE NOT NULL,
    phone bigint
);


