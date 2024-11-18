# Write your MySQL query statement below

select round(count(player_id) / (select count(distinct(player_id)) from activity), 2) as fraction
from activity
where (player_id, DATE_ADD(event_date, interval -1 day)) in (select player_id, min(event_date) from activity group by player_id)