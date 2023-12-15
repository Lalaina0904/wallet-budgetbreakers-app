CREATE OR REPLACE FUNCTION credit_and_debit_amount_sum(
IN account_id INT,
IN start_date TIMESTAMP,
IN end_date TIMESTAMP
)
RETURNS TABLE(entry DECIMAL,expense DECIMAl) AS $$
BEGIN
RETURN QUERY
SELECT
    SUM (CASE WHEN transaction_type='credit' THEN amount ELSE 0 END) as entry,
    SUM (CASE WHEN transaction_type='debit' THEN amount ELSE 0 END) as expense
FROM transaction where transaction.id_account=account_id
                   AND transaction_date BETWEEN start_date and end_date;
END;
$$ LANGUAGE plpgsql;


SELECT * FROM credit_and_debit_amount_sum(1, '2023-12-10', '2023-12-31');