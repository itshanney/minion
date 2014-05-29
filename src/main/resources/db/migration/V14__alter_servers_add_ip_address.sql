ALTER TABLE servers ADD COLUMN
    ip_address          VARCHAR(16)
    AFTER hostname;