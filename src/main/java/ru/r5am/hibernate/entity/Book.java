package ru.r5am.hibernate.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by zoer on 14.01.2017.
 *
 */
@Entity
@Getter @Setter
public class Book implements Serializable{

    @Id     // задает первичный ключ объекта
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // генерация ID через Autoincrement в MySQL
    private long id;

    private String name;

    private long author_id;
}


