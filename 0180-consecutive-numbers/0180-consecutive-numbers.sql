# Write your MySQL query statement below

# select distinct(num) as consecutivenums
# from logs
# where (id-1, id, id+1) in (select id from)



select distinct(l1.num) as consecutivenums
from logs l1
join logs l2
on l1.num = l2.num and l1.id+1 = l2.id
join logs l3
on l1.num = l3.num and l1.id+2 = l3.id
