package com.example.prueba.repository

import com.example.prueba.entity.Characters
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface CharactersRepository : JpaRepository<Characters, Long?> {
    @Query("SELECT SUM(s.minutes) FROM Scene s WHERE s.film.id = :filmId")
    fun sumMinutesByFilmId(filmId: Long): Int
}