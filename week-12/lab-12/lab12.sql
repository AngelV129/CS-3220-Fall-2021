drop table if exists faculty;
drop table if exists department;

create table faculty (
    id              integer auto_increment primary key,
    name      varchar(255),
    is_chair BOOLEAN,
   department_id   integer references department(id)
);

INSERT INTO faculty (name, is_chair ,department_id) VALUES ('John', true, 1);
INSERT INTO faculty (name, is_chair, department_id) VALUES ('Angel', true, 2);
INSERT INTO faculty (name, is_chair, department_id) VALUES ('Manny', false, 1);



create table department (
     id              integer auto_increment primary key,
    name      varchar(255)
);

INSERT INTO department (name) VALUES ('Computer Science');
INSERT INTO department (name) VALUES ('MATH');

-- create table department_faculty (
--     department_id  integer references department(id),
--     faculty_id   integer references faculty(id),
-- );


-- Display Facutly queries
SELECT fa.name as faculty_name,
    fa.is_chair as chair,
    dp.name as department_name
    FROM faculty fa, department dp
    WHERE fa.department_id = dp.id
    ORDER BY dp.name;

-- -- Display only the departments
-- SELECT dp.name as department_name
--     FROM department dp;

-- -- Display a target deptartment
-- SELECT dp.id, dp.name as department_name FROM department dp WHERE dp.name="MATH";

-- -- delete a record
-- DELETE FROM faculty WHERE faculty.id = 4;