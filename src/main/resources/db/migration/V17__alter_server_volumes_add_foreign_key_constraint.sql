ALTER TABLE server_volumes ADD CONSTRAINT fk_server_volumes_server
    FOREIGN KEY (server_id)
    REFERENCES servers (server_id)
    ON DELETE CASCADE
    ON UPDATE CASCADE;
