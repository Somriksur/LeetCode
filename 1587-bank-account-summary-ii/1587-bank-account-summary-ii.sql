/* Write your PL/SQL query statement below */

SELECT name, SUM(amount) AS balance
FROM Users JOIN Transactions ON Users.account = Transactions.account
GROUP BY name
HAVING balance > 10000;