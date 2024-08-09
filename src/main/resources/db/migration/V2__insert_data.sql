INSERT INTO Brand (name, active) VALUES 
('Samsung', true),
('Apple', true);

INSERT INTO Category (name, active) VALUES 
('Smartphones', true),
('Laptops', true);

INSERT INTO Product (sku, name, price, category_id, brand_id, active) VALUES 
('SAM123', 'Galaxy S20', 799.99, 1, 1, true),
('APL456', 'MacBook Pro', 1299.99, 2, 2, true);