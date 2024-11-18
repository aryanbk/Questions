# # Write your MySQL query statement below

select distinct p.product_id, ifnull(temp.new_price, 10) as price
from products p
left join
    (select * from products 
     where (product_id, change_date) in
    (select product_id, max(change_date)
     from products 
     where change_date<='2019-08-16'
     group by product_id)) as temp
on p.product_id = temp.product_id