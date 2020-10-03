SET FOREIGN_KEY_CHECKS = 0;


truncate table category;

INSERT INTO category(id,name) VALUES (1,'shopping'),
(2,'Travel'),
(3,'marriage');

SET FOREIGN_KEY_CHECKS = 1;

