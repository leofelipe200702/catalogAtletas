INSERT INTO tb_modality (name) VALUES ('Futsal');
INSERT INTO tb_modality (name) VALUES ('Handebol');
INSERT INTO tb_modality (name) VALUES ('Voleibol');

INSERT INTO tb_category (name) VALUES ('Mirim');
INSERT INTO tb_category (name) VALUES ('Infantil');
INSERT INTO tb_category (name) VALUES ('Juvenil');

INSERT INTO tb_school (name) VALUES ('Ginásio de Limoeiro Arthur Correia de Oliveira');
INSERT INTO tb_school (name) VALUES ('Escola Cônego Fernando Passos');
INSERT INTO tb_school (name) VALUES ('Escola Estadual Professora jandira de Andrade Lima');

INSERT INTO tb_user (first_name, last_name, email, password) VALUES ('Jaime', 'Salvador', 'jaimesalvadordearruda@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');

INSERT INTO tb_role (authority) VALUES ('ROLE_OPERATOR');
INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 2);
