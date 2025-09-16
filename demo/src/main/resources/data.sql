-- Insert sample customers
INSERT INTO CUSTOMER (id, name, email, address) VALUES (1, 'Alice Johnson', 'alice@example.com', '123 Green St');
INSERT INTO CUSTOMER (id, name, email, address) VALUES (2, 'Bob Smith', 'bob@example.com', '456 Blue Ave');

-- Insert sample meter readings
INSERT INTO METER_READING (id, units_consumed, reading_date, customer_id) VALUES (1, 120, '2025-09-01', 1);
INSERT INTO METER_READING (id, units_consumed, reading_date, customer_id) VALUES (2, 80, '2025-09-01', 2);
