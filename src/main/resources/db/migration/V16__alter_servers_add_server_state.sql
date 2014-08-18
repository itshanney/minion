ALTER TABLE servers ADD COLUMN
    server_state            VARCHAR(16) DEFAULT 'PENDING'
    AFTER domain_id;