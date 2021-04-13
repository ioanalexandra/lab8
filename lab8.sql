

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";





CREATE TABLE `genres` (
  `id` int(11) NOT NULL,
  `name` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;



INSERT INTO `genres` (`id`, `name`) VALUES
(1, 'Drama'),
(3, 'Action');

-- --------------------------------------------------------



CREATE TABLE `movies` (
  `id` int(11) NOT NULL,
  `title` varchar(20) NOT NULL,
  `release_date` date NOT NULL DEFAULT current_timestamp(),
  `duration` time NOT NULL,
  `score` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;



INSERT INTO `movies` (`id`, `title`, `release_date`, `duration`, `score`) VALUES
(1, 'The Godfather', '1972-08-24', '02:55:00', 9),
(2, 'The Dark Knight', '2008-07-24', '02:32:00', 9),
(3, 'Fight Club', '1999-11-12', '02:19:00', 8);





CREATE TABLE `relation` (
  `movie_id` int(11) NOT NULL,
  `genre_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


INSERT INTO `relation` (`movie_id`, `genre_id`) VALUES
(1, 1),
(2, 3),
(3, 1);


ALTER TABLE `genres`
  ADD PRIMARY KEY (`id`);


ALTER TABLE `movies`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `relation`
  ADD KEY `movie_id` (`movie_id`),
  ADD KEY `genre_id` (`genre_id`);




ALTER TABLE `genres`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;


ALTER TABLE `movies`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;




ALTER TABLE `relation`
  ADD CONSTRAINT `relation_ibfk_1` FOREIGN KEY (`movie_id`) REFERENCES `movies` (`id`),
  ADD CONSTRAINT `relation_ibfk_2` FOREIGN KEY (`genre_id`) REFERENCES `genres` (`id`);
COMMIT;