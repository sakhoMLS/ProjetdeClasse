-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  lun. 29 mars 2021 à 13:41
-- Version du serveur :  10.4.8-MariaDB
-- Version de PHP :  7.3.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `jeesamba`
--

-- --------------------------------------------------------

--
-- Structure de la table `classe`
--

CREATE TABLE `classe` (
  `idC` int(11) NOT NULL,
  `libelle` varchar(250) NOT NULL,
  `matiere1` varchar(255) NOT NULL,
  `matiere2` varchar(255) NOT NULL,
  `matiere3` varchar(255) NOT NULL,
  `matiere4` varchar(255) NOT NULL,
  `matiere5` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `classe`
--

INSERT INTO `classe` (`idC`, `libelle`, `matiere1`, `matiere2`, `matiere3`, `matiere4`, `matiere5`) VALUES
(1, 'L1GL', 'HTML', 'LC', 'MATHS', 'ANGLAIS', 'ALGO'),
(2, 'L2GL', 'LC', 'ANGLAIS', 'C++', 'MATHS', 'JAVA'),
(3, 'L3GL', 'JAVA', 'C++', 'ALGO', 'HTML', 'PHP'),
(4, 'M1GL', 'PHP', 'ASP_NET', 'JEE', 'RO', 'JAVA'),
(5, 'M2GL', 'ASP_NET', 'JEE', 'C++', 'PHP', 'LINUX'),
(6, 'D1GL', 'RX', 'WINDOWS', 'LINUX', 'CLOUD', 'SERVER'),
(7, 'D2GL', 'SERVER', 'SECURITE', 'JEE', 'LINUX', 'CLOUD');

-- --------------------------------------------------------

--
-- Structure de la table `etudiant`
--

CREATE TABLE `etudiant` (
  `id` int(11) NOT NULL,
  `nom` varchar(250) NOT NULL,
  `prenom` varchar(250) NOT NULL,
  `tel` varchar(15) NOT NULL,
  `id_classe` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `etudiant`
--

INSERT INTO `etudiant` (`id`, `nom`, `prenom`, `tel`, `id_classe`) VALUES
(1, 'Ndiaye', 'Samba', '772135896', 4),
(2, 'Seck', 'Alou', '778542138', 3),
(3, 'Fall', 'Mareme', '789645823', 1),
(5, 'Diop', 'Adama', '768945213', 5);

-- --------------------------------------------------------

--
-- Structure de la table `notes`
--

CREATE TABLE `notes` (
  `idN` int(11) NOT NULL,
  `id_etudiant` int(11) NOT NULL,
  `note1` int(10) NOT NULL,
  `note2` int(10) NOT NULL,
  `note3` int(10) NOT NULL,
  `note4` int(10) NOT NULL,
  `note5` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `notes`
--

INSERT INTO `notes` (`idN`, `id_etudiant`, `note1`, `note2`, `note3`, `note4`, `note5`) VALUES
(1, 1, 0, 0, 0, 0, 0),
(2, 2, 0, 0, 0, 0, 0);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `classe`
--
ALTER TABLE `classe`
  ADD PRIMARY KEY (`idC`);

--
-- Index pour la table `etudiant`
--
ALTER TABLE `etudiant`
  ADD PRIMARY KEY (`id`),
  ADD KEY `classe` (`id_classe`);

--
-- Index pour la table `notes`
--
ALTER TABLE `notes`
  ADD PRIMARY KEY (`idN`),
  ADD KEY `id_etudiant` (`id_etudiant`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `classe`
--
ALTER TABLE `classe`
  MODIFY `idC` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT pour la table `etudiant`
--
ALTER TABLE `etudiant`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `notes`
--
ALTER TABLE `notes`
  MODIFY `idN` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
