-- 1. List the last names of the employees whose ids are less than 10
--    in descending order.

select distinct last_name from employees where id < 10
    order by last_name desc;

-- 2. Find the id of Jane Doe.

select id from employees where first_name = 'Jane' and last_name = 'Doe';

-- 3. Find the names of the employees who do not have a supervisor.

select concat(first_name, ' ', last_name) as 'Full Name' from employees
    where supervisor_id is null;

-- 4. List the employees who work on the project with id=1.

select concat(e.first_name, ' ', e.last_name) as Name
    from employees e, project_members m
    where e.id = m.member_id and m.project_id = 1;

select concat(e.first_name, ' ', e.last_name) as Name
    from employees e inner join project_members m on e.id = m.member_id
    where m.project_id = 1;
    
-- 5. List the employees who work on the project Blue

select concat(e.first_name, ' ', e.last_name) as Name
    from employees e, project_members m, projects p
    where e.id = m.member_id and m.project_id = p.id
    and p.name = 'Blue';

select concat(e.first_name, ' ', e.last_name) as Name from employees e
    inner join project_members m on e.id = m.member_id
    inner join projects p on m.project_id = p.id
    where p.name = 'Blue';

-- 6. Find the name of Jane Doe’s supervisor

select concat(e2.first_name, ' ', e2.last_name) as Name
    from employees e1, employees e2
    where e1.first_name = 'Jane' and e1.last_name = 'Doe'
    and e1.supervisor_id = e2.id;

select concat(e2.first_name, ' ', e2.last_name) as Name
    from employees e1 inner join employees e2 on e1.supervisor_id = e2.id
    where e1.first_name = 'Jane' and e1.last_name = 'Doe';

-- 7. Find the employees who are not working on any project.

select concat(e.first_name, ' ', e.last_name) as Name
    from employees e left join project_members m on e.id = m.member_id
    where m.project_id is null;

select concat(e.first_name, ' ', e.last_name) as Name
    from project_members m right join employees e on e.id = m.member_id
    where m.project_id is null;

-- 8. Find the number of employees whose last name is Doe

select count(id) from employees where last_name = 'Doe';

select count(*) from employees where last_name = 'Doe';

-- 9. List the number of employees for each project

select p.name, count(m.member_id) from projects p
    inner join project_members m on p.id = m.project_id
    group by p.name
    order by count(m.member_id) asc;

-- 10. List the number of projects each employee works on

select concat(e.first_name, ' ', e.last_name) as Name, count(m.project_id)
    from employees e left join project_members m on e.id = m.member_id
    group by Name;

