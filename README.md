"# egoframework" 

CREATE TABLE productlines (
    productline varchar(10) NOT NULL,
    textDescription varchar(255),
    htmlDescription varchar(255),
    image varchar(255),
    CONSTRAINT PK_productlines PRIMARY KEY (productline)
);

CREATE TABLE products (
    productCode varchar(10) NOT NULL,
    productName varchar(255),
    productline varchar(10),
    productScale varchar(255),
	productVendor varchar(255),
	productDescription varchar(255),
	quantityInStock int,
    buyPrice int,
    MSRP varchar(255),
    CONSTRAINT PK_products PRIMARY KEY (productCode),
    FOREIGN KEY (productline) REFERENCES productlines(productline)
);

CREATE TABLE orderdetails (
    orderNumber int NOT NULL,
    productCode varchar(10) NOT NULL,
    quantityOrdered int,
    priceEach int,
    orderLineNumber int,
    CONSTRAINT PK_orderdetails PRIMARY KEY (orderNumber, productCode),
    FOREIGN KEY (productCode) REFERENCES products(productCode),
    FOREIGN KEY (orderNumber) REFERENCES orders(orderNumber)
);

CREATE TABLE orders (
    orderNumber int NOT NULL,
    orderDate date,
    requiredDate date,
    status varchar(10),
    comments varchar(255),
    customerNumber int,
    CONSTRAINT PK_orders PRIMARY KEY (orderNumber)
    
);


CREATE TABLE employees (
	employeeNumber int not null,
    lastName varchar(50),
    firstName varchar(50),
    extension varchar(50),
    email varchar(50),
    officeCode varchar(20),
    reportsTo varchar(50),
    jobTitle varchar(20),
    CONSTRAINT PK_employees PRIMARY KEY (employeeNumber),
    FOREIGN KEY (officeCode) REFERENCES offices(officeCode)
);

CREATE TABLE offices (
	officeCode varchar(20) not null,
    city varchar(50),
    phone varchar(20),
    addressLine1 varchar(100),
    addressLine2 varchar(100),
	state varchar(20),
    postalCode varchar(20),
    country varchar(100),
    territory varchar(50),
    CONSTRAINT PK_customers PRIMARY KEY (officeCode)
);



CREATE TABLE customers (
    customerNumber int NOT NULL,
    customerName varchar(50),
    contactLastName varchar(50),
    contactFirstName varchar(50),
    phone varchar(20),
    addressLine1 varchar(100),
    addressLine2 varchar(100),
    city varchar(100),
    state varchar(20),
    postalCode varchar(20),
    country varchar(100),
    salesRepEmployeeNumber varchar(100),
    employeeNumber int,
    creditLimit varchar(20),
    CONSTRAINT PK_customers PRIMARY KEY (customerNumber),
    FOREIGN KEY (employeeNumber) REFERENCES employees(employeeNumber)
);

CREATE TABLE payments (
    customerNumber int NOT NULL,
    checkNumber int not null,
    paymentDate date,
    amount varchar(20),
    CONSTRAINT PK_payments PRIMARY KEY (customerNumber, checkNumber),
    FOREIGN KEY (customerNumber) REFERENCES customers(customerNumber)
);

