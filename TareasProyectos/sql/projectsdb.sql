-- phpMyAdmin SQL Dump
-- version 4.5.4.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 04-02-2018 a las 18:11:46
-- Versión del servidor: 5.7.11
-- Versión de PHP: 5.6.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `projectsdb`
--
CREATE DATABASE IF NOT EXISTS `projectsdb` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `projectsdb`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proyecto`
--

DROP TABLE IF EXISTS `proyecto`;
CREATE TABLE `proyecto` (
  `pid` int(11) NOT NULL,
  `titulo` varchar(256) NOT NULL,
  `propietario` int(11) NOT NULL,
  `fecha_inicio` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `proyecto`
--

INSERT INTO `proyecto` (`pid`, `titulo`, `propietario`, `fecha_inicio`) VALUES
(1, 'proy 1', 1, '2017-06-07 22:00:00'),
(2, 'proy 2', 1, '2017-06-07 22:00:00'),
(3, 'prov 3', 1, '2017-06-07 22:00:00'),
(4, 'prov 4', 2, '2017-06-27 16:28:02');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tarea`
--

DROP TABLE IF EXISTS `tarea`;
CREATE TABLE `tarea` (
  `tid` int(11) NOT NULL,
  `descripcion` varchar(256) NOT NULL,
  `estimado` int(11) NOT NULL,
  `dedicado` int(11) NOT NULL,
  `restante` int(11) NOT NULL,
  `estado` int(11) NOT NULL DEFAULT '1',
  `propietario` int(11) NOT NULL,
  `proyecto` int(11) NOT NULL,
  `fecha` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `tarea`
--

INSERT INTO `tarea` (`tid`, `descripcion`, `estimado`, `dedicado`, `restante`, `estado`, `propietario`, `proyecto`, `fecha`) VALUES
(1, 'Tarea 1', 10, 11, 2, 1, 1, 1, '2017-06-07 22:00:00'),
(2, 'Tarea 2', 7, 8, 9, 2, 1, 1, '2017-06-07 22:00:00'),
(3, 'Tarea 3', 15, 14, 5, 1, 2, 2, '2017-06-07 22:00:00'),
(4, 'Tarea 4', 19, 9, 4, 3, 2, 2, '2017-06-07 22:00:00'),
(5, 'Tarea 5', 13, 13, 8, 2, 2, 2, '2017-06-07 22:00:00'),
(6, 'Tarea 6', 16, 18, 0, 3, 2, 3, '2017-06-07 22:00:00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE `usuario` (
  `uid` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `email` varchar(256) NOT NULL,
  `edad` int(11) DEFAULT NULL,
  `password` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`uid`, `nombre`, `apellido`, `email`, `edad`, `password`) VALUES
(1, 'Ricardo', 'Ricarson', 'ricardo@r.com', 54, 'ric'),
(2, 'Rosa', 'Roseson', 'ros@p.is', 54, 'rrr'),
(3, 'Juana', 'Juanason', 'j@j.com', 29, 'jjj'),
(5, 'Fernando', 'Ferdinanson', 'f@f.com', 14, 'fff');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `proyecto`
--
ALTER TABLE `proyecto`
  ADD PRIMARY KEY (`pid`),
  ADD UNIQUE KEY `pid_UNIQUE` (`pid`),
  ADD KEY `fk_proyecto_usuario_idx` (`propietario`);

--
-- Indices de la tabla `tarea`
--
ALTER TABLE `tarea`
  ADD PRIMARY KEY (`tid`,`propietario`,`proyecto`),
  ADD UNIQUE KEY `tid_UNIQUE` (`tid`),
  ADD KEY `fk_tarea_usuario1_idx` (`propietario`),
  ADD KEY `fk_tarea_proyecto1_idx` (`proyecto`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`uid`,`email`),
  ADD UNIQUE KEY `uid_UNIQUE` (`uid`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `proyecto`
--
ALTER TABLE `proyecto`
  MODIFY `pid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT de la tabla `tarea`
--
ALTER TABLE `tarea`
  MODIFY `tid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `uid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `proyecto`
--
ALTER TABLE `proyecto`
  ADD CONSTRAINT `fk_proyecto_usuario` FOREIGN KEY (`propietario`) REFERENCES `usuario` (`uid`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `tarea`
--
ALTER TABLE `tarea`
  ADD CONSTRAINT `fk_tarea_proyecto1` FOREIGN KEY (`proyecto`) REFERENCES `proyecto` (`pid`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_tarea_usuario1` FOREIGN KEY (`propietario`) REFERENCES `usuario` (`uid`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
