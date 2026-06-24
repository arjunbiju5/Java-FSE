--Scenario 1
DECLARE
    -- Cursor to select relevant customer loan details
    CURSOR c_senior_customers IS
        SELECT customer_id, loan_id, interest_rate 
        FROM customers c
        JOIN loans l ON c.customer_id = l.cust_id
        WHERE c.age > 60;
BEGIN
    FOR r_cust IN c_senior_customers LOOP
        -- Apply a 1% discount to the current interest rate
        UPDATE loans
        SET interest_rate = interest_rate - 0.01
        WHERE loan_id = r_cust.loan_id;
        
        DBMS_OUTPUT.PUT_LINE('Discount applied for Customer ID: ' || r_cust.customer_id || ', Loan ID: ' || r_cust.loan_id);
    END LOOP;
    
    COMMIT; -- Commit the changes after the loop completes
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK; -- Rollback in case of an error
        DBMS_OUTPUT.PUT_LINE('Error updating interest rates: ' || SQLERRM);
END;


--Scenario 2
DECLARE
    CURSOR c_high_balance IS
        SELECT customer_id, balance 
        FROM customers
        WHERE balance > 10000;
BEGIN
    FOR r_cust IN c_high_balance LOOP
        UPDATE customers
        SET IsVIP = TRUE  -- Adjust to 'Y' or 1 if IsVIP is a VARCHAR2 or NUMBER column
        WHERE customer_id = r_cust.customer_id;
        
        DBMS_OUTPUT.PUT_LINE('Customer ID: ' || r_cust.customer_id || ' promoted to VIP.');
    END LOOP;
    
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error updating VIP status: ' || SQLERRM);
END;


--Scenario 3
DECLARE
    -- Cursor to fetch loans due within the next 30 days
    CURSOR c_upcoming_loans IS
        SELECT c.customer_name, l.loan_id, l.due_date, l.amount_due
        FROM customers c
        JOIN loans l ON c.customer_id = l.cust_id
        WHERE l.due_date BETWEEN SYSDATE AND (SYSDATE + 30);
BEGIN
    DBMS_OUTPUT.PUT_LINE('--- LOAN DUE REMINDERS ---');
    
    FOR r_loan IN c_upcoming_loans LOOP
        DBMS_OUTPUT.PUT_LINE(
            'Reminder: Dear ' || r_loan.customer_name || 
            ', your payment of $' || TO_CHAR(r_loan.amount_due, '999,999.00') || 
            ' for Loan ID ' || r_loan.loan_id || 
            ' is due on ' || TO_CHAR(r_loan.due_date, 'YYYY-MM-DD') || '.'
        );
    END LOOP;
END;
