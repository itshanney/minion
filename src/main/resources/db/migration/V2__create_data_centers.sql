CREATE TABLE data_centers (
    data_center_id              VARCHAR(8) NOT NULL,
    data_center_name            VARCHAR(32) NOT NULL,
    create_date                 DATETIME NOT NULL,
    PRIMARY KEY (data_center_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;