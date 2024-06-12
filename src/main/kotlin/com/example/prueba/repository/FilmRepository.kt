package com.example.prueba.repository

import com.example.prueba.entity.Film
import org.springframework.data.jpa.repository.JpaRepository

interface FilmRepository : JpaRepository<Film, Long?> {

}
