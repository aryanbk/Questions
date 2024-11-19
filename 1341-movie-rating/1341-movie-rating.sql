# Write your MySQL query statement below

select name as results from 
(
    select mr.user_id, u.name, count(rating) as cnt
    from movierating mr
    join users u
    on u.user_id = mr.user_id
    group by mr.user_id
    order by cnt desc, u.name
    limit 1
) as mxname

union all

select title as results from
(
    select m.movie_id, m.title, avg(rating) as rating
    from movierating mr
    join movies m
    on mr.movie_id = m.movie_id
    where DATE_FORMAT(created_at, '%Y-%m') = '2020-02'
    group by m.movie_id
    order by rating desc, m.title
    limit 1
) as mxrating