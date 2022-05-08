CREATE TABLE car_owner
(
    id               INTEGER GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    name             VARCHAR(255)                             NOT NULL,
    address          VARCHAR(255)                             NOT NULL,
    telephone_number VARCHAR(255)                             NOT NULL,
    email            VARCHAR(255)                             NOT NULL,
    CONSTRAINT pk_car_owner PRIMARY KEY (id)
);