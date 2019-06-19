-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Mar 12 Mars 2019 à 01:59
-- Version du serveur :  5.6.17
-- Version de PHP :  5.5.12

SET FOREIGN_KEY_CHECKS=0;
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `concours_api`
--

--
-- Contenu de la table `coef_module_concours`
--

INSERT INTO `coef_module_concours` (`id`, `coef`, `ref_filiere`, `module_concours`) VALUES
(3, '4.00', 'GE', 2),
(5, '3.00', 'GE', 4),
(8, '4.00', 'Irisi', 7),
(10, '3.00', 'Irisi', 9);

--
-- Contenu de la table `concours`
--

INSERT INTO `concours` (`id`, `date_concours`, `lieu`, `nbreetudiant`, `ref_filiere`, `reference`) VALUES
(1, '2020-02-10', NULL, '30.00', 'GE', 'ConcoursGE'),
(6, '2020-08-09', NULL, '30.00', 'Irisi', 'ConcoursIrisi');

--
-- Contenu de la table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(11),
(11),
(11);

--
-- Contenu de la table `module_concours`
--

INSERT INTO `module_concours` (`id`, `ref_module`, `concours`) VALUES
(2, 'programmation ', 1),
(4, 'analyse', 1),
(7, 'programmation c', 6),
(9, 'SGBD', 6);
SET FOREIGN_KEY_CHECKS=1;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
