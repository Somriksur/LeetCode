# Write your MySQL query statement below
Select product_id,"store1" store, store1 as price from Products where store1 is not NULL
union
Select product_id,"store2" store, store2 as price from Products where store2 is not NULL 
union
Select product_id,"store3" store, store3 as price from Products where store3 is not NULL