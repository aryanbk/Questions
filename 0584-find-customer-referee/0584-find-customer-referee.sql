# Write your MySQL query statement below

# select name from Customer where referee_id <> 2 or referee_id is null;


# here COALESCE is used to replace NULL values with zero before checking whether it is equal to 2 or not.
select name from Customer where coalesce(referee_id, 0) <> 2;