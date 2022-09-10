-- Disable Foreign Key Check --

ALTER TABLE items_tb DISABLE TRIGGER ALL;
ALTER TABLE orders_tb DISABLE TRIGGER ALL;
ALTER TABLE orders_items_tb DISABLE TRIGGER ALL;

--Delete all rows in tables --

TRUNCATE  items_tb CASCADE;
TRUNCATE  orders_tb CASCADE;
TRUNCATE  orders_items_tb CASCADE;



-- Enable Foreign Key Check --

ALTER TABLE items_tb ENABLE TRIGGER ALL;
ALTER TABLE orders_tb ENABLE TRIGGER ALL;
ALTER TABLE orders_items_tb ENABLE TRIGGER ALL;


-- Alter sequence start --

ALTER SEQUENCE items_tb_item_id_seq RESTART WITH 1;
ALTER SEQUENCE orders_tb_order_id_seq RESTART WITH 1;
ALTER SEQUENCE orders_items_tb_order_item_id_seq RESTART WITH 1;



insert into items_tb (item_description, item_type, item_value)
values
('Tv 4k', 'P', 5000),
('Furadeira 400w', 'P', 500),
('Microondas', 'P', 600),
('Montagem de Móvel', 'S', 300);


 insert into  orders_tb (order_date, order_number, order_disccount, order_total_value)
 values
 (current_timestamp, 2, 2.0, 300),
 (current_timestamp, 3, 4.0, 10000),
 (current_timestamp, 4, 1.5, 2000),
 (current_timestamp, 5, 0.5, 8000);



 insert into orders_items_tb (item_id, order_id, quantity, total_value)
 values
 (1, 2, 200, 1000),
 (3, 1, 5, 5000),
 (2, 3, 30, 7000),
 (2, 2, 15, 8000);