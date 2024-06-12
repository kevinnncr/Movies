package com.example.prueba.service

import com.example.prueba.entity.Characters
import com.example.prueba.repository.CharactersRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CharactersService {
    @Autowired
    private lateinit var filmService: FilmService

    @Autowired
    lateinit var charactersRepository: CharactersRepository

    fun list(): List<Characters> {
        return charactersRepository.findAll()
    }

    fun getById(id: Long): Characters {
        return charactersRepository.findById(id).orElseThrow { RuntimeException("Character not found") }
    }

    fun save(characters: Characters): Characters {
        return charactersRepository.save(characters)
    }

    fun update(id: Long, characters: Characters): Characters {
        val existingCharacter = charactersRepository.findById(id).orElseThrow { RuntimeException("Character not found") }
        existingCharacter.description = characters.description
        existingCharacter.cost = characters.cost
        existingCharacter.stock = characters.stock
        existingCharacter.scene = characters.scene

        return charactersRepository.save(existingCharacter)
    }

    fun delete(id: Long) {
        if (charactersRepository.existsById(id)) {
            charactersRepository.deleteById(id)
        } else {
            throw RuntimeException("Character not found")
        }
    }

    fun compareTotalMinutesWithFilmDuration(filmId: Long): Boolean {
        val totalMinutes = charactersRepository.sumMinutesByFilmId(filmId) ?: 0
        val filmDuration = filmService.getById(filmId).duration ?: 0
        return totalMinutes <= filmDuration
    }
}
