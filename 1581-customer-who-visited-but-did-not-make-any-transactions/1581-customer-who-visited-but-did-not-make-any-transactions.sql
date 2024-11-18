# Write your MySQL query statement below
select customer_id, count(*) as count_no_trans
from visits 
left join transactions
on transactions.visit_id = visits.visit_id 
where transaction_id is null
group by customer_id;