-- V2 : Migrations for add a column rank in table of cadastro

ALTER TABLE tb_cadastro
ADD COLUMN rank VARCHAR(255);