/*
SQLyog Ultimate v11.11 (64 bit)
MySQL - 5.5.5-10.2.20-MariaDB : Database - venta
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`venta` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `venta`;

/*Table structure for table `categoria` */

DROP TABLE IF EXISTS `categoria`;

CREATE TABLE `categoria` (
  `id` int(11) unsigned NOT NULL,
  `denominacion` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `categoria` */

insert  into `categoria`(`id`,`denominacion`) values (1,'Bebida 01'),(2,'Bebida 02'),(3,'Bebida 03'),(4,'Bebida 04');

/*Table structure for table `cliente` */

DROP TABLE IF EXISTS `cliente`;

CREATE TABLE `cliente` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(120) NOT NULL,
  `apellido` varchar(100) NOT NULL,
  `direccion` varchar(160) NOT NULL,
  `dni` char(8) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `cliente` */

insert  into `cliente`(`id`,`nombre`,`apellido`,`direccion`,`dni`) values (1,'Santiago','Cacha','Huaraz 1','00000001');

/*Table structure for table `detalle` */

DROP TABLE IF EXISTS `detalle`;

CREATE TABLE `detalle` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `precio` decimal(10,2) unsigned NOT NULL,
  `cantidad` int(11) unsigned NOT NULL,
  `producto_id` int(11) unsigned NOT NULL,
  `factura_id` int(11) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_detalle_producto1_idx` (`producto_id`),
  KEY `fk_detalle_factura1_idx` (`factura_id`),
  CONSTRAINT `fk_detalle_factura1_idx` FOREIGN KEY (`factura_id`) REFERENCES `factura` (`id`),
  CONSTRAINT `fk_detalle_producto1_idx` FOREIGN KEY (`producto_id`) REFERENCES `producto` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `detalle` */

insert  into `detalle`(`id`,`precio`,`cantidad`,`producto_id`,`factura_id`) values (1,12.00,10,1,1);

/*Table structure for table `factura` */

DROP TABLE IF EXISTS `factura`;

CREATE TABLE `factura` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `numero` int(7) unsigned zerofill NOT NULL,
  `fecha` date DEFAULT NULL,
  `cliente_id` int(11) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_factura_cliente1_idx` (`cliente_id`),
  CONSTRAINT `fk_factura_cliente1` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `factura` */

insert  into `factura`(`id`,`numero`,`fecha`,`cliente_id`) values (1,0000002,'2019-01-12',1);

/*Table structure for table `producto` */

DROP TABLE IF EXISTS `producto`;

CREATE TABLE `producto` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  `stock` int(11) NOT NULL,
  `categoria_id` int(11) unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

/*Data for the table `producto` */

insert  into `producto`(`id`,`nombre`,`stock`,`categoria_id`) values (1,'Producto 1',190,18),(2,'Producto 2',112,22),(28,'Producto 3',32,10),(29,'Producto',154,10),(30,'Producto 5',94,1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
