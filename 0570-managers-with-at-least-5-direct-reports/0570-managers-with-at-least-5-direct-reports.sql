# Write your MySQL query statement below

select f.name from employee f 
right join employee s
on f.id = s.managerid
group by f.id
having count(f.id) > 4;


# select f.name from employee f 
# right join employee s
# on f.id = s.managerid
# group by s.managerid
# having count(f.id) > 4;