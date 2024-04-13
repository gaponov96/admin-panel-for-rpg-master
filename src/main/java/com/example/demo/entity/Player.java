package com.example.demo.entity;
/*
Long id                | ID игрока                                                       |
|------------------------|-----------------------------------------------------------------|
| String                 | name Имя персонажа (до 12 знаков включительно)                  |
| String                 | title Титул персонажа (до 30 знаков включительно)               |
| Race race              | Расса персонажа                                                 |
| Profession profession  | Профессия персонажа                                             |
| Integer experience     | Опыт персонажа. Диапазон значений 0..10,000,000                 |
| Integer level          | Уровень персонажа                                               |
| Integer untilNextLevel | Остаток опыта до следующего уровня                              |
| Date birthday          | Дата регистрации Диапазон значений года 2000..3000 включительно |
| Boolean banned         | Забанен / не забанен
*/

import lombok.Data;

import java.util.Date;
@Data
public class Player {

    private Integer id;

    private String name;

    private String title;

    private Race race;

    private Profession profession;

    private Integer experience;

    private Integer level;

    private Integer untilNextLevel;

    private Date birthday;

    private Boolean banned;


}
