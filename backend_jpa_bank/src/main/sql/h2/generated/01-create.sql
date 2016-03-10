--
-- Source code generated by Celerio, a Jaxio product.
-- Documentation: http://www.jaxio.com/documentation/celerio/
-- Follow us on twitter: @jaxiosoft
-- Need commercial support ? Contact us: info@jaxio.com
-- Template pack-backend-jpa:src/main/sql/h2/01-create.p.vm.sql
-- Template is part of Open Source Project: https://github.com/jaxio/pack-backend-jpa
--

DROP ALL objects;


-- =================================
-- TABLE ACCOUNT 
-- =================================

CREATE TABLE ACCOUNT (
	ID INTEGER(10) not null,
	ACCOUNT_NUMBER VARCHAR(100) not null,
	NAME VARCHAR(100) not null,
	CURRENCY_ID INTEGER(10) not null,
	CUSTOMER_ID INTEGER(10) not null,
	VERSION INTEGER(10) default 0);

CREATE UNIQUE INDEX IF NOT EXISTS ACCOUNT_NUMBER_UNIQUE_INDEX_E ON ACCOUNT (ACCOUNT_NUMBER);
ALTER TABLE ACCOUNT ALTER COLUMN ID IDENTITY;


-- =================================
-- TABLE ADDRESS 
-- =================================

CREATE TABLE ADDRESS (
	ID INTEGER(10) not null,
	STREET VARCHAR(100),
	ZIP_CODE VARCHAR(10),
	CITY VARCHAR(100) not null,
	COUNTRY VARCHAR(100) not null,
	VERSION INTEGER(10) default 0);

ALTER TABLE ADDRESS ALTER COLUMN ID IDENTITY;


-- =================================
-- TABLE CURRENCY 
-- =================================

CREATE TABLE CURRENCY (
	ID INTEGER(10) not null,
	CODE CHAR(3) not null,
	NAME VARCHAR(100) not null,
	DECIMAL_COUNT INTEGER(10),
	VERSION INTEGER(10) default 0);

ALTER TABLE CURRENCY ALTER COLUMN ID IDENTITY;


-- =================================
-- TABLE CUSTOMER 
-- =================================

CREATE TABLE CUSTOMER (
	ID INTEGER(10) not null,
	COMPANY_NAME VARCHAR(100) not null,
	ADDRESS_ID INTEGER(10),
	CONTRACT_BINARY VARBINARY(2147483647),
	CONTRACT_FILE_NAME VARCHAR(100),
	CONTRACT_CONTENT_TYPE VARCHAR(100),
	CONTRACT_SIZE INTEGER(10),
	VERSION INTEGER(10) default 0);

ALTER TABLE CUSTOMER ALTER COLUMN ID IDENTITY;


-- =================================
-- TABLE ROLE 
-- =================================

CREATE TABLE ROLE (
	ID INTEGER(10) not null,
	ROLE_NAME VARCHAR(100) not null);

CREATE UNIQUE INDEX IF NOT EXISTS ROLE_UNIQUE_1_INDEX_2 ON ROLE (ROLE_NAME);
ALTER TABLE ROLE ALTER COLUMN ID IDENTITY;


-- =================================
-- TABLE SAVED_SEARCH 
-- =================================

CREATE TABLE SAVED_SEARCH (
	ID INTEGER(10) not null,
	NAME VARCHAR(128) not null,
	FORM_CLASSNAME VARCHAR(256) not null,
	FORM_CONTENT VARBINARY(2147483647),
	USER_ID INTEGER(10));

ALTER TABLE SAVED_SEARCH ALTER COLUMN ID IDENTITY;


-- =================================
-- TABLE TRANSACTION 
-- =================================

CREATE TABLE TRANSACTION (
	ID INTEGER(10) not null,
	ACCOUNT_ID INTEGER(10) not null,
	AMOUNT DECIMAL(20,2) not null,
	TRANSACTION_DATE DATE not null,
	VALUE_DATE DATE not null,
	CURRENCY_ID INTEGER(10) not null,
	DESCRIPTION VARCHAR(255),
	VERSION INTEGER(10) default 0);

ALTER TABLE TRANSACTION ALTER COLUMN ID IDENTITY;


-- =================================
-- TABLE USER 
-- =================================

CREATE TABLE USER (
	ID INTEGER(10) not null,
	LOGIN VARCHAR(100) not null,
	PASSWORD VARCHAR(100) not null,
	EMAIL VARCHAR(100),
	IS_ENABLED BOOLEAN(1) not null default 'TRUE',
	CIVILITY CHAR(2) default 'MR',
	FIRST_NAME VARCHAR(100),
	LAST_NAME VARCHAR(100),
	CREATION_DATE TIMESTAMP,
	CREATION_AUTHOR VARCHAR(200),
	LAST_MODIFICATION_DATE TIMESTAMP,
	LAST_MODIFICATION_AUTHOR VARCHAR(200),
	VERSION INTEGER(10) default 0);

CREATE UNIQUE INDEX IF NOT EXISTS USER_UNIQUE_1_INDEX_2 ON USER (LOGIN);
ALTER TABLE USER ALTER COLUMN ID IDENTITY;


-- =================================
-- TABLE USER_ROLE 
-- =================================

CREATE TABLE USER_ROLE (
	USER_ID INTEGER(10) not null,
	ROLE_ID INTEGER(10) not null);

CREATE PRIMARY KEY ON USER_ROLE (ROLE_ID, USER_ID);
ALTER TABLE ACCOUNT ADD CONSTRAINT ACCOUNT_CURRENCY FOREIGN KEY (CURRENCY_ID) REFERENCES CURRENCY (ID);
ALTER TABLE ACCOUNT ADD CONSTRAINT ACCOUNT_CUSTUMER FOREIGN KEY (CUSTOMER_ID) REFERENCES CUSTOMER (ID);
ALTER TABLE CUSTOMER ADD CONSTRAINT CUSTOMER_ADDRESS FOREIGN KEY (ADDRESS_ID) REFERENCES ADDRESS (ID);
ALTER TABLE SAVED_SEARCH ADD CONSTRAINT SAVED_SEARCH_FK_1 FOREIGN KEY (USER_ID) REFERENCES USER (ID);
ALTER TABLE TRANSACTION ADD CONSTRAINT TRANSACTION_CURRENCY FOREIGN KEY (CURRENCY_ID) REFERENCES CURRENCY (ID);
ALTER TABLE TRANSACTION ADD CONSTRAINT TRANSACTION_ACCOUNT FOREIGN KEY (ACCOUNT_ID) REFERENCES ACCOUNT (ID);
ALTER TABLE USER_ROLE ADD CONSTRAINT USER_ROLE_FK_1 FOREIGN KEY (USER_ID) REFERENCES USER (ID);
ALTER TABLE USER_ROLE ADD CONSTRAINT USER_ROLE_FK_2 FOREIGN KEY (ROLE_ID) REFERENCES ROLE (ID);