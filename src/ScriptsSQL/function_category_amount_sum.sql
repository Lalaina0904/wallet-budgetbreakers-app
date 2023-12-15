CREATE OR REPLACE FUNCTION category_amount_sum(
    IN account_id INT,
    IN start_date TIMESTAMP,
    IN end_date TIMESTAMP
)
RETURNS TABLE(category_type VARCHAR(30), category_amount_sum DECIMAL) AS $$
BEGIN
    RETURN QUERY
    SELECT
        category.category_type,
        COALESCE(SUM(CASE WHEN transaction.amount IS NULL THEN 0 ELSE transaction.amount END), 0) AS category_amount_sum
    FROM category
    LEFT JOIN transaction ON transaction.id_category = category.id_category
        AND transaction.id_account = account_id
        AND transaction.transaction_date BETWEEN start_date AND end_date
    GROUP BY category.category_type;
END;
$$ LANGUAGE plpgsql;


SELECT * FROM category_amount_sum(1, '2023-12-10', '2023-12-31');