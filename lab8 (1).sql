

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


CREATE TABLE `actors` (
  `id` int(11) NOT NULL,
  `nume` varchar(20) NOT NULL,
  `prenume` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;



INSERT INTO `actors` (`id`, `nume`, `prenume`) VALUES
(1, 'Jolie', 'Angelina'),
(2, 'Nicholson', 'Jack'),
(3, 'Hanks', 'Tom'),
(4, 'DiCaprio', 'Leonardo');


CREATE TABLE `actor_movies` (
  `actor_id` int(11) NOT NULL,
  `movie_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


INSERT INTO `actor_movies` (`actor_id`, `movie_id`) VALUES
(4, 4),
(3, 2),
(3, 1),
(1, 3),
(2, 1);


CREATE TABLE `directors` (
  `id` int(11) NOT NULL,
  `nume` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


INSERT INTO `directors` (`id`, `nume`) VALUES
(1, 'Tarantino'),
(2, 'Spielberg'),
(3, 'Nolan');


CREATE TABLE `directors_movies` (
  `director_id` int(11) NOT NULL,
  `movie_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;



INSERT INTO `directors_movies` (`director_id`, `movie_id`) VALUES
(3, 2),
(1, 4),
(2, 3),
(2, 1);



CREATE TABLE `genres` (
  `id` int(11) NOT NULL,
  `name` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;



INSERT INTO `genres` (`id`, `name`) VALUES
(1, 'Drama'),
(3, 'Action'),
(4, 'romantic');



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
(3, 'Fight Club', '1999-11-12', '02:19:00', 8),
(4, 'Titanic', '1997-01-23', '02:55:00', 7);


CREATE TABLE `relation` (
  `movie_id` int(11) NOT NULL,
  `genre_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


INSERT INTO `relation` (`movie_id`, `genre_id`) VALUES
(1, 1),
(2, 3),
(3, 1),
(4, 4);

ALTER TABLE `actors`
  ADD PRIMARY KEY (`id`);


ALTER TABLE `actor_movies`
  ADD KEY `actor_id` (`actor_id`),
  ADD KEY `movie_id` (`movie_id`);

ALTER TABLE `directors`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `directors_movies`
  ADD KEY `director_id` (`director_id`),
  ADD KEY `movie_id` (`movie_id`);


ALTER TABLE `genres`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `movies`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `relation`
  ADD KEY `movie_id` (`movie_id`),
  ADD KEY `genre_id` (`genre_id`);


ALTER TABLE `actors`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

ALTER TABLE `directors`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

ALTER TABLE `genres`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

ALTER TABLE `movies`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

ALTER TABLE `actor_movies`
  ADD CONSTRAINT `actor_movies_ibfk_1` FOREIGN KEY (`actor_id`) REFERENCES `actors` (`id`),
  ADD CONSTRAINT `actor_movies_ibfk_2` FOREIGN KEY (`movie_id`) REFERENCES `movies` (`id`);


ALTER TABLE `directors_movies`
  ADD CONSTRAINT `directors_movies_ibfk_1` FOREIGN KEY (`director_id`) REFERENCES `directors` (`id`),
  ADD CONSTRAINT `directors_movies_ibfk_2` FOREIGN KEY (`movie_id`) REFERENCES `movies` (`id`);


ALTER TABLE `relation`
  ADD CONSTRAINT `relation_ibfk_1` FOREIGN KEY (`movie_id`) REFERENCES `movies` (`id`),
  ADD CONSTRAINT `relation_ibfk_2` FOREIGN KEY (`genre_id`) REFERENCES `genres` (`id`);
COMMIT;


