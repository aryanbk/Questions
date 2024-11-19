# Write your MySQL query statement below
select f.id, ifnull(s.student, f.student) as student
from seat f
left join seat s
on f.id = if(f.id%2=0, s.id+1, s.id-1)
order by f.id