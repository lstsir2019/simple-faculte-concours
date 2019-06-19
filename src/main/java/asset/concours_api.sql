-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  mer. 19 juin 2019 à 15:22
-- Version du serveur :  10.1.37-MariaDB
-- Version de PHP :  7.3.0

SET FOREIGN_KEY_CHECKS=0;
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `concours_api`
--

-- --------------------------------------------------------

--
-- Structure de la table `coef_module_concours`
--

CREATE TABLE `coef_module_concours` (
  `id` bigint(20) NOT NULL,
  `coef` double NOT NULL,
  `ref_filiere` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `coef_module_concours`
--

INSERT INTO `coef_module_concours` (`id`, `coef`, `ref_filiere`) VALUES
(12, 2, 'GC'),
(10, 3, 'GC'),
(3, 3, 'IRISI'),
(5, 5, 'IRISI'),
(7, 2, 'IRISI'),
(14, 3, 'GC');

-- --------------------------------------------------------

--
-- Structure de la table `concours`
--

CREATE TABLE `concours` (
  `id` bigint(20) NOT NULL,
  `annee_concours` int(11) NOT NULL,
  `date_concours_ecrit` date DEFAULT NULL,
  `date_concours_oral` date DEFAULT NULL,
  `nbreplace` int(20) DEFAULT NULL,
  `nbreplace_concours_ecrit` int(20) DEFAULT NULL,
  `nbreplace_concours_oral` int(20) DEFAULT NULL,
  `ref_filiere` varchar(255) DEFAULT NULL,
  `reference` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `concours`
--

INSERT INTO `concours` (`id`, `annee_concours`, `date_concours_ecrit`, `date_concours_oral`, `nbreplace`, `nbreplace_concours_ecrit`, `nbreplace_concours_oral`, `ref_filiere`, `reference`) VALUES
(9, 2021, '2021-04-02', '2021-05-15', 20, 200, 50, 'GC', 'Concours d\'acces a la premiere annee du au cycle d\'ingenieur GC'),
(2, 2020, '2019-07-03', '2019-07-20', 4, 10, 7, 'IRISI', 'Concours d\'acces a la premiere annee du au cycle d\'ingenieur IRISI');

-- --------------------------------------------------------

--
-- Structure de la table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(33),
(33),
(33);

-- --------------------------------------------------------

--
-- Structure de la table `module_concours`
--

CREATE TABLE `module_concours` (
  `id` bigint(20) NOT NULL,
  `reference` varchar(255) DEFAULT NULL,
  `coef_module_concours` bigint(20) DEFAULT NULL,
  `concours` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `module_concours`
--

INSERT INTO `module_concours` (`id`, `reference`, `coef_module_concours`, `concours`) VALUES
(13, 'Informatique', 12, 9),
(11, 'MATHS', 10, 9),
(4, 'Maths', 3, 2),
(6, 'Informatique', 5, 2),
(8, 'Physique', 7, 2),
(15, 'Physique', 14, 9);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `coef_module_concours`
--
ALTER TABLE `coef_module_concours`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `concours`
--
ALTER TABLE `concours`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `module_concours`
--
ALTER TABLE `module_concours`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKrnu20hbp5ygyg4ij045i5tgxk` (`coef_module_concours`),
  ADD KEY `FK9l1maapko70u5af0c5xd6qeqq` (`concours`);
SET FOREIGN_KEY_CHECKS=1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
