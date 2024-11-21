# Write your MySQL query statement below

select d.name as department, e1.name as employee, salary
from employee e1
join department d
on e1.departmentId = d.id
where 3 > (select count(distinct(salary)) from employee e2 where e2.salary > e1.salary 
and e1.departmentId = e2.departmentId)