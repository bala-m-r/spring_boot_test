DROP table Mytrades;
CREATE TABLE IF not exists Mytrades (
    tradeid INT not null PRIMARY KEY,
    -- tradedate DATE,
    scripcode VARCHAR(255),
    scripname VARCHAR(255),
    tradetype VARCHAR(50),
    quantity INT,
    price DOUBLE,
    exchange VARCHAR(50)
);
