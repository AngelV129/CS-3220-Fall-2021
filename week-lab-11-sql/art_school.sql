drop table if exists students;
drop table if exists student_groups;

create table student_groups (
    id          integer auto_increment primary key,
    name        varchar(255) unique not null,
    max_size    integer default 5
);

insert into student_groups (name) values ('Minnows');
insert into student_groups (name) values ('Dolphins');
insert into student_groups (name) values ('Guppies');

create table students (
    id              integer auto_increment primary key,
    name            varchar(255) not null,
    birth_year      integer,
    parent_name     varchar(255),
    parent_email    varchar(255),
    group_id        integer references student_groups(id)
);

insert into students values (1, 'John', 2017, 'Sue', 'sue@gmail.com', 1);
insert into students values (2, 'Jane', 2012, 'Sue', 'sue@gmail.com', 2);
insert into students values (3, 'Luke', 2016, 'Steve', 'steve@gmail.com', 1);
insert into students values (4, 'Tina', 2014, 'Paula', 'paula@gmail.com', null);
