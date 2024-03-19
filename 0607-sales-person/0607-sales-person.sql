# Write your MySQL query statement below
SELECT DISTINCT sp.name
FROM SalesPerson sp
WHERE sp.sales_id NOT IN (
    SELECT o.sales_id
    FROM Orders o
    LEFT JOIN Company c ON o.com_id = c.com_id
    WHERE c.name = 'RED'
);