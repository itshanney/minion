ALTER TABLE servers ADD COLUMN
    domain_id               INT UNSIGNED
    AFTER operating_system_id;