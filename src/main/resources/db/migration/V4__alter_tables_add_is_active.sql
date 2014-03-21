ALTER TABLE server_types ADD COLUMN
    is_active               BOOLEAN NOT NULL DEFAULT 1
    AFTER tco_dollars;


ALTER TABLE data_centers ADD COLUMN
    is_active               BOOLEAN NOT NULL DEFAULT 1
    AFTER data_center_name;

ALTER TABLE operating_systems ADD COLUMN
    is_active               BOOLEAN NOT NULL DEFAULT 1
    AFTER operating_system_name;