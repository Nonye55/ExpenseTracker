SET FOREIGN_KEY_CHECKS = 0;

TRUNCATE TABLE expenseUser;


INSERT INTO expenseUser(`id`,`name`,`email`,`username`,`password`) values (1,'ogu','doh@gmail.com','ogu123','password'),
(2, 'edit','@gmail.com'),
(3, 'francis','cis@gmail.com');


SET FOREIGN_KEY_CHECKS = 1;
