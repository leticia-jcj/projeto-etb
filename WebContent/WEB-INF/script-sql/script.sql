SET NAMES utf8;
SET time_zone = '+00:00';
SET foreign_key_checks = 0;
SET sql_mode = 'NO_AUTO_VALUE_ON_ZERO';

DROP TABLE IF EXISTS `cliente`;
CREATE TABLE `cliente` (
  `idCliente` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(90) COLLATE utf8_danish_ci NOT NULL,
  `cpf` varchar(15) COLLATE utf8_danish_ci NOT NULL,
  `email` varchar(90) COLLATE utf8_danish_ci NOT NULL,
  `endereco` varchar(256) COLLATE utf8_danish_ci NOT NULL,
  `telefone` varchar(15) COLLATE utf8_danish_ci NOT NULL,
  PRIMARY KEY (`idCliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_danish_ci;


DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `idMenu` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) COLLATE utf8_danish_ci NOT NULL,
  `link` varchar(128) COLLATE utf8_danish_ci NOT NULL,
  `icone` varchar(128) COLLATE utf8_danish_ci DEFAULT NULL,
  `exibir` int(11) NOT NULL,
  PRIMARY KEY (`idMenu`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_danish_ci;


DROP TABLE IF EXISTS `menu_perfil`;
CREATE TABLE `menu_perfil` (
  `idMenu` int(11) NOT NULL,
  `idPerfil` int(11) NOT NULL,
  PRIMARY KEY (`idMenu`,`idPerfil`),
  KEY `fk_menu_has_perfil_perfil1_idx` (`idPerfil`),
  KEY `fk_menu_has_perfil_menu1_idx` (`idMenu`),
  CONSTRAINT `fk_menu_has_perfil_menu1` FOREIGN KEY (`idMenu`) REFERENCES `menu` (`idMenu`) ON UPDATE CASCADE,
  CONSTRAINT `fk_menu_has_perfil_perfil1` FOREIGN KEY (`idPerfil`) REFERENCES `perfil` (`idPerfil`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_danish_ci;


DROP TABLE IF EXISTS `perfil`;
CREATE TABLE `perfil` (
  `idPerfil` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) COLLATE utf8_danish_ci NOT NULL,
  `dataCadastro` date DEFAULT NULL,
  PRIMARY KEY (`idPerfil`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_danish_ci;


DROP TABLE IF EXISTS `usuario`;
CREATE TABLE `usuario` (
  `idUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(128) COLLATE utf8_danish_ci NOT NULL,
  `login` varchar(24) COLLATE utf8_danish_ci NOT NULL,
  `senha` varchar(256) COLLATE utf8_danish_ci NOT NULL,
  `status` int(11) NOT NULL,
  `idPerfil` int(11) NOT NULL,
  PRIMARY KEY (`idUsuario`),
  KEY `fk_usuario_perfil_idx` (`idPerfil`),
  CONSTRAINT `fk_usuario_perfil` FOREIGN KEY (`idPerfil`) REFERENCES `perfil` (`idPerfil`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_danish_ci;

INSERT INTO `perfil` (`idPerfil`, `nome`, `dataCadastro`) VALUES
(1,	'Administrador',	'2022-03-18'),
(2,	'Gerente',	'2022-03-18'),
(3,	'Funcionário',	'2022-03-18'),
(4,	'Cliente',	'2022-03-18');

INSERT INTO `cliente` (`idCliente`, `nome`, `cpf`, `email`, `endereco`, `telefone`) VALUES
(1,	'Luana Maria Vicente',	'456.256.584.00',	'luana.maria@gmail.com',	'Quadra 201 Apto 201',	'61 3333-3333'),
(2,	'Lucas Padilha Rosa',	'456.256.584.66',	'lucas.padilha@gmail.com',	'Quadra 301 Apto 301',	'61 3444-3444'),
(3,	'Luma de Oliveira',	'456.256.584.55',	'luma.oliviera@gmail.com',	'Quadra 702 Apto 702',	'61 3337-3337'),
(4,	'Laura Marçal',	'456.256.584.88',	'laura.marcal@gmail.com',	'Quadra 601 Apto 601',	'61 3332-3332');

INSERT INTO `menu` (`idMenu`, `nome`, `link`, `icone`, `exibir`) VALUES
(5,	'Home',	'/index.jsp',	'',	1),
(6,	'Perfis',	'/listarPerfis.jsp',	'',	1),
(7,	'Menus',	'/listarMenus.jsp',	'',	1),
(8,	'Cliente',	'/listarCliente.jsp',	'',	1),
(9,	'Usuario',	'/listarUsuario.jsp',	'',	1),
(10,	'Cadastrar Cliente',	'/cadastrarCliente.jsp',	'',	1),
(11,	'Cadastrar Usuário',	'/cadastrarUsuario.jsp',	'',	1),
(12,	'Cadastrar Menu',	'/cadastrarMenu.jsp',	'',	1),
(13,	'Cadastrar Perfis',	'/cadastrarPerfis.jsp',	'',	1);

USE `projetoetb2022`;


