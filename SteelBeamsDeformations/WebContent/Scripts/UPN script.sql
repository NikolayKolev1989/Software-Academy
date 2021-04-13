CREATE DATABASE IF NOT EXISTS static_tools;
USE static_tools;

DROP TABLE IF EXISTS upn;
CREATE TABLE upn(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`type` VARCHAR(255) NOT NULL,
	sec_in_moment INT NOT NULL -- mm4
);


INSERT INTO upn(`type`, sec_in_moment)
VALUES
('UPN 50', 2.65E+5),
('UPN 65', 5.75E+5),
('UPN 80', 1.06E+6),
('UPN 100', 2.05E+6),
('UPN 120', 3.64E+6),
('UPN 140', 6.05E+6),
('UPN 160', 9.25E+6),
('UPN 180', 1.35E+7),
('UPN 200', 1.91E+7),
('UPN 220', 2.69E+7),
('UPN 240', 3.60E+7),
('UPN 260', 4.82E+7),
('UPN 280', 6.28E+7),
('UPN 300', 8.03E+7),
('UPN 320', 1.09E+8),
('UPN 350', 1.28E+8),
('UPN 380', 1.58E+8),
('UPN 400', 2.04E+8);

SELECT * FROM upn;