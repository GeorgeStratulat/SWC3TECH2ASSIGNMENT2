-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 30 Noi 2017 la 10:59
-- Versiune server: 10.1.21-MariaDB
-- PHP Version: 7.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `swc3tech2`
--

-- --------------------------------------------------------

--
-- Structura de tabel pentru tabelul `courses`
--

CREATE TABLE `courses` (
  `id` int(55) NOT NULL,
  `name_course_dk` varchar(255) NOT NULL,
  `name_course_en` varchar(255) NOT NULL,
  `class_code` varchar(255) NOT NULL,
  `study_programme` varchar(255) NOT NULL,
  `mandatory` varchar(255) NOT NULL,
  `etcs` int(255) NOT NULL,
  `course_language` varchar(255) NOT NULL,
  `minimum_students` int(55) NOT NULL,
  `expected_students` int(55) NOT NULL,
  `maximum_students` int(55) NOT NULL,
  `prerequisites` varchar(255) NOT NULL,
  `learning_outcome` varchar(255) NOT NULL,
  `content` varchar(255) NOT NULL,
  `learning_activities` varchar(255) NOT NULL,
  `exam_form` varchar(255) NOT NULL,
  `teachers` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Salvarea datelor din tabel `courses`
--

INSERT INTO `courses` (`id`, `name_course_dk`, `name_course_en`, `class_code`, `study_programme`, `mandatory`, `etcs`, `course_language`, `minimum_students`, `expected_students`, `maximum_students`, `prerequisites`, `learning_outcome`, `content`, `learning_activities`, `exam_form`, `teachers`) VALUES
(1, 'Full Stack NodeJs', 'Full Stack NodeJs', 'WD-2018-F-NODEJS', 'Web development', 'Elective', 10, 'English', 15, 35, 50, 'Students must know HTML', 'learn NodeJs', 'classes NodeJs', 'coding NodeJs', 'orale', 'Santiago'),
(2, 'Full Stack Android', 'Full Stack Android', 'WD-2018-F-ANDROID\r\n', 'Software Development', 'Elective', 10, 'English', 15, 35, 50, 'Java', 'learning Android', 'content for Android', 'coding Android', 'oral', 'Alex'),
(3, 'rewrwk', 'jkgjkgjw', 'gkrjg', 'gjr', 'gj', 10, 'rfjs', 11, 15, 25, 'gjfkjg', 'gkefjgk', 'gjekg', 'kjbfkj', 'bjkfejb', 'bkfe'),
(4, 'pula mea', 'fdksjfsdk', 'gfdkj', 'gkfjgk', 'gkfjg', 10, 'jkfdgj', 10, 15, 25, 'dsg', 'gfdg', 'bgfdgbfb', 'bebe', 'bebe', 'be'),
(5, 'Pula mea', 'rlewk', 'gjer', 'gireio', 'gji', 10, 'gkfdj', 12, 15, 18, 'rlkwej', 'kfejk', 'kgjrek', 'kgjrekgj', 'kgjkrejg', 'kg');

-- --------------------------------------------------------

--
-- Structura de tabel pentru tabelul `student`
--

CREATE TABLE `student` (
  `id` int(55) NOT NULL,
  `course_id` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Salvarea datelor din tabel `student`
--

INSERT INTO `student` (`id`, `course_id`) VALUES
(1, '1,2,3'),
(4, '4,5'),
(5, '1,2,3'),
(6, '4,5');

-- --------------------------------------------------------

--
-- Structura de tabel pentru tabelul `teachers`
--

CREATE TABLE `teachers` (
  `id` int(55) NOT NULL,
  `course_id` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Salvarea datelor din tabel `teachers`
--

INSERT INTO `teachers` (`id`, `course_id`) VALUES
(1, '2,3,5'),
(2, '1,3,3,4');

-- --------------------------------------------------------

--
-- Structura de tabel pentru tabelul `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `type` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Salvarea datelor din tabel `users`
--

INSERT INTO `users` (`id`, `type`) VALUES
(1, 'student'),
(2, 'teacher'),
(3, 'admin');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `courses`
--
ALTER TABLE `courses`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `teachers`
--
ALTER TABLE `teachers`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `courses`
--
ALTER TABLE `courses`
  MODIFY `id` int(55) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `student`
--
ALTER TABLE `student`
  MODIFY `id` int(55) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `teachers`
--
ALTER TABLE `teachers`
  MODIFY `id` int(55) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
