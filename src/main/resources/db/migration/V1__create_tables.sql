CREATE TABLE Brand (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    active BOOLEAN DEFAULT true
);

CREATE TABLE Category (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    active BOOLEAN DEFAULT true
);

CREATE TABLE Product (
    id SERIAL PRIMARY KEY,
    sku VARCHAR(50) NOT NULL,
    name VARCHAR(255) NOT NULL,
    price DECIMAL NOT NULL,
    category_id INT REFERENCES Category(id),
    brand_id INT REFERENCES Brand(id),
    active BOOLEAN DEFAULT true
);