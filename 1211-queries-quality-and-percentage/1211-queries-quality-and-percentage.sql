# Write your MySQL query statement below


select query_name, round(avg(rating/position), 2) as quality,
round(avg(rating<3)*100, 2) as poor_query_percentage
from queries
where query_name is not null
group by query_name


# select query_name, round(avg(rating/position), 2) as quality,
# round(sum(if(rating<3, 1, 0)) *100 / count(rating), 2) as poor_query_percentage
# from queries
# where query_name is not null
# group by query_name