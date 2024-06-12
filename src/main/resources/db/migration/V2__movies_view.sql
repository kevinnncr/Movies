
CREATE VIEW scene_with_film AS
SELECT s.id, s.description, s.budget, s.minutes, f.title AS film_title
FROM scene s
         JOIN film f ON s.film_id = f.id;



CREATE VIEW character_with_scene AS
SELECT c.id, c.description, c.cost, c.stock, s.description AS scene_description
FROM characters c
         JOIN scene s ON c.scene_id = s.id;
