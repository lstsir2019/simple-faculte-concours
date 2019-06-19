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

-- --------------------------------------------------------

--
-- Structure de la table `coef_module_concours`
--

CREATE TABLE IF NOT EXISTS `coef_module_concours` (
  `id` bigint(20) NOT NULL,
  `coef` decimal(19,2) DEFAULT NULL,
  `ref_filiere` varchar(255) DEFAULT NULL,
  `module_concours` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKn8tjm0qfac4v55yus3ighu63t` (`module_concours`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `concours`
--

CREATE TABLE IF NOT EXISTS `concours` (
  `id` bigint(20) NOT NULL,
  `date_concours` date DEFAULT NULL,
  `lieu` varchar(255) DEFAULT NULL,
  `nbreetudiant` decimal(19,2) DEFAULT NULL,
  `ref_filiere` varchar(255) DEFAULT NULL,
  `reference` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `hibernate_sequence`
--

CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `module_concours`
--

CREATE TABLE IF NOT EXISTS `module_concours` (
  `id` bigint(20) NOT NULL,
  `ref_module` varchar(255) DEFAULT NULL,
  `concours` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK9l1maapko70u5af0c5xd6qeqq` (`concours`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
SET FOREIGN_KEY_CHECKS=1;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
