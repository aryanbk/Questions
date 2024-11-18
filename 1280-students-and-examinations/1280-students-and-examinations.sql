# Write your MySQL query statement below
select st.student_id, student_name, sub.subject_name, count(e.student_id) as attended_exams
from students st
cross join subjects sub
left join examinations e
on st.student_id = e.student_id and e.subject_name = sub.subject_name
group by st.student_id, st.student_name, sub.subject_name
ORDER BY st.student_id, st.student_name, sub.subject_name






# # wont work
# select st.student_id, student_name, sub.subject_name, count(*) as attended_exams
# from students st
# cross join subjects sub
# left join examinations e
# on st.student_id = e.student_id and e.subject_name = sub.subject_name
# group by st.student_id, st.student_name, sub.subject_name
# ORDER BY st.student_id, st.student_name, sub.subject_name