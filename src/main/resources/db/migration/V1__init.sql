CREATE TABLE IF NOT EXISTS film (
    id SERIAL,
    title VARCHAR(255) NOT NULL,
    director VARCHAR(255),
    duration INT,
    PRIMARY KEY (id)
    );

CREATE TABLE IF NOT EXISTS scene (
    id SERIAL,
    description VARCHAR(300) NOT NULL,
    budget DECIMAL(10, 2),
    minutes INT,
    film_id INT,
    PRIMARY KEY (id),
    FOREIGN KEY (film_id) REFERENCES film(id)
    );

CREATE TABLE IF NOT EXISTS characters (
    id SERIAL,
    description VARCHAR(300)NOT NULL,
    cost DECIMAL(10, 2),
    stock INT,
    scene_id INT,
    PRIMARY KEY (id),
    FOREIGN KEY (scene_id) REFERENCES scene(id)
    );
