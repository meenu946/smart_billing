CREATE TABLE CUSTOMER (
    id INT PRIMARY KEY,
    name VARCHAR(255),
    email VARCHAR(255),
    address VARCHAR(255)
);
CREATE TABLE METER_READING (
    id INT PRIMARY KEY,
    units_consumed INT,
    reading_date DATE,
    customer_id INT,
    FOREIGN KEY (customer_id) REFERENCES CUSTOMER(id)
);
