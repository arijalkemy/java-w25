-- Crear la tabla temporal TWD
CREATE TEMP TABLE TWD (
    id SERIAL PRIMARY KEY,
    episode_number INT,
    title VARCHAR(100),
    season_number INT
);

-- Insertar los episodios de The Walking Dead en la tabla temporal TWD
INSERT INTO TWD (episode_number, title, season_number)
SELECT episode_number, title, season_number
FROM episodes
WHERE series_id = (
    SELECT id FROM series WHERE name = 'The Walking Dead'
);

-- Consulta para ver los episodios de la primera temporada
SELECT *
FROM TWD
WHERE season_number = 1;


CREATE INDEX idx_title ON movies(title);