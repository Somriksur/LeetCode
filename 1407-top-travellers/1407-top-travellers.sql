# Write your MySQL query statement below
select u.name as name, if(sum(r.distance),sum(r.distance),0) as travelled_distance 
from users u 
left join rides r 
on u.id = r.user_id 
group by 1,r.user_id
order by travelled_distance desc,u.name asc