CREATE TEMPORARY TABLE TWD (
    id int primary key,
    title varchar(500),
    number int,
    release_date datetime,
    rating decimal(3, 1),
    season_id int
);

INSERT INTO TWD VALUES
    (1, 'S01E01', 1, '2000-01-01', 9, 1),
    (2, 'S01E02', 2, '2000-01-01', 8, 1),
    (3, 'S01E03', 3, '2000-01-01', 8, 1),
    (4, 'S02E01', 1, '2000-01-01', 7, 2),
    (5, 'S02E02', 2, '2000-01-01', 9, 2),
    (6, 'S02E03', 3, '2000-01-01', 6, 2);

SELECT title
FROM TWD
WHERE season_id = 1;