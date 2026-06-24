CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest AS
BEGIN
    UPDATE accounts
    SET balance = balance * 1.01
    WHERE account_type = 'SAVINGS';
    
    DBMS_OUTPUT.PUT_LINE('Monthly interest of 1% successfully processed for all savings accounts.');
    
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error processing monthly interest: ' || SQLERRM);
        RAISE;
END;


--Scenario 2
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    p_dept_id          IN employees.department_id%TYPE,
    p_bonus_percentage IN NUMBER
) AS
BEGIN
    -- Validate that the bonus percentage is positive
    IF p_bonus_percentage <= 0 THEN
        RAISE_APPLICATION_ERROR(-20001, 'Bonus percentage must be greater than zero.');
    END IF;

    -- Update salary by adding the bonus percentage
    UPDATE employees
    SET salary = salary * (1 + (p_bonus_percentage / 100))
    WHERE department_id = p_dept_id;
    
    DBMS_OUTPUT.PUT_LINE('Successfully applied a ' || p_bonus_percentage || '% bonus to Department ' || p_dept_id);
    
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error updating employee bonuses: ' || SQLERRM);
        RAISE;
END;

--Scenario 3
CREATE OR REPLACE PROCEDURE TransferFunds (
    p_source_acc IN accounts.account_id%TYPE,
    p_dest_acc   IN accounts.account_id%TYPE,
    p_amount     IN accounts.balance%TYPE
) AS
    v_source_balance accounts.balance%TYPE;
BEGIN
    IF p_amount <= 0 THEN
        RAISE_APPLICATION_ERROR(-20002, 'Transfer amount must be greater than zero.');
    END IF;

    SELECT balance 
    INTO v_source_balance
    FROM accounts
    WHERE account_id = p_source_acc
    FOR UPDATE;

    IF v_source_balance < p_amount THEN
        RAISE_APPLICATION_ERROR(-20003, 'Insufficient funds. Transfer aborted.');
    END IF;

    UPDATE accounts
    SET balance = balance - p_amount
    WHERE account_id = p_source_acc;

    UPDATE accounts
    SET balance = balance + p_amount
    WHERE account_id = p_dest_acc;


    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Successfully transferred $' || p_amount || ' from Account ' || p_source_acc || ' to Account ' || p_dest_acc);

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        ROLLBACK;
        RAISE_APPLICATION_ERROR(-20004, 'One or both account IDs do not exist.');
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Transfer failed: ' || SQLERRM);
        RAISE;
END;
