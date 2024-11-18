# Write your MySQL query statement below
select s.user_id, round(avg(if(conf.action = "confirmed", 1, 0)), 2) as confirmation_rate
from signups s
left join confirmations conf
on conf.user_id = s.user_id
group by user_id;