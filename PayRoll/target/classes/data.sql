INSERT INTO employees (name, empId, wage, monHrs, tueHrs, wedHrs, thuHrs, friHrs, satHrs, sunHrs) VALUES
	('Ami', '101', 20.00, 8, 8, 8, 8, 8, 0, 0),
	('Jake', '102', 18.00, 0, 7.5, 7.5, 8, 0, 8, 8),
	('Rosa', '103', 17.50, 5, 7, 5, 8, 0, 5, 8),
	('Terry', '104', 15.00, 5, 5, 5, 0, 0, 5, 5),
	('Ray', '105', 19.00, 8, 7, 7, 0, 7.5, 0, 7),
	('Charles', '106', 21.50, 5, 5, 5, 5, 5.5, 0, 0),
	('Gina', '107', 15.50, 6, 0, 0, 6, 6, 6, 6),
	('Scully', '108', 16.00, 8, 8, 8, 0, 0, 8, 8),
	('Michael', '109', 15.00, 0, 0, 5, 5, 5, 5, 5),
	('Jenny', '110', 22.00, 8, 0, 8, 8, 8, 8, 0)
	;

INSERT INTO sec_user (userName, encryptedPassword, ENABLED)
VALUES ('Jon', '$2a$10$L6I8M5Fzh50c6/24yi9c1.nenB4g40FLDvVI3wx2xR87lhqbUzO8W', 1),
	   ('Ami', '$2a$10$5I1wyYNabo1hkj68VNZ.xehN2qYcTzSjGs0g7CASUN2G42mfTfUPm', 1),
	   ('Jake', '$2a$10$NsbCl/7qhgkliuyxHGesF.N8gqy6zsM90kc5NvU0.s/Ikp2X6nEey', 1),
	   ('Rosa', '$2a$10$BwoHCRIjUioWAOMDXhQHieDuO.PM1mSDgUijf04UfkYZe7pYDhiWa', 1),
	   ('Terry', '$2a$10$mDvw3IZn7yh00LVbmyODbe27zwI4Kd3xkTN7FYAh8JE33sVwyhMRC', 1),
	   ('Ray', '$2a$10$kDkvsMTalizp8hemDJhUh.z5.hsnJ3xD4XqDjEKFZ3NuiTMNAX60K', 1),
	   ('Charles', '$2a$10$K4K0dudNunO6b1mqFACaAuIJUMj8A52MYH4eTHxXElPYGAeKFVKpG', 1),
	   ('Gina', '$2a$10$C3Z2tuT.s6BdEViqxZABMu1.mjuTAFX0spPnLdqGUcO8Q4fBgaSSa', 1),
	   ('Scully', '$2a$10$F9j1AQe0kqZDps/FZ3NZtemg9hbRWUBTz8oLSMFwFKCnmH8m1lqIy', 1),
	   ('Michael', '$2a$10$m3xr0G5FRsUPkj0bdc.FEO53yxsV/1Irbr2HYCvdYsuc0eRqztAfC', 1),
	   ('Jenny', '$2a$10$tIP3Zpmz8tGottNbdv0o6u/pDdtz7dgEdPMrY1q/Hr3b2FwTUa1Fu', 1);
	
INSERT INTO sec_role (roleName)
VALUES ('ROLE_OWNER'),
	   ('ROLE_EMPLOYEE');

insert into user_role (userId, roleId)
values (1, 1),
	   (2, 2),
	   (3, 2),
	   (4, 2),
	   (5, 2),
	   (6, 2),
	   (7, 2),
	   (8, 2),
	   (9, 2),
	   (10, 2),
	   (11, 2);