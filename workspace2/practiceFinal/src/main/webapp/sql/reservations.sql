drop Table if exists reservations;
drop Table if exists customer;


-- CREATE Table customer (
--     id          integer auto_increment primary key,
--     name        VARCHAR(255) NOT NULL,

-- );

-- CREATE Table reservations (
--     id Integer AUTO_INCREMENT PRIMARY KEY,
--     customer_id integer references customer(id),
--     day VARCHAR(4) NOT NULL,
--     start_time INTEGER NOT NULL,

-- );

CREATE Table reservations (
    id Integer AUTO_INCREMENT PRIMARY KEY,
    customer varchar(255) not null,
    day VARCHAR(10) NOT NULL,
    time VARCHAR(40) NOT NULL
);

INSERT INTO reservations VALUES (NULL, "Angel" ,"MON", "08:00-09:00");
INSERT INTO reservations VALUES (NULL, "John Lennon" ,"MON", "09:00-10:00");
INSERT INTO reservations VALUES (NULL, "BOB" ,"WED", "12:00-13:00");

SELECT * FROM reservations;

DELETE FROM reservations WHERE id = 1;