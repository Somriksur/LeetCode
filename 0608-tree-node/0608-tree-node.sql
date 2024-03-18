# Write your MySQL query statement below
select a.id,(
    case
    when a.p_id is null 
    then 'Root' 
    when exists(select  * from Tree t where t.p_id=a.id)
    then 'Inner'
    else 'Leaf' end
    ) AS type
from Tree a;