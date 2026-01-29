TRUNCATE TABLE customer RESTART IDENTITY CASCADE;
TRUNCATE TABLE card RESTART IDENTITY CASCADE;
TRUNCATE TABLE account RESTART IDENTITY CASCADE;
TRUNCATE TABLE transactions RESTART IDENTITY CASCADE;

INSERT INTO customer (email, name, password)
VALUES ('admin@banking-app.com', 'admin', 'admin'),
       ('john@google.com', 'John', 'pw123'),
       ('maria@yahoo.com', 'Maria', '12345'),
       ('alison@gmail.com', 'Alison', 'my_pw');

INSERT INTO account (balance, number, customer_id)
VALUES ('421.32', 'ZBD1231425', 1),
       (-32.11, 'GH987654321', 2),
       (12000, 'ZZ987ef321', 3),
       (12.32, 'BE3CA24321', 4);

INSERT INTO card (number, type, account_id)
VALUES ('123456790', 'debit', 1),
       ('ABC5000', 'debit', 2),
       ('123CDE123', 'credit', 3),
       ('ROM12345', 'debit', 4);

INSERT INTO transactions (amount, time, to_account_id, from_account_id)
VALUES ('10', CURRENT_TIMESTAMP, 1, 2),
       ('100', CURRENT_TIMESTAMP, 2, 1),
       ('10', CURRENT_TIMESTAMP, 3, 4),
       ('653', CURRENT_TIMESTAMP, 4, 3),
       ('21', CURRENT_TIMESTAMP, 1, 4),
       ('8', CURRENT_TIMESTAMP, 3, 2);