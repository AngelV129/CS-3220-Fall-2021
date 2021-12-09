drop table if exists students;
drop table if exists student_groups;



-- group table
create table student_groups (
    id          integer auto_increment primary key,
    name        varchar(255) unique not null,
    max_size    integer default 5
);

insert into student_groups (name) values ('Minnows');
insert into student_groups (name) values ('Dolphins');
insert into student_groups (name) values ('Guppies');

-- stidents tble
create table students (
    id              integer auto_increment primary key,
    name            varchar(255) not null,
    birth_year      integer,
    parent_name     varchar(255),
    parent_email    varchar(255),
    group_id        integer references student_groups(id)
);

insert into students values (1, 'John', 2017, 'Sue', 'sue@gmail.com', 1);
-- insert into students values (5, 'John', 2017, 'Sue', 'sue@gmail.com', 1);
-- insert into students values (6, 'John', 2017, 'Sue', 'sue@gmail.com', 1);
-- insert into students values (7, 'John', 2017, 'Sue', 'sue@gmail.com', 1);
insert into students values (2, 'Jane', 2012, 'Sue', 'sue@gmail.com', 2);
insert into students values (3, 'Luke', 2016, 'Steve', 'steve@gmail.com', 1);
insert into students values (4, 'Tina', 2014, 'Paula', 'paula@gmail.com', null);


-- 1. Find the names of the students who are not in any group.
SELECT s1.name FROM students s1 LEFT JOIN student_groups sg
    on s1.group_id = sg.id
    WHERE s1.group_id is NULL;


-- 2. Find the names of the students who are in the group Minnows.
SELECT s1.name FROM students s1 INNER JOIN student_groups sg
    on s1.group_id = sg.id
    WHERE sg.name="Minnows";


-- 3. List the name, age, parent name, and parent email of the students. 
-- The column names of the results should be Name, Age, Parent, and Email. Note that age is calculated as (current year - birth year).

SELECT s1.name as Name, 
2021 - s1.birth_year as Age,
s1.parent_name as Parent,
s1.parent_email as Email FROM students s1; 

-- 4. List the names of the students and the name of the group each student is in. 
-- The column names of the results should be Student Name and Group Name. If a student is not in a group, the group name column should show NULL.
SELECT s1.name "Student Name",
    IF(s1.group_id IS NOT NULL, sg.name, NULL)  "Group Name" 
    FROM students s1 LEFT JOIN student_groups sg on s1.group_id = sg.id
    WHERE s1.group_id = sg.id OR s1.group_id is NULL;

-- 5. List the names of the groups and the number of students in each group. 
-- The result should show 0 for groups that do not have any students.
SELECT sg.name as Group_Name, COUNT(s1.group_id) "Number_of_Members"
    FROM student_groups sg, students s1 
    WHERE sg.id = s1.group_id OR s1.group_id IS NULL
    GROUP BY sg.name;
    


-- 6. Find the names of the groups that are not full. A group is not full if the number of students in the group is less than its max size. 
-- HINT: first write a query to get the group name, max size, and the number of students in each group, 
-- then use this query as a subquery and select the groups whose max size is greater than the number of students.

SELECT 
    IF(COUNT(s1.group_id) < sg.max_size, sg.name, NULL) as Group_Name
    FROM student_groups sg, students s1 
    WHERE sg.id = s1.group_id OR s1.group_id IS NULL 
    GROUP BY sg.name
    HAVING Group_Name IS NOT NULL;