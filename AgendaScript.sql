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
  `tel_residencial` VARCHAR(16) NULL,
  `tel_comercial1` VARCHAR(16) NULL,
  `tel_comercial2` VARCHAR(16) NULL,
  `celular1` VARCHAR(16) NULL,
  `celular2` VARCHAR(16) NULL,
  `celular3` VARCHAR(16) NULL,
  `email` VARCHAR(64) NULL,
  `dia` VARCHAR(45) NULL,
  `horario` VARCHAR(90) NULL,
  `observacao` VARCHAR(150) NULL,
  `id_setor` INT NULL,
  `ramal` VARCHAR(30) NULL,
  `docente` boolean NULL,
  `inativo` boolean NULL,
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
 `adm` boolean NOT NULL,
  PRIMARY KEY (`id`)
);

-- -----------------------------------------------------
-- Table `Agenda`.`Comercio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Agenda`.`Comercio` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(90) NULL,
  `area_atuante` VARCHAR(150) NULL,
  `endereco` VARCHAR(64) NULL,
  `cidade_estado` VARCHAR(64) NULL,
  `tel_comercial1` VARCHAR(16) NULL,
  `tel_comercial2` VARCHAR(16) NULL,
  `celular` VARCHAR(16) NULL,
  `email` VARCHAR(64) NULL,
  `observacao` VARCHAR(150) NULL,
  PRIMARY KEY (`id`)
  );
 


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

insert into Usuario values(NULL,"usuário convidado","teste@teste.com","convidado","convidado",0);
insert into Usuario values(NULL,"usuário root","teste@teste.com","root","root",1);


insert into Setor values(NULL,"Técnico Administrativo");
insert into Setor values(NULL,"Docente");


insert into funcionario values(	NULL,"Adriana Barbosa Alves","R: Lorivaldo Leonel Gome, 66","Não consta.","3434218643","Não consta.","Não consta.","34996551252","Não consta.","Não consta.","abaadriana@hotmail.com","Não consta","Não consta","Não Consta",1,"Não consta.",0,0 ); 
insert into funcionario values(NULL,"Antônio Ferreira de Araújo Junior","R: Luiz Roberto da Cruz, 147","Não consta.","3434235400","Não consta.","Não consta.","34996791673","Não consta.","Não consta.","antonioajunior@gmail.com","Não consta","Não consta","Não Consta",1,"Não consta.",0,0 ); 
insert into funcionario values(NULL,"César Augusto Silva de Carvalho","Não consta.","Não consta.","Não consta.","Não consta.","Não consta.","34997811746","Não consta.","Não consta.","cesaraugustosc@hotmail.com","Não consta","Não consta","Não Consta",1,"Não consta.",0,0 ); 
insert into funcionario values(NULL,"Cinara Cristina Gonçalves Groke","Não consta.","Não consta.","Não consta.","Não consta.","Não consta.","34999679749","Não consta.","Não consta.","patrimonio.frutal@uemg.br","Não consta","Não consta","Não Consta",1,"Não consta.",0,0 ); 
insert into funcionario values(NULL,"Dowglas Miranda","Não consta.","Não consta.","3434210542","Não consta.","Não consta.","34991647773","Não consta.","Não consta.","dowglas-12@hotmail.com","Não consta","Não consta","Não Consta",1,"Não consta.",0,0 ); 
insert into funcionario values(NULL,"Evellyn de Paula Amaral","Não consta.","Não consta.","Não consta.","Não consta.","Não consta.","34999748628","Não consta.","Não consta.","evellyn.paula.amaral@hotmail.com","Não consta","Não consta","Não Consta",1,"Não consta.",0,0 ); 
insert into funcionario values(NULL,"Fábio Martins Ferreira","Não consta.","Não consta.","3434214852","Não consta.","Não consta.","34999930327","Não consta.","Não consta.","fabio.ferreira@uemg.br","Não consta","Não consta","Não Consta",1,"Não consta.",0,0 ); 
insert into funcionario values(NULL,"Fernanda Cassia Guidastre","Não consta.","Não consta.","Não consta.","Não consta.","Não consta.","34999983959","Não consta.","Não consta.","fernandaguidastre@hotmail.com","Não consta","Não consta","Não Consta",1,"Não consta.",0,0 ); 
insert into funcionario values(NULL,"Francielly Cortes Santana","Não consta.","Não consta.","Não consta.","Não consta.","Não consta.","34999926600","Não consta.","Não consta.","franciellycortes@yahoo.com.br","Não consta","Não consta","Não Consta",1,"Não consta.",0,0 ); 
insert into funcionario values(NULL,"Frederico Alves da Silva ","R: João Pinheiro , 767","Não consta.","3434216086","Não consta.","Não consta.","34984258432","Não consta.","Não consta.","fredfrutal@hotmail.com","Não consta","Não consta","Não Consta",1,"Não consta.",0,0 ); 
insert into funcionario values(NULL,"Glecia Cristina de Oliveira","R: Osmar Macedo, 80","Não consta.","Não consta.","Não consta.","Não consta.","34998225758","Não consta.","Não consta.","Não consta","Não consta","Não consta","Não Consta",1,"Não consta.",0,0 ); 
insert into funcionario values(NULL,"Iris Viana Soares ","Não consta.","Não consta.","3434214650","Não consta.","Não consta.","34991856121","Não consta.","Não consta.","Não consta","Não consta","Não consta","Não Consta",1,"Não consta.",0,0 ); 
insert into funcionario values(NULL,"João Edson","Não consta.","Não consta.","3434217092","Não consta.","Não consta.","34991697362","3499963-4676","Não consta.","eddinhosoares@hotmail.com","Não consta","Não consta","Não Consta",1,"Não consta.",0,0 ); 
insert into funcionario values(NULL,"Juciele Bandeira Pereira","R: Arapongas, 256","Não consta.","Não consta.","Não consta.","Não consta.","34984165120","343421-3034","Não consta.","juband@hotmail.com","Não consta","Não consta","Não Consta",1,"Não consta.",0,0 ); 
insert into funcionario values(NULL,"Juliana Ferreira Batista","Não consta.","Não consta.","3434232771","Não consta.","Não consta.","34999748879","Não consta.","Não consta.","juliferr2005@hotmail.com","Não consta","Não consta","Não Consta",1,"Não consta.",0,0 ); 
insert into funcionario values(NULL,"Juliana Silva Macedo","R: Pirajuba , 73","Não consta.","Não consta.","Não consta.","Não consta.","34999633895","3499811-3011","Não consta.","julianasilvamacedo@hotmail.com","Não consta","Não consta","Não Consta",1,"Não consta.",0,0 ); 
insert into funcionario values(NULL,"Katia Lacerda","Não consta.","Não consta.","Não consta.","Não consta.","Não consta.","34999663622","Não consta.","Não consta.","frutal@uaitec.mg.gov.br","Não consta","Não consta","Não Consta",1,"Não consta.",0,0 ); 
insert into funcionario values(NULL,"Kelle Jesus Soares","Não consta.","Não consta.","Não consta.","Não consta.","Não consta.","34999717128","Não consta.","Não consta.","kelle-soares@bol.com.br","Não consta","Não consta","Não Consta",1,"Não consta.",0,0 ); 
insert into funcionario values(NULL,"Laura Cristina da Mata Morais","R: Capinopolis, 301","Não consta.","343421229","Não consta.","Não consta.","34991457190","Não consta.","Não consta.","lauraclmmorais@gmail.com","Não consta","Não consta","Não Consta",1,"Não consta.",0,0 ); 
insert into funcionario values(NULL,"Leonardo Duarte Ribeiro","R: Santo Minaré, 304","Não consta.","3434233385","Não consta.","Não consta.","34996554746","Não consta.","Não consta.","leonardoduartefrutal@yahoo.com.br","Não consta","Não consta","Não Consta",1,"Não consta.",0,0 ); 
insert into funcionario values(NULL,"Letícia Roberta Caetano","Não consta.","Não consta.","3434217138","Não consta.","Não consta.","34999958365","Não consta.","Não consta.","lerabertacaetano@hotmail.com","Não consta","Não consta","Não Consta",1,"Não consta.",0,0 ); 
insert into funcionario values(NULL,"Linara Oliveira Queiroz","Não consta.","Não consta.","3434213647","Não consta.","Não consta.","34999628130","Não consta.","Não consta.","linaraqueiroz@outlook.com","Não consta","Não consta","Não Consta",1,"Não consta.",0,0 ); 
insert into funcionario values(NULL,"Luana Mariano Costa","Não consta.","Não consta.","3434216132","Não consta.","Não consta.","34991062305","Não consta.","Não consta.","luaninhacosta@hotmail.com","Não consta","Não consta","Não Consta",1,"Não consta.",0,0 ); 
insert into funcionario values(NULL,"Luciana de Paula Ferreira","Não consta.","Não consta.","Não consta.","Não consta.","Não consta.","Não consta.","Não consta.","Não consta.","Não consta","Não consta","Não consta","Não Consta",1,"Não consta.",0,0 ); 
insert into funcionario values(NULL,"Maiza Rodrigues da Silva","Não consta.","Não consta.","3434218798","Não consta.","Não consta.","34999970153","Não consta.","Não consta.","maizasilvarod@yahoo.com.br","Não consta","Não consta","Não Consta",1,"Não consta.",0,0 ); 
insert into funcionario values(NULL,"Mara Lúcia Dias Ribeiro","R: Olavo Bilac, 525","Não consta.","Não consta.","Não consta.","Não consta.","34996643105","Não consta.","Não consta.","mara_frutal@hotmail.com","Não consta","Não consta","Não Consta",1,"Não consta.",0,0 ); 
insert into funcionario values(NULL,"Marcela Matos Santos","R: Prata, 227","Não consta.","Não consta.","Não consta.","Não consta.","34999747667","3499975-0129","Não consta.","marcelamatos19@hotmail.com","Não consta","Não consta","Não Consta",1,"Não consta.",0,0 ); 
insert into funcionario values(NULL,"Mariella Souza Santos","Não consta.","Não consta.","Não consta.","Não consta.","Não consta.","17997880303","Não consta.","Não consta.","frutal@uaitec.mg.gov.br","Não consta","Não consta","Não Consta",1,"Não consta.",0,0 ); 
insert into funcionario values(NULL,"Meirielle da Silva","R: Joãp Lacerda , 100","Não consta.","3434238177","Não consta.","Não consta.","34999952809","Não consta.","Não consta.","meirielle22@hotmail.com","Não consta","Não consta","Não Consta",1,"Não consta.",0,0 ); 
insert into funcionario values(NULL,"Milena de Carvalho Brena","Não consta.","Não consta.","3434214989","Não consta.","Não consta.","34997742203","Não consta.","Não consta.","micbrena@gmail.com","Não consta","Não consta","Não Consta",1,"Não consta.",0,0 ); 
insert into funcionario values(NULL,"Nádia Miola","R: Prudente de Morais, 609","Não consta.","Não consta.","Não consta.","Não consta.","34996779467","Não consta.","Não consta.","nadiamiola00@gmail.com","Não consta","Não consta","Não Consta",1,"Não consta.",0,0 ); 
insert into funcionario values(NULL,"Nereida Nanci Pimenta","Não consta.","Não consta.","Não consta.","Não consta.","Não consta.","34992149040","3499975-9094","Não consta.","nereidapimenta71@hotmail.com","Não consta","Não consta","Não Consta",1,"Não consta.",0,0 ); 
insert into funcionario values(NULL,"Osmar José da Costa ","Não consta.","Não consta.","3434238599","Não consta.","Não consta.","34992516558","Não consta.","Não consta.","Não consta","Não consta","Não consta","Não Consta",1,"Não consta.",0,0 ); 
insert into funcionario values(NULL,"Pablo Oliveira Barcelos","Não consta.","Não consta.","Não consta.","Não consta.","Não consta.","34988753712","Não consta.","Não consta.","pabloinovauemg@gmail.com","Não consta","Não consta","Não Consta",1,"Não consta.",0,0 ); 
insert into funcionario values(NULL,"Patricia de Paula Pereira","R: Uberaba, 1060 apt.12","Não consta.","3434212407","Não consta.","Não consta.","34996767079","Não consta.","Não consta.","patriciadepaula.frutal@hotmail.com","Não consta","Não consta","Não Consta",1,"Não consta.",0,0 ); 
insert into funcionario values(NULL,"Paulo Henrique Pedro","Rua: Augusto de Lima , 446","Não consta.","Não consta.","Não consta.","Não consta.","34999675720","3498875-3712","Não consta.","paulo_pedro@uemg.br","Não consta","Não consta","Não Consta",1,"Não consta.",0,0 ); 
insert into funcionario values(NULL,"Pedro Gomes Peixoto","Não consta.","Não consta.","Não consta.","Não consta.","Não consta.","34998989050","Não consta.","Não consta.","peixotopg@hotmail.com","Não consta","Não consta","Não Consta",1,"Não consta.",0,0 ); 
insert into funcionario values(NULL,"Poliana - Coordenadora da UAITEC","Não consta.","Não consta.","Não consta.","Não consta.","Não consta.","34996745944","Não consta.","Não consta.","frutal@uaitec.mg.gov.br","Não consta","Não consta","Não Consta",1,"Não consta.",0,0 ); 
insert into funcionario values(NULL,"Raquel de Souza","Não consta.","Não consta.","Não consta.","Não consta.","Não consta.","17981713611","Não consta.","Não consta.","kelearte@hotmail.com","Não consta","Não consta","Não Consta",1,"Não consta.",0,0 ); 
insert into funcionario values(NULL,"Rariton Furtado","Não consta.","Não consta.","Não consta.","Não consta.","Não consta.","34996678796","Não consta.","Não consta.","raritonpf@hotmail.com","Não consta","Não consta","Não Consta",1,"Não consta.",0,0 ); 
insert into funcionario values(NULL,"Renan Carlos Ferro","Não consta.","Não consta.","343423817","Não consta.","Não consta.","34996696612","Não consta.","Não consta.","ferrorenanc@hotmail.com","Não consta","Não consta","Não Consta",1,"Não consta.",0,0 ); 
insert into funcionario values(NULL,"Taciana Faria Cabral Ribeiro","Av: Benjamin Constant, 565","Não consta.","Não consta.","Não consta.","Não consta.","34996719771","Não consta.","Não consta.","tacianacabral179@hotmail.com","Não consta","Não consta","Não Consta",1,"Não consta.",0,0 ); 

insert into funcionario values (NULL,"Adriana Cristina Silva","Av: Rio de Janeiro, 839","Frutal","3434219990","Não consta.","Não consta.","34996663888","Não consta.","Não consta.","adrianacriss@yahoo.com.br","Não consta.","Não consta.","Não consta.",2,"Não consta.",1,0 ); 
insert into funcionario values (NULL,"Ademir Rosa","R: Uberaba, 90","Frutal","Não consta.","Não consta.","Não consta.","34999769113","Não consta.","Não consta.","ademir@ademirrosa.com","Não consta.","Não consta.","Não consta.",2,"Não consta.",1,0 ); 
insert into funcionario values (NULL,"Elisangela","R: Tupaciguara, 1401","Frutal","Não consta.","Não consta.","Não consta.","34999374784","Não consta.","Não consta.","Elisilva.adm@gmail.com","Não consta.","Não consta.","Não consta.",2,"Não consta.",1,0 ); 
insert into funcionario values (NULL,"Adriano Reis de Paula e Silva","Rua: Araguari, 2071   ","Frutal","3434215000","Não consta.","Não consta.","34999747552","34999360648","Não consta.","prof.adrianoreisdepaula@gmail.com","Não consta.","Não consta.","Não consta.",2,"Não consta.",1,0 ); 
insert into funcionario values (NULL,"Alaor Ignácio dos Santos Júnior","Rua: Saturnino Acosta, 103    ","SJRP/SP","1732230924","Não consta.","Não consta.","17997193816","Não consta.","Não consta.","alaorig@uol.com.br","Não consta.","Não consta.","Não consta.",2,"Não consta.",1,0 ); 
insert into funcionario values (NULL,"Alexander Costa","R: Armelindo Buriola, 3850","SJRP/SP","1733531582","Não consta.","Não consta.","17981633090","Não consta.","Não consta.","editorabluecom@hotmail.com","Não consta.","Não consta.","Não consta.",2,"Não consta.",1,0 ); 
insert into funcionario values (NULL,"Aline Pascolino","R: Julio Wenzel, 800","Limeira /SP","Não consta.","Não consta.","Não consta.","19996917530","Não consta.","Não consta.","alinepascoalino@yahoo.com.br","Não consta.","Não consta.","Não consta.",2,"Não consta.",1,0 ); 
insert into funcionario values (NULL,"Allynson   Takehiro  Fujita","R: Santo Minaré, 733","Frutal","Não consta.","Não consta.","Não consta.","34999658578","Não consta.","Não consta.","allyfuji@yahoo.com.br","Não consta.","Não consta.","Não consta.",2,"Não consta.",1,0 ); 
insert into funcionario values (NULL,"Altamira de Souza Queiroz","AV: 05, 14","Itapagipe","3434241368","Não consta.","Não consta.","34999226799","Não consta.","Não consta.","Altamira.uemg@gmail.com","Não consta.","Não consta.","Não consta.",2,"Não consta.",1,0 ); 
insert into funcionario values (NULL,"Altino Machado dos Anjos Junior","Rua: 14, n 2210  ","Jales/SP","1736324639","Não consta.","Não consta.","17997769457","34991316563","Não consta.","altinomachado@ig.com.br","Não consta.","Não consta.","Não consta.",2,"Não consta.",1,0 ); 
insert into funcionario values (NULL,"Amauri Alves Ferreira","Av: Idelfonso L. Freitas, 50","Com. Gomes","Não consta.","Não consta.","Não consta.","34999306558","34999306558","Não consta.","amauri.ferreira68@hotmail.com","Não consta.","Não consta.","Não consta.",2,"Não consta.",1,0 ); 
insert into funcionario values (NULL,"Ana Lucia de Paula Ferreira Nunes","Rua: Barão do Rio Branco, 169","Frutal","3434219688","Não consta.","Não consta.","34999789688","34991486405","Não consta.","ananunesfrutal@hotmail.com","Não consta.","Não consta.","Não consta.",2,"Não consta.",1,0 ); 
insert into funcionario values (NULL,"Ana Maria  Zanoni Silva","Rua: SaturninoRincon,6691","Auriflama /SP","1734822721","Não consta.","Não consta.","17992017503","Não consta.","Não consta.","Anazanoni_@hotmail.com","Não consta.","Não consta.","Não consta.",2,"Não consta.",1,0 ); 
insert into funcionario values (NULL,"Ananda Maria Garcia Veduvoto","R: Euclides Miragaia, 87","Birigui/SP","Não consta.","Não consta.","Não consta.","11951412721","Não consta.","Não consta.","Ananda.veduvoto@gmail.com","Não consta.","Não consta.","Não consta.",2,"Não consta.",1,0 ); 
insert into funcionario values (NULL,"Andrea das Graças Souza Garcia","Rua: Silvio Romero, 875     ","Frutal","3434210048","Não consta.","Não consta.","34992374894","Não consta.","Não consta.","andrusaa@gmail.com","Não consta.","Não consta.","Não consta.",2,"Não consta.",1,0 ); 
insert into funcionario values (NULL,"Andreia Garcia Martins","R: General Glicerio, 4055","SJRP/SP","1732351986","Não consta.","Não consta.","Não consta.","Não consta.","Não consta.","andreiagarciamartins@gmail.com","Não consta.","Não consta.","Não consta.",2,"Não consta.",1,0 ); 
insert into funcionario values (NULL,"Carlos Alípio Caldeira","Rua: Siqueira Campos, 2358","SJRP/SP","Não consta.","Não consta.","Não consta.","17996154361","Não consta.","Não consta.","professorcaldeira@gmail.com","Não consta.","Não consta.","Não consta.",2,"Não consta.",1,0 ); 
insert into funcionario values (NULL,"Carolina Médici Veronezi","R: MMDC, 197","SJRP/SP","1732235553","Não consta.","Não consta.","17981629108","Não consta.","Não consta.","cveronezi@hotmail.com","Não consta.","Não consta.","Não consta.",2,"Não consta.",1,0 ); 
insert into funcionario values (NULL,"Cícero Marcelo de Oliveira","Av: Brasileira, 388 Ap 61   Redentora","SJRP/SP","1734822451","Não consta.","Não consta.","17981271400","Não consta.","Não consta.","cicero_auriflama@yahoo.com.br","Não consta.","Não consta.","Não consta.",2,"Não consta.",1,0 ); 
insert into funcionario values (NULL,"Cristiane Freitas de Azevedo Barros","Rua: conceição das Alagoas, 613","Frutal","Não consta.","Não consta.","Não consta.","31997116761","34991073073","Não consta.","crisfabarros@gmail.com","Não consta.","Não consta.","Não consta.",2,"Não consta.",1,0 ); 
insert into funcionario values (NULL,"Cristiane Pimentel Neder","Rua:Euclides da Cunha, 13 ","Frutal","Não consta.","Não consta.","Não consta.","48999097560","Não consta.","Não consta.","nederescritora@hotmail.com","Não consta.","Não consta.","Não consta.",2,"Não consta.",1,0 ); 
insert into funcionario values (NULL,"Daniela Peres Miguel","Av: Maranhão, 956","Uberaba","3433128643","Não consta.","Não consta.","34992293400","Não consta.","Não consta.","Danyperes28@gmail.com","Não consta.","Não consta.","Não consta.",2,"Não consta.",1,0 ); 
insert into funcionario values (NULL,"Daniela Soares Portela","Rua: Saturnino Acosta, 103 Damha 3","SJRP/SP","1732230924","Não consta.","Não consta.","17997624451","Não consta.","Não consta.","soares-portela@uol.com.br","Não consta.","Não consta.","Não consta.",2,"Não consta.",1,0 ); 
insert into funcionario values (NULL,"Danilton Carlos da Silva","Rua: Líbano, 398","Barretos/SP","3432620609","Não consta.","Não consta.","34999861690","Não consta.","Não consta.","daniltoncarlos@gmail.com","Não consta.","Não consta.","Não consta.",2,"Não consta.",1,0 ); 
insert into funcionario values (NULL,"Débora Maria Moreno Luzia","Rua: das Orquideas, 54","Frutal/MG","1735462170","Não consta.","Não consta.","17981292825","Não consta.","Não consta.","Deboramaria¬_moreno@yahoo.com.br","Não consta.","Não consta.","Não consta.",2,"Não consta.",1,0 ); 
insert into funcionario values (NULL,"Diego David dos Santos Silva","Av:  11, 254 Centro  ","Ituiutaba","3432613241","Não consta.","Não consta.","3499659626","Não consta.","Não consta.","diegoftm@gmail.com","Não consta.","Não consta.","Não consta.",2,"Não consta.",1,0 ); 
insert into funcionario values (NULL,"Eder Angelo Milani","R: São Paulo 110","Balsamo/SP","1732641450","Não consta.","Não consta.","17991445527","Não consta.","Não consta.","edinhomilani@hotmail.com","Não consta.","Não consta.","Não consta.",2,"Não consta.",1,0 ); 
insert into funcionario values (NULL,"Edna Yoshiko Senzako","Av: José da Silva Sá , 505","SJRP/SP","Não consta.","Não consta.","Não consta.","17996364345","Não consta.","Não consta.","ednays@gmail.com","Não consta.","Não consta.","Não consta.",2,"Não consta.",1,0 ); 
insert into funcionario values (NULL,"Eduardo Rodrigues Ferreira","Rua: Santo Minare, nº  984","Frutal","1839071423","Não consta.","Não consta.","Não consta.","Não consta.","Não consta.","duardorodrigues@ig.com.br","Não consta.","Não consta.","Não consta.",2,"Não consta.",1,0 ); 
insert into funcionario values (NULL,"Eduardo Silva Martins","Rua: Itapagipe, 1583","Frutal","Não consta.","Não consta.","Não consta.","3496670108","Não consta.","Não consta.","edusmartins@yahoo.com.br","Não consta.","Não consta.","Não consta.",2,"Não consta.",1,0 ); 
insert into funcionario values (NULL,"Eliana Aparecida Panarelli","Rua: Floriano Peixoto, 436 Centro","Frutal","3434235235","Não consta.","Não consta.","3492111444","Não consta.","Não consta.","epanarelli@ig.com.br","Não consta.","Não consta.","Não consta.",2,"Não consta.",1,0 ); 
insert into funcionario values (NULL,"Fausy Vieira Salomão","R: Terezinha de Souza Gambardela, 56","Frutal/MG","3434251112","Não consta.","Não consta.","34996671733","Não consta.","Não consta.","fausysalomao@hotmail.com","Não consta.","Não consta.","Não consta.",2,"Não consta.",1,0 ); 
insert into funcionario values (NULL,"Felipe Moreira","R: Padre Rodrigues , 60","Belo Horizonte","Não consta.","Não consta.","Não consta.","31975134512","Não consta.","Não consta.","pileef@gmail.com","Não consta.","Não consta.","Não consta.",2,"Não consta.",1,0 ); 
insert into funcionario values (NULL,"Fernando Melo  da Silva","Rua: Cap. Zeca de Pablo, 618","Franca /SP","1634098090","Não consta.","Não consta.","16981232827","Não consta.","Não consta.","Fernandomelo_silva@yahoo.com.br","Não consta.","Não consta.","Não consta.",2,"Não consta.",1,0 ); 
insert into funcionario values (NULL,"Fernando Ringel","Rua:Treze de Maio,730","Frutal","3434212837","Não consta.","Não consta.","3499964652","Não consta.","Não consta.","fernando.ringel@gmail.com","Não consta.","Não consta.","Não consta.",2,"Não consta.",1,0 ); 
insert into funcionario values (NULL,"Frederico Thales de Araújo Martos","R: Adilson Otoboni, 2931","Franca/SP","1637252398","Não consta.","Não consta.","16991399927","Não consta.","Não consta.","fredmartos@gmail.com","Não consta.","Não consta.","Não consta.",2,"Não consta.",1,0 ); 
insert into funcionario values (NULL,"Geisiane Rodrigues dos Santos","Rua: Pirajuba, 453","Frutal","Não consta.","Não consta.","Não consta.","3496617266","Não consta.","Não consta.","geisianers@bol.com.br","Não consta.","Não consta.","Não consta.",2,"Não consta.",1,0 ); 
insert into funcionario values (NULL,"Geraldo Nunes Corrêa","Rua: Taide de Castro Todaro, 70","Jaboticabal/SP","1632043726","Não consta.","Não consta.","1681395156","Não consta.","Não consta.","Geraldo.uemg@gmail.com","Não consta.","Não consta.","Não consta.",2,"Não consta.",1,0 ); 
insert into funcionario values (NULL,"Glauber Camacho Gimenez  Garcia","Rua: Silvio Romero, 875     ","Frutal","Não consta.","Não consta.","Não consta.","34992643936","Não consta.","Não consta.","camachoggarcia@gmail.com","Não consta.","Não consta.","Não consta.",2,"Não consta.",1,0 ); 
insert into funcionario values (NULL,"Halline Angelino Estanislau","Av: Euvaldo Lodi, 1426","Frutal","Não consta.","Não consta.","Não consta.","17988033873","34991381240","34984222766","hallinematematica@yahoo.com.br","Não consta.","Não consta.","Não consta.",2,"Não consta.",1,0 ); 
insert into funcionario values (NULL,"Iracema Senise Caproni","Rua: Antonio Seba, 2474","Votuporanga /SP","1734224623","Não consta.","Não consta.","17997274623","Não consta.","Não consta.","iracemacaproni@gmail.com","Não consta.","Não consta.","Não consta.",2,"Não consta.",1,0 ); 
insert into funcionario values (NULL,"Irene Rodrigues Freitas","R: Jequitibá, 475","SJRP/SP","1732232580","Não consta.","Não consta.","17981953021","Não consta.","Não consta.","irfreitas@yahoo.com.br","Não consta.","Não consta.","Não consta.",2,"Não consta.",1,0 ); 
insert into funcionario values (NULL,"Ivan José dos Reis Filho","Rua: Raul Soares, 1625","Frutal","Não consta.","Não consta.","Não consta.","34999749696","17982022714","Não consta.","ivanfilhoreis@hotmail.com","Não consta.","Não consta.","Não consta.",2,"Não consta.",1,0 ); 
insert into funcionario values (NULL,"Izabel Cristina Taceli","Rua: Augusto de Lima, 571","Frutal","343421-6718","Não consta.","Não consta.","34999741949","Não consta.","Não consta.","izabeltaceli@hotmail.com","Não consta.","Não consta.","Não consta.",2,"Não consta.",1,0 ); 
insert into funcionario values (NULL,"Jhansley Ferreira da Mata","Rua: Uberlandia, 1973","Frutal","3434213181","Não consta.","Não consta.","3492018488","Não consta.","Não consta.","jhansley@agronomo.eng.br","Não consta.","Não consta.","Não consta.",2,"Não consta.",1,0 ); 
insert into funcionario values (NULL,"Josney Freitas Silva","Rua: Dr. Tiago de Castro, 65","Frutal","Não consta.","Não consta.","Não consta.","34996699666","Não consta.","Não consta.","josneyf@gmail.com","Não consta.","Não consta.","Não consta.",2,"Não consta.",1,0 ); 
insert into funcionario values (NULL,"Julio Afonso Alves Dutra","Rua: Euclides da Cunha, 293 ","Frutal","3434215322","Não consta.","Não consta.","34992104999","Não consta.","Não consta.","jaadutra@hotmail.com","Não consta.","Não consta.","Não consta.",2,"Não consta.",1,0 ); 
insert into funcionario values (NULL,"Julio Cesar Ferreira Cirilo","R: Tupaciguara, 311","Frutal","3434212714","Não consta.","Não consta.","34991139531","Não consta.","Não consta.","Julio.cmdip@hotmail.com","Não consta.","Não consta.","Não consta.",2,"Não consta.",1,0 ); 
insert into funcionario values (NULL,"karina Luiza de Freitas Assunção","Rua: Paulo Martins Goulart ,734","Frutal","3434219690","Não consta.","Não consta.","34999950076","Não consta.","Não consta.","karinaluizafreitas@hotmail.com","Não consta.","Não consta.","Não consta.",2,"Não consta.",1,0 ); 
insert into funcionario values (NULL,"Karol Natasha Lourenço Castanheira","Rua: 04 de outubro, 165","Frutal","Não consta.","Não consta.","Não consta.","14981178408","Não consta.","Não consta.","karolnatasha@hotmail.com","Não consta.","Não consta.","Não consta.",2,"Não consta.",1,0 ); 
insert into funcionario values (NULL,"Leandro de Souza Pinheiro","Rua: Raul Soares, 1688","Frutal","3434213957","Não consta.","Não consta.","34988287008","Não consta.","Não consta.","bandopinheiro@yahoo.com.br","Não consta.","Não consta.","Não consta.",2,"Não consta.",1,0 ); 
insert into funcionario values (NULL,"Leila Maria Franco","R: José Marcal Costa , 187","Uberaba","3433215409","Não consta.","Não consta.","34999785447","Não consta.","Não consta.","leilamf@terra.com.br","Não consta.","Não consta.","Não consta.",2,"Não consta.",1,0 ); 
insert into funcionario values (NULL,"Leonardo Vieira Barcelos","Rua: Campina Verde,499","Frutal","3434236442","Não consta.","Não consta.","34999742545","Não consta.","Não consta.","leonardo@homine.com.br","Não consta.","Não consta.","Não consta.",2,"Não consta.",1,0 ); 
insert into funcionario values (NULL,"Loyana Christian de Lima Tomaz","Av: Araguari,1447","Uberlândia/MG","3432146610","Não consta.","Não consta.","3499929898","Não consta.","Não consta.","loyancl@gmail.com","Não consta.","Não consta.","Não consta.",2,"Não consta.",1,0 ); 
insert into funcionario values (NULL,"Luís Felipe Martins de Salles Roselino","Rua: Laudo de Camargo, 460","Ribeirão Preto/S.P","Não consta.","Não consta.","Não consta.","16991691600","Não consta.","Não consta.","felipe@guns.ru","Não consta.","Não consta.","Não consta.",2,"Não consta.",1,0 ); 
insert into funcionario values (NULL,"Luís Henrique Mendonça Ferraz","R: Siqueira Campos, 1871","Birigui/SP","1836421319","Não consta.","Não consta.","14997123120","Não consta.","Não consta.","luishferraz@yahoo.com.br","Não consta.","Não consta.","Não consta.",2,"Não consta.",1,0 ); 
insert into funcionario values (NULL,"Marcelo Pessoa de Oliveira","Av: São Paulo, 53 Eldorado","SJRP/SP","Não consta.","Não consta.","Não consta.","17997775026","Não consta.","Não consta.","mpmarcelopessoa@yahoo.com.br","Não consta.","Não consta.","Não consta.",2,"Não consta.",1,0 ); 
insert into funcionario values (NULL,"Marli Graniel Kinn","Praça da Matriz, apt 311","Frutal","3432172484","Não consta.","Não consta.","34999153828","Não consta.","Não consta.","mgkinn@yahoo.com","Não consta.","Não consta.","Não consta.",2,"Não consta.",1,0 ); 
insert into funcionario values (NULL,"Mauricio de Medeiros Caleiro","Rua: Pedroso de Camardo, 156","São Paulo/SP","34998342226","Não consta.","Não consta.","11989522838","Não consta.","Não consta.","mauricio.caleiro@gmail.com","Não consta.","Não consta.","Não consta.",2,"Não consta.",1,0 ); 
insert into funcionario values (NULL,"Mirts Helena Chagas","Rua: 4 de Outubro, 1167  ","Frutal","3434218197","Não consta.","Não consta.","34999743087","Não consta.","Não consta.","mirtshelena@hotmail.com","Não consta.","Não consta.","Não consta.",2,"Não consta.",1,0 ); 
insert into funcionario values (NULL,"Mônica  Souza Côrtes","Rua: das Orquideas, 101","Frutal","3434218489","Não consta.","Não consta.","34999741986","Não consta.","Não consta.","mo_leticia@yahooo.com.br","Não consta.","Não consta.","Não consta.",2,"Não consta.",1,0 ); 
insert into funcionario values (NULL,"Mônica Queiroz da Silva","Rua: Pedro Rodrigues Silveira, 1675","Frutal","3434214591","Não consta.","Não consta.","34999741597","34988280087","Não consta.","monicakeiroz@hotmail.com","Não consta.","Não consta.","Não consta.",2,"Não consta.",1,0 ); 
insert into funcionario values (NULL,"Osania  Emerenciano  Ferreira","Rua: Geraldo Valério de Souza, 215","Frutal","3434212693","Não consta.","Não consta.","34999932694","Não consta.","Não consta.","Osania.ferreira@hotmail.com","Não consta.","Não consta.","Não consta.",2,"Não consta.",1,0 ); 
insert into funcionario values (NULL,"Patrícia Alves Martins dos santos","Av: Maria Dias, 1101","Bebedouro","Não consta.","Não consta.","Não consta.","16997522357","Não consta.","Não consta.","patrícia_amsantos@hotmail.com","Não consta.","Não consta.","Não consta.",2,"Não consta.",1,0 ); 
insert into funcionario values (NULL,"Plínio Marcos Volponi Leal","Av: Silvio Della Rovere, 597 Q8","SJRP/SP","Não consta.","Não consta.","Não consta.","17997243260","Não consta.","Não consta.","pliniovolponi@gmail.com","Não consta.","Não consta.","Não consta.",2,"Não consta.",1,0 ); 
insert into funcionario values (NULL,"Rafael Altafin Galli","R: Dr. Benjamin Anderson Stouffer, 777","Ribeirão Preto","1638779769","Não consta.","Não consta.","16997093630","Não consta.","Não consta.","rafaelaltafim@hotmail.com","Não consta.","Não consta.","Não consta.",2,"Não consta.",1,0 ); 
insert into funcionario values (NULL,"Renata Campolin Camargo","R: Custódio Ribeiro Azambuja, 72","Frutal","3434212045","Não consta.","Não consta.","34991946166","Não consta.","Não consta.","rccampolim@gmail.com","Não consta.","Não consta.","Não consta.",2,"Não consta.",1,0 ); 
insert into funcionario values (NULL,"Renata de Souza Martinez","Rua: Honoria Toledo Carvalho, 15","Bebedouro/MG","1733435935","Não consta.","Não consta.","17997247497","Não consta.","Não consta.","renata.s.martinez@hotmail.com","Não consta.","Não consta.","Não consta.",2,"Não consta.",1,0 ); 
insert into funcionario values (NULL,"Renato Toller Bray","R: Vanor Junqueira Franco, 434","Bebedouro","Não consta.","Não consta.","Não consta.","17981443713","Não consta.","Não consta.","renatobray2003@yahoo.com.br","Não consta.","Não consta.","Não consta.",2,"Não consta.",1,0 ); 
insert into funcionario values (NULL,"Rodrigo Daniel Levoti Portari","Rua: Senador Gomes da Silva, 2981","Frutal","3434235203","Não consta.","Não consta.","34992310566","Não consta.","Não consta.","rdportari@terra.com.br","Não consta.","Não consta.","Não consta.",2,"Não consta.",1,0 ); 
insert into funcionario values (NULL,"Rodrigo Guilherme Tomaz","Rua: Raul Soares,1115","Frutal","3434218838","Não consta.","Não consta.","34999748868","34991800090","Não consta.","Rodrigo_frutal@hotmail.com","Não consta.","Não consta.","Não consta.",2,"Não consta.",1,0 ); 
insert into funcionario values (NULL,"Rodrigo Ney Millan","Rua: Araguari, 1269","Frutal","Não consta.","Não consta.","Não consta.","16991636482","Não consta.","Não consta.","rodrigomillan@yahoo.com.br","Não consta.","Não consta.","Não consta.",2,"Não consta.",1,0 ); 
insert into funcionario values (NULL,"Rozaine Aparecida Fontes Tomaz","Rua: Treze de Maio,138","Frutal","3434290060","Não consta.","Não consta.","34996501117","Não consta.","Não consta.","rozainefontes@gmail.com","Não consta.","Não consta.","Não consta.",2,"Não consta.",1,0 ); 
insert into funcionario values (NULL,"Thiago Torres Costa Pereira","Rua: Wiron de Paula Gomes, 291","Frutal","3434236720","Não consta.","Não consta.","34992204539","Não consta.","Não consta.","thiago.pereira@uemg.br","Não consta.","Não consta.","Não consta.",2,"Não consta.",1,0 ); 
insert into funcionario values (NULL,"Vanesca Korasaki","Rua: Bias Fortes, 583 apt. 10","Frutal","Não consta.","Não consta.","Não consta.","35991515267","Não consta.","Não consta.","Vanesca.korasaki@gmail.com","Não consta.","Não consta.","Não consta.",2,"Não consta.",1,0 ); 
insert into funcionario values (NULL,"Vinicius Fernandes Ormelesi","R: Rio Solimões, 1500","Franca/SP","Não consta.","Não consta.","Não consta.","16992797380","Não consta.","Não consta.","viniciusormelesi@hotmail.com","Não consta.","Não consta.","Não consta.",2,"Não consta.",1,0 ); 




