SELECT DISTINCT s.product_id, p.product_name
FROM Product p
LEFT JOIN Sales s ON p.product_id = s.product_id
WHERE
    sale_date BETWEEN '2019-01-01' AND '2019-03-31'
    AND s.product_id NOT IN (
        SELECT product_id
        FROM sales
        WHERE sale_date NOT BETWEEN '2019-01-01' AND '2019-03-31'
    );