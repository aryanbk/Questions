# Write your MySQL query statement below

select p.product_id, coalesce(round(sum(p.price * u.units) / sum(u.units), 2), 0) as average_price
from prices p
left join unitssold u
on p.product_id = u.product_id and DATEDIFF(end_date, purchase_date) >= 0 and DATEDIFF(start_date, purchase_date)<=0
group by p.product_id;