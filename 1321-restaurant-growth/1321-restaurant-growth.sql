# Write your MySQL query statement below

select f.visited_on, sum(s.amount) as amount, round(avg(s.amount), 2) as average_amount
from 
(select distinct(visited_on) as visited_on from customer group by visited_on) f
join 
(select visited_on, sum(amount) as amount from customer group by visited_on) s
on f.visited_on >= s.visited_on 
and DATEDIFF(f.visited_on, s.visited_on) < 7
group by f.visited_on
having count(s.visited_on) = 7
order by f.visited_on