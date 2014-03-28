-- Add the new column to hold type_id data
ALTER TABLE server_types ADD COLUMN
    type_code           VARCHAR(16)
    AFTER type_id;

-- Backfill the type_code data
UPDATE server_types
SET type_code = type_id
WHERE type_code IS NULL;

-- Make the column NOT NULl
ALTER TABLE server_types MODIFY COLUMN
    type_code           VARCHAR(16) NOT NULL;

-- Drop the primary key (type_id)
ALTER TABLE server_types
    DROP PRIMARY KEY;

-- Remove the not null constraint
ALTER TABLE server_types MODIFY COLUMN
    type_id             VARCHAR(16);

-- Null out all of the data
UPDATE server_types
SET type_id = null
WHERE TYPE_ID IS NOT NULL;

-- Modify the column type to be an integer
ALTER TABLE server_types MODIFY COLUMN
    type_id             INT UNSIGNED NOT NULL AUTO_INCREMENT,
    ADD PRIMARY KEY(type_id);