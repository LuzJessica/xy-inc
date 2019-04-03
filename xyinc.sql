-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema xy-inc
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema xy-inc
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `xy-inc` DEFAULT CHARACTER SET utf8 ;
USE `xy-inc` ;

-- -----------------------------------------------------
-- Table `xy-inc`.`pontos_de_interesse`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `xy-inc`.`pontos_de_interesse` (
  `idPonto` INT NOT NULL AUTO_INCREMENT,
  `nome_ponto` VARCHAR(45) NOT NULL,
  `co_x` VARCHAR(45) NOT NULL,
  `co_y` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idPonto`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
