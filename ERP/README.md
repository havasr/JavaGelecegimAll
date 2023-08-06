# ERP (Enterprise Resource Planning)
## Project Overview
This Spring Boot project provides a simple ERP (Enterprise Resource Planning) system that manages customers, products, orders, and invoices. The system allows users to perform various operations, such as creating, updating, and deleting customers and products, placing orders, and generating invoices.
________________________________

## Structure of the project
*Service Classes  
*GradeTest  
*CourseGrade  
*Transcript  
*GenerateTranscript

## Entity Class Structure
The classes described below are the core entities that form the foundation of the ERP system.

## CustomerEntity
The `CustomerEntity` class represents a customer in the ERP system. It is mapped to a database table and extends the `BaseEntity` class. Each customer has the following attributes:

- `uuid`: The unique identifier for the customer.
- `name`: The customer's first name.
- `surname`: The customer's last name.
- `birthYear`: The customer's birth year.
- `email`: The customer's email address.
- `cardNo`: The customer's card number.
- `address`: The customer's address.
- `orderHistory`: A list of `OrderEntity` objects representing the customer's order history.

## ProductEntity
The `ProductEntity` class represents a product in the ERP system. It is mapped to a database table and also extends the `BaseEntity` class. Each product has the following attributes:

- `uuid`: The unique identifier for the product.
- `name`: The name of the product.
- `stock`: The available quantity of the product in stock.
- `hasVAT`: A boolean value indicating whether the product has VAT (Value Added Tax) included in its price.
- `productType`: An enumeration representing the type of the product (e.g., BASIC_NEED, CONSUMER_PRODUCT, LUXURY_ITEM).
- `price`: The price of the product.
- `orderItem`: A one-to-one mapping to an `OrderItemEntity`, representing the product's association with an order item.

## OrderEntity
The `OrderEntity` class represents an order in the ERP system. It is mapped to a database table and extends the `BaseEntity` class. Each order has the following attributes:

- `uuid`: The unique identifier for the order.
- `customer`: A many-to-one mapping to a `CustomerEntity`, representing the customer who placed the order.
- `orderItemList`: A list of `OrderItemEntity` objects representing the items included in the order.
- `orderStatus`: An enumeration representing the status of the order (e.g., PENDING, APPROVED, CANCELLED).
- `invoice`: A one-to-one mapping to an `InvoiceEntity`, representing the invoice associated with the order.

## OrderItemEntity
The `OrderItemEntity` class represents an item within an order in the ERP system. It is mapped to a database table and extends the `BaseEntity` class. Each order item has the following attributes:

- `uuid`: The unique identifier for the order item.
- `order`: A many-to-one mapping to an `OrderEntity`, representing the order to which the item belongs.
- `product`: A one-to-one mapping to a `ProductEntity`, representing the product included in the order item.
- `quantity`: The quantity of the product in the order item.
- `priceAtOrder`: The price of the product at the time the order was placed.

## InvoiceEntity
The `InvoiceEntity` class represents an invoice in the ERP system. It is mapped to a database table and extends the `BaseEntity` class. Each invoice has the following attributes:

- `uuid`: The unique identifier for the invoice.
- `invoiceNo`: The invoice number.
- `totalPriceWithVAT`: The total price of the order with VAT included.
- `totalPriceWithoutVAT`: The total price of the order without VAT.
- `totalVATAmount`: The total VAT amount for the order.
- `order`: A one-to-one mapping to an `OrderEntity`, representing the order associated with the invoice.


## Service Class Structure
The project consists of several service classes that handle different aspects of the ERP system:

1. **CustomerService:** Responsible for managing customer-related operations, such as creating, updating, and deleting customers, as well as searching for customers based on various criteria.

2. **ProductService:** Handles product-related operations, including creating, updating, and deleting products, and searching for products based on certain criteria.

3. **OrderService:** Manages order-related operations, such as creating new orders, adding items to orders, and approving orders.

4. **InvoiceService:** Responsible for generating invoices for approved orders and calculating prices with and without VAT for order items.

5. **OrderItemService:** Handles the creation and retrieval of order items, which represent individual products within an order.

