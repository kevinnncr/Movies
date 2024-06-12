package com.example.prueba.service

import com.example.prueba.entity.Film
import com.example.prueba.repository.FilmRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class FilmService {
    @Autowired
    lateinit var filmRepository: FilmRepository

    fun list(): List<Film> {
        return filmRepository.findAll()
    }

    fun getById(id: Long): Film {
        return filmRepository.findById(id).orElseThrow { RuntimeException("Film not found") }
    }

    fun save(film: Film): Film {
        return filmRepository.save(film)
    }

    fun update(id: Long, film: Film): Film {
        val existingFilm = filmRepository.findById(id).orElseThrow { RuntimeException("Film not found") }
        existingFilm.title = film.title
        existingFilm.director = film.director
        existingFilm.duration = film.duration

        return filmRepository.save(existingFilm)
    }

    fun delete(id: Long) {
        if (filmRepository.existsById(id)) {
            filmRepository.deleteById(id)
        } else {
            throw RuntimeException("Film not found")
        }
    }
}
