
use expensetrackerdb;
SET FOREIGN_KEY_CHECKS = 0;

TRUNCATE TABLE expense;
TRUNCATE TABLE category;

TRUNCATE TABLE expenseUser;



INSERT INTO expenseUser(`id`,`name`,`email`,`username`,`password`) values (1,'ogu','doh@gmail.com'),
(2, 'edit','@gmail.com'),
(3, 'francis','cis@gmail.com');


INSERT INTO category(id,name) VALUES (1,'shopping'),
(2,'Travel'),
(3,'marriage');


INSERT INTO expense(`id`,`descipt`,`expensedate`,`location`,`category_id`,`user_id`) values (20,'island trip','2020-03-2 20:00:00.000','Honkong',1,2),
(2,'Kaduna-trip','2012-04-19 13:00:00.000','Northan-nigeria',3,1),
(3,'Car','2013-09-22 3:00:00.000','Tesla-factory',2,3);

SET FOREIGN_KEY_CHECKS  = 1;