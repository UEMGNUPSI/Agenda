-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema Agenda
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Agenda` DEFAULT CHARACTER SET utf8 ;
USE `Agenda` ;

-- -----------------------------------------------------
-- Table `Agenda`.`Setor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Agenda`.`Setor` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(64) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Agenda`.`Funcionario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Agenda`.`Funcionario` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(90) NULL,
  `endereco` VARCHAR(64) NULL,
  `cidade_estado` VARCHAR(64) NULL,
  `tel_residencial` VARCHAR(14) NULL,
  `tel_comercial1` VARCHAR(14) NULL,
  `tel_comercial2` VARCHAR(14) NULL,
  `celular1` VARCHAR(14) NULL,
  `celular2` VARCHAR(14) NULL,
  `celular3` VARCHAR(14) NULL,
  `email` VARCHAR(64) NULL,
  `dia` VARCHAR(45) NULL,
  `horario` VARCHAR(90) NULL,
  `observacao` VARCHAR(150) NULL,
  `id_setor` INT NULL,
  `ramal` VARCHAR(30) NULL,
  `docente` INT NULL,
  `inativo` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `id_setor_idx` (`id_setor` ASC),
  CONSTRAINT `id_setor`
    FOREIGN KEY (`id_setor`)
    REFERENCES `Agenda`.`Setor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `Agenda`.`Usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Agenda`.`Usuario`(
 `id` INT NOT NULL AUTO_INCREMENT,
 `nome` VARCHAR(90) NOT NULL,
 `contato` VARCHAR (64) NOT NULL,
 `usuario` VARCHAR(20) NOT NULL UNIQUE,
 `senha` VARCHAR(20) NOT NULL,
 `admin` boolean NOT NULL,
  PRIMARY KEY (`id`)
);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

insert into Usuario values(NULL,"usuário convidado","teste@teste.com","convidado","convidado",0);
insert into Usuario values(NULL,"usuário root","teste@teste.com","root","root",1);
insert into Usuario values(NULL,"usuário a","teste@teste.com","a","a",1);
insert into Usuario values(NULL,"secretária1","teste@teste.com","secretaria1","secretaria1",1);
insert into Usuario values(NULL,"secretária2","teste@teste.com","secretaria2","secretaria2",1);
insert into Usuario values(NULL,"professor1","teste@teste.com","professor1","professor1",1);
insert into Usuario values(NULL,"professor2","teste@teste.com","professor2","professor2",1);

insert into Setor values(NULL,"NUPSI");
insert into Setor values(NULL,"Informática");
insert into Setor values(NULL,"Recepção");
insert into Setor values(NULL,"Coordenação");
insert into Setor values(NULL,"Serviços Gerais");
insert into Setor values(NULL,"Administração");

insert into Funcionario values(NULL,"Danilo Vieira","Av. Romero Alves, 74","Frutal/MG","3423-0000","3421-0000","3421-0005","(34)99214-0000","(34)99214-0005","(34)99214-0010","email@email.com1","2ª,3ª,","13:00 ate 16:00","nenhuma1",1,"batata",0,0);
insert into Funcionario values(NULL,"Gustavo Pinottti","Av. Romero Alves, 75","Frutal/MG","3423-0001","3421-0001","3421-0006","(34)99214-0001","(34)99214-0006","(34)99214-0011","email@email.com2","2ª,3ª,","13:30 ate 16:30","nenhuma2",1,"batata",0,0);
insert into Funcionario values(NULL,"Murillo Taruôco Cuervo","Av. Romero Alves, 76","Frutal/MG","3423-0002","3421-0002","3421-0007","(34)99214-0002","(34)99214-0007","(34)99214-0012","email@email.com3","2ª,3ª,","14:00 ate 17:00","nenhuma3",1,"batata",0,0);
insert into Funcionario values(NULL,"Fabio Viera","Av. Romero Alves, 77","Frutal/MG","3423-0003","3421-0003","3421-0008","(34)99214-0003","(34)99214-0008","(34)99214-0013","email@email.com4","2ª,3ª,4ª","14:30 ate 17:30","nenhuma4",2,"batata",0,0);
insert into Funcionario values(NULL,"Juliana Bernardes","Av. Romero Alves, 78","Frutal/MG","3423-0004","3421-0004","3421-0009","(34)99214-0004","(34)99214-0009","(34)99214-0014","email@email.com5","2ª,3ª,4ª","15:00 ate 18:00","nenhuma5",2,"batata",0,0);
insert into Funcionario values(NULL,"Juliana Outra","Av. Romero Alves, 79","Frutal/MG","3423-0005","3421-0005","3421-0010","(34)99214-0005","(34)99214-0010","(34)99214-0015","email@email.com6","2ª,3ª,4ª","15:00 ate 18:01","nenhuma6",2,"batata",0,0);
insert into Funcionario values(NULL,"Abacate Docente1","Av. Romero Alves, 80","Fronteira/MG","3423-0006","3421-0006","3421-0011","(34)99214-0006","(34)99214-0011","(34)99214-0016","email@email.com7","2ª,3ª,4ª,5ª","15:00 ate 18:02","nenhuma7",4,"batata",1,0);
insert into Funcionario values(NULL,"Bacate Docente2","Av. Romero Alves, 81","Fronteira/MG","3423-0007","3421-0007","3421-0012","(34)99214-0007","(34)99214-0012","(34)99214-0017","email@email.com8","2ª,3ª,4ª,5ª","15:00 ate 18:03","nenhuma8",4,"batata",1,0);
insert into Funcionario values(NULL,"Cate Docente3","Av. Romero Alves, 82","Fronteira/MG","3423-0008","3421-0008","3421-0013","(34)99214-0008","(34)99214-0013","(34)99214-0018","email@email.com9","2ª,3ª,4ª,5ª","15:00 ate 18:04","nenhuma9",4,"batata",1,0);
insert into Funcionario values(NULL,"Secretaria1","Av. Romero Alves, 83","Frutal/MG","3423-0009","3421-0009","3421-0014","(34)99214-0009","(34)99214-0014","(34)99214-0019","email@email.com10","2ª,3ª,4ª,5ª,6ª","15:00 ate 18:05","nenhuma10",3,"batata",0,0);
insert into Funcionario values(NULL,"Secretaria2","Av. Romero Alves, 84","Frutal/MG","3423-0010","3421-0010","3421-0015","(34)99214-0010","(34)99214-0015","(34)99214-0020","email@email.com11","2ª,3ª,4ª,5ª,6ª","15:00 ate 18:06","nenhuma11",3,"batata",0,0);
insert into Funcionario values(NULL,"Secretaria3","Av. Romero Alves, 85","Frutal/MG","3423-0011","3421-0011","3421-0016","(34)99214-0011","(34)99214-0016","(34)99214-0021","email@email.com12","2ª,3ª,4ª,5ª,6ª","15:00 ate 18:07","nenhuma12",3,"batata",0,0);
insert into Funcionario values(NULL,"Moça da Limpeza1","Av. Romero Alves, 86","Frutal/MG","3423-0012","3421-0012","3421-0017","(34)99214-0012","(34)99214-0017","(34)99214-0022","email@email.com13","2ª","15:00 ate 18:08","nenhuma13",5,"batata",0,0);
insert into Funcionario values(NULL,"Moça da Limpeza2","Av. Romero Alves, 87","Frutal/MG","3423-0013","3421-0013","3421-0018","(34)99214-0013","(34)99214-0018","(34)99214-0023","email@email.com14","2ª","15:00 ate 18:09","nenhuma14",5,"batata",0,0);
insert into Funcionario values(NULL,"Moça da Limpeza3","Av. Romero Alves, 88","Frutal/MG","3423-0014","3421-0014","3421-0019","(34)99214-0014","(34)99214-0019","(34)99214-0024","email@email.com15","2ª","15:00 ate 18:10","nenhuma15",5,"batata",0,0);
insert into Funcionario values(NULL,"Administrador1","Av. Romero Alves, 89","Rio Preto/SP","3423-0015","3421-0015","3421-0020","(34)99214-0015","(34)99214-0020","(34)99214-0025","email@email.com16","2ª,3ª","15:00 ate 18:11","nenhuma16",6,"batata",0,0);
insert into Funcionario values(NULL,"Administrador2","Av. Romero Alves, 90","Rio Preto/SP","3423-0016","3421-0016","3421-0021","(34)99214-0016","(34)99214-0021","(34)99214-0026","email@email.com17","2ª,3ª","15:00 ate 18:12","nenhuma17",6,"batata",0,0);
insert into Funcionario values(NULL,"Administrador3","Av. Romero Alves, 91","Rio Preto/SP","3423-0017","3421-0017","3421-0022","(34)99214-0017","(34)99214-0022","(34)99214-0027","email@email.com18","2ª,3ª","15:00 ate 18:13","nenhuma18",6,"batata",0,0);
insert into Funcionario values(NULL,"Inativo1","Av. Romero Alves, 92","Frutal/MG","3423-0018","3421-0018","3421-0023","(34)99214-0018","(34)99214-0023","(34)99214-0028","email@email.com19","2ª,3ª,4ª","15:00 ate 18:14","nenhuma19",6,"batata",0,1);
insert into Funcionario values(NULL,"Inativo2","Av. Romero Alves, 93","Frutal/MG","3423-0019","3421-0019","3421-0024","(34)99214-0019","(34)99214-0024","(34)99214-0029","email@email.com20","2ª,3ª,4ª","15:00 ate 18:15","nenhuma20",6,"batata",0,1);
insert into Funcionario values(NULL,"Inativo3","Av. Romero Alves, 94","Frutal/MG","3423-0020","3421-0020","3421-0025","(34)99214-0020","(34)99214-0025","(34)99214-0030","email@email.com21","2ª,3ª,4ª","15:00 ate 18:16","nenhuma21",6,"batata",0,1);
insert into Funcionario values(NULL,"InativoDocente1","Av. Romero Alves, 95","Planura/MG","3423-0021","3421-0021","3421-0026","(34)99214-0021","(34)99214-0026","(34)99214-0031","email@email.com22","2ª,3ª,4ª,5ª","15:00 ate 18:17","nenhuma22",6,"batata",1,1);
insert into Funcionario values(NULL,"InativoDocente2","Av. Romero Alves, 96","Planura/MG","3423-0022","3421-0022","3421-0027","(34)99214-0022","(34)99214-0027","(34)99214-0032","email@email.com23","2ª,3ª,4ª,5ª","15:00 ate 18:18","nenhuma23",6,"batata",1,1);
insert into Funcionario values(NULL,"InativoDocente3","Av. Romero Alves, 97","Planura/MG","3423-0023","3421-0023","3421-0028","(34)99214-0023","(34)99214-0028","(34)99214-0033","email@email.com24","2ª,3ª,4ª,5ª","15:00 ate 18:19","nenhuma24",6,"batata",1,1);
