# Write your MySQL query statement below
select max(m) as num from
(select max(num) as m from mynumbers
group by num
having count(num)=1) as a