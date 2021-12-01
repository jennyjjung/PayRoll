CREATE TABLE employees 
(
  id     BIGINT NOT NULL Primary Key AUTO_INCREMENT,
  name   VARCHAR(20), 
  empId  VARCHAR(10), 
  wage   DOUBLE(10),
  monHrs DOUBLE(5),
  tueHrs DOUBLE(5),
  wedHrs DOUBLE(5),
  thuHrs DOUBLE(5),
  friHrs DOUBLE(5),
  satHrs DOUBLE(5),
  sunHrs DOUBLE(5)
) ;

create table SEC_USER
(
  userId            BIGINT NOT NULL Primary Key AUTO_INCREMENT,
  userName          VARCHAR(36) NOT NULL UNIQUE,
  encryptedPassword VARCHAR(128) NOT NULL,
  ENABLED           BIT NOT NULL 
) ;

CREATE TABLE SEC_ROLE
(
  roleId   BIGINT NOT NULL Primary Key AUTO_INCREMENT,
  roleName VARCHAR(30) NOT NULL UNIQUE
) ;

create table USER_ROLE
(
  ID     BIGINT NOT NULL Primary Key AUTO_INCREMENT,
  userId BIGINT NOT NULL,
  roleId BIGINT NOT NULL
);

alter table USER_ROLE
  add constraint USER_ROLE_UK unique (userId, roleId);

alter table USER_ROLE
  add constraint USER_ROLE_FK1 foreign key (userId)
  references SEC_USER (userId);
 
alter table USER_ROLE
  add constraint USER_ROLE_FK2 foreign key (roleId)
  references SEC_ROLE (roleId);