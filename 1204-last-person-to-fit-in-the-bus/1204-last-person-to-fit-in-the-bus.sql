# Write your MySQL query statement below


# without using limit

select person_name from queue
where turn = 
(
    select max(turn) from 
    (
        select f.turn, sum(s.weight) as weight
        from queue f
        join queue s
        on f.turn >= s.turn
        group by f.turn
        having sum(s.weight) <= 1000
    ) as mxturn
);




# # using limit

# select f.person_name
# from queue f
# join queue s
# on f.turn >= s.turn
# group by f.person_id
# having sum(s.weight)<=1000
# order by sum(s.weight) desc
# limit 1