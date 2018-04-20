CREATE TABLE `mytestdb`.`author` (
  `id` INT NOT NULL,
  `firstname` VARCHAR(45) NULL,
  `lastname` VARCHAR(45) NULL,
  `version` INT(1) NULL DEFAULT 0,
  PRIMARY KEY (`id`));
