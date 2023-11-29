DROP TABLE product IF EXISTS;

CREATE TABLE product  (
    uniq_id VARCHAR(20) PRIMARY KEY,
    sku VARCHAR(20),
    name_title VARCHAR(20),
    description VARCHAR(20),
    list_price VARCHAR(20),
    sale_price VARCHAR(20),
    category VARCHAR(20),
    category_tree VARCHAR(20),
    average_product_rating VARCHAR(20),
    product_url VARCHAR(20),
    product_image_urls VARCHAR(20),
    brand VARCHAR(20),
    total_number_reviews VARCHAR(20),
    Reviews VARCHAR(20)
);