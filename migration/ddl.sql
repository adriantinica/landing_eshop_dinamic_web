CREATE TABLE members (
    id int PRIMARY KEY,
    first_name varchar(50),
    last_name varchar(50),
    phone varchar(50),
    email varchar(50) UNIQUE NOT NULL,
    password varchar (50) UNIQUE NOT NULL
);


