package ru.r5am.hibernate.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by zoer on 14.01.2017.
 *
 */
@Entity
@Getter @Setter
public class Author implements Serializable {

    @Id     // задает первичный ключ объекта
    @GeneratedValue (strategy = GenerationType.IDENTITY)    // генерация ID через Autoincrement в MySQL
    private long id;

    private String name;
}
