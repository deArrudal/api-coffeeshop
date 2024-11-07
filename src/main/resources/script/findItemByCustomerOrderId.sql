DELIMITER $$
CREATE PROCEDURE findItemByCustomerOrderId(IN customerOrderId BIGINT)
BEGIN
    SELECT 
        c.name, 
        c.price, 
        i.quantity 
    FROM item i 
    JOIN coffee c ON i.coffee_id = c.id
	WHERE i.customer_order_id = customerOrderId;
END $$
DELIMITER ;