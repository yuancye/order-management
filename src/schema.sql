Create table if not exist customers (
                                        TEXT usename Primary key;
                                        TEXT email Unique;
                                        TEXT password;
                                        TEXT first_name;
                                        TEXT last_name;
);

Create table if not exist Products (
                                       int id Primary key;
                                       DECIMAL(10, 2) price;
    VARCHAR(256) product_name;
    int avaiable_quality; // >0
    TEXT description;
    DATETIME list_time;
    TEXT seller_name references customers(usernmae);
    );

Create Table IF NOT EXIST Order (
                                    int id PRIMARY KEY;
                                    TEXT buyer_usename REFERENCES Customers(usename);
    int product_id references products(id);
    DateTime order-time;
    VARCHAR status; // pending, shipped, cancelled, delivered
    DECIMAL(10, 2) total_amount;
    TEXT shipping_address;
    TEXT billing_address;
    VARCHAR(50) payment_method;
    VARCHAR(50) payment_status;
    DECIMAL(10, 2) discount;
    DECIMAL(10, 2) tax;
    DECIMAL(10, 2) shipping_cost;
    VARCHAR(100) tracking_number;
    TEXT notes;
    );

Create Table IF NOT EXIST OrderDetail (
                                          int order_id reference Order(id);
    int product_id reference Products(id);
    int purchased_quality; // > 0
    );


-- who ordered it, from here, get the shipping address, or from the form.
-- items, what has been ordered. probabely have different items, how to display this



