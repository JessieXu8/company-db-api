CREATE TABLE `tw_company` (
    `id`    BIGINT  NOT NULL    AUTO_INCREMENT PRIMARY KEY,
    `name`  VARCHAR(50)     NOT NULL,
    `create_date` TIMESTAMP     DEFAULT NOW()
);