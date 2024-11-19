# Write your MySQL query statement below

select f.person_name
from queue f
join queue s
on f.turn >= s.turn
group by f.person_id
having sum(s.weight)<=1000
order by sum(s.weight) desc
limit 1