CREATE TABLE players (
                         id SERIAL PRIMARY KEY,
                         name VARCHAR(255),
                         title VARCHAR(255),
                         race VARCHAR(50),
                         profession VARCHAR(50),
                         experience INT,
                         level INT,
                         until_next_level INT,
                         birthday DATE,
                         banned BOOLEAN
);

CREATE TABLE professions (
id SERIAL PRIMARY KEY,
name VARCHAR(50) UNIQUE NOT NULL
);

CREATE TABLE races (
id SERIAL PRIMARY KEY,
name VARCHAR(50) UNIQUE NOT NULL
);
--профессии
INSERT INTO professions (name) VALUES
                                   ('WARRIOR'),
                                   ('ROGUE'),
                                   ('SORCERER'),
                                   ('CLERIC'),
                                   ('PALADIN'),
                                   ('NAZGUL'),
                                   ('WARLOCK'),
                                   ('DRUID');

-- расы
INSERT INTO races (name) VALUES
                             ('HUMAN'),
                             ('DWARF'),
                             ('ELF'),
                             ('GIANT'),
                             ('ORC'),
                             ('TROLL'),
                             ('HOBBIT');