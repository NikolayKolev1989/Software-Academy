CREATE DATABASE IF NOT EXISTS static_tools;
USE static_tools;

DROP TABLE IF EXISTS ue;
CREATE TABLE ue(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`type` VARCHAR(255) NOT NULL,
	sec_in_moment INT NOT NULL -- mm4
);


INSERT INTO ue (`type`, sec_in_moment)
VALUES
('UE 50', 2.28E+5),
('UE 65', 4.86E+5),
('UE 80', 8.94E+5),
('UE 100', 1.74E+6),
('UE 120', 3.04E+6),
('UE 140', 4.91E+6),
('UE 160', 7.47E+6),
('UE 180', 1.09E+7),
('UE 200', 1.52E+7),
('UE 220', 2.11E+7),
('UE 240', 2.90E+7),
('UE 270', 4.16E+7),
('UE 300', 5.81E+7);

SELECT * FROM ue;