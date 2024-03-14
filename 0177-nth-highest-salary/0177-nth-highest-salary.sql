CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN

  RETURN (
      # Write your MySQL query statement below.
      
      WITH CTE AS
        (
            SELECT DISTINCT salary,
            DENSE_RANK() OVER(ORDER BY salary DESC) AS dr
            FROM Employee
        )
        
        SELECT salary 
        FROM CTE
        WHERE dr = N
        
      
      
  );
END