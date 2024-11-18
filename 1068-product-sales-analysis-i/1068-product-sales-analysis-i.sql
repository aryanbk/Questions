# Write your MySQL query statement below
select product_name, year, price from sales left join product on sales.product_id = product.product_id;