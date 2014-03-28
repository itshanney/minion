-- Drop the primary key
ALTER TABLE operating_systems
DROP PRIMARY KEY;

-- Make the column nullable
ALTER TABLE operating_systems
MODIFY COLUMN
    operating_system_id             VARCHAR(16);

-- Null out all of the data
UPDATE operating_systems
SET operating_system_id = null
WHERE operating_system_id IS NOT NULL;

-- Modify the column type and set primary key
ALTER TABLE operating_systems
MODIFY COLUMN
    operating_system_id             INT UNSIGNED NOT NULL AUTO_INCREMENT,
    ADD PRIMARY KEY (operating_system_id);