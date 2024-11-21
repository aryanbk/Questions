# Write your MySQL query statement below

select round(sum(tiv_2016), 2) as tiv_2016
from
insurance
where
(tiv_2015, 1) not in (select tiv_2015, count(*) as cnt from insurance group by tiv_2015)
and
(lat, lon, 1) in (select lat, lon, count(*) as cnt from insurance group by lat, lon)