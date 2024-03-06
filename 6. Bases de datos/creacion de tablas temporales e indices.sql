# 1.
USE movies_db;

CREATE TEMPORARY TABLE TWD select * from episodes where season_id in (
	SELECT id season_id FROM seasons where serie_id in (
		select id from series where title = 'The Walking Dead'
	)
);

# 2.
SHOW INDEX FROM episodes;
# Pienso que la title de los episodios puede ser un atributo en el que la consulta puede sufrir mas
# debido a que es de texto y puede ser comparado de varias formas.