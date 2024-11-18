# Write your MySQL query statement below
select tod.id from weather tod join weather yest
on DATEDIFF(tod.recorddate, yest.recorddate) = 1 
where tod.temperature > yest.temperature;