DELIMITER $$
CREATE PROCEDURE computeTotalByCustomerOrderId(IN customerOrderId INT)
BEGIN
    SELECT SUM(i.quantity * c.price) AS totalPrice
    FROM Item i JOIN Coffee c ON i.coffee_id = c.id
	WHERE i.customer_order_id = customerOrderId;
END $$
DELIMITER ;
