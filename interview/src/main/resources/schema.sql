DROP TABLE IF EXISTS REF_DATA;
DROP TABLE IF EXISTS TRADE;
DROP TABLE IF EXISTS VALUATION;

CREATE TABLE REF_DATA
(   id              INT AUTO_INCREMENT,
    top_of_house    VARCHAR(5)  NOT NULL,
    segment         VARCHAR(5)  NOT NULL,
    vice_chair      VARCHAR(5)  NOT NULL,
    global_business VARCHAR(5)  NOT NULL,
    policy          VARCHAR(5)  NOT NULL,
    desk            VARCHAR(25) NOT NULL,
    portfolio       VARCHAR(25) NOT NULL,
    bu              NUMBER      NOT NULL,
    cline           VARCHAR(50) NOT NULL,
    inventory       VARCHAR(50) NOT NULL PRIMARY KEY
);

CREATE TABLE VALUATION
(
    trade_id         NUMBER NOT NULL PRIMARY KEY,
    uql_oc_mmb_ms    NUMBER NOT NULL,
    uql_oc_mmb_ms_pc NUMBER NOT NULL
);

CREATE TABLE TRADE
(
    id               INT AUTO_INCREMENT ,
    inventory        VARCHAR(50) NOT NULL,
    book             VARCHAR(50) NOT NULL,
    system           VARCHAR(50) NOT NULL,
    legal_entity     VARCHAR(50) NOT NULL,
    trade_id         NUMBER      NOT NULL ,
    version          NUMBER      NOT NULL,
    trade_status     VARCHAR(20) NOT NULL,
    product_type     VARCHAR(20) NOT NULL,
    resetting_leg    VARCHAR(50) ,
    product_subtype  VARCHAR(20) NOT NULL,
    tds_product_type VARCHAR(50) NOT NULL,
    sec_code_subtype VARCHAR(50) ,
    swap_type        VARCHAR(50) NOT NULL,
    description      VARCHAR(200) NOT NULL,
    trade_date       DATE ,
    start_date       DATE ,
    maturity_date    DATE,
    foreign key (inventory) references REF_DATA(inventory)
);




