CREATE DATABASE IF NOT EXISTS static_tools;
USE static_tools;

DROP TABLE IF EXISTS upe;
CREATE TABLE upe(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`type` VARCHAR(255) NOT NULL,
	sec_in_moment INT NOT NULL -- mm4
);


INSERT INTO upe (`type`, sec_in_moment)
VALUES
('UPE 80', 1.07E+6),
('UPE 100', 2.07E+6),
('UPE 120', 3.64E+6),
('UPE 140', 6.00E+6),
('UPE 160', 9.11E+6),
('UPE 180', 1.35E+7),
('UPE 200', 1.91E+7),
('UPE 220', 2.68E+7),
('UPE 240', 3.60E+7),
('UPE 270', 5.25E+7),
('UPE 300', 7.82E+7),
('UPE 330', 1.10E+8),
('UPE 360', 1.48E+8),
('UPE 400', 2.10E+8);

SELECT * FROM upe;