ALTER TABLE car_repair
    ADD car_repair_bay_id INTEGER;

ALTER TABLE car_repair
    ADD CONSTRAINT FK_CAR_REPAIR_ON_CAR_REPAIR_BAY FOREIGN KEY (car_repair_bay_id) REFERENCES car_repair_bay (id);

ALTER TABLE car_repair_bay
    DROP COLUMN available;