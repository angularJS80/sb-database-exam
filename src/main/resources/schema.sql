Drop TABLE CUSTOMERS IF EXISTS;
  CREATE TABLE CUSTOMERS (
  CustomerID int IDENTITY PRIMARY KEY ,
  CustomerName varchar(255),
  ContactName varchar(255),
  Address varchar(255),
  City varchar(255),
  PostalCode varchar(255),
  Country varchar(255)
);