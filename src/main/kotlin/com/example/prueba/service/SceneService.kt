package com.example.prueba.service

import com.example.prueba.entity.Scene
import com.example.prueba.repository.SceneRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class SceneService {
    @Autowired
    lateinit var sceneRepository: SceneRepository

    fun list(): List<Scene> {
        return sceneRepository.findAll()
    }

    fun getById(id: Long): Scene {
        return sceneRepository.findById(id).orElseThrow { RuntimeException("Scene not found") }
    }

    fun save(scene: Scene): Scene {
        return sceneRepository.save(scene)
    }

    fun update(id: Long, scene: Scene): Scene {
        val existingScene = sceneRepository.findById(id).orElseThrow { RuntimeException("Scene not found") }
        existingScene.description = scene.description
        existingScene.budget = scene.budget
        existingScene.minutes = scene.minutes
        existingScene.film = scene.film

        return sceneRepository.save(existingScene)
    }

    fun delete(id: Long) {
        if (sceneRepository.existsById(id)) {
            sceneRepository.deleteById(id)
        } else {
            throw RuntimeException("Scene not found")
        }
    }

    fun compareTotalMinutesWithFilmDuration(scenes: List<Scene>): Boolean {
        val totalMinutes = scenes.sumBy { it.minutes ?: 0 }
        val filmDuration = scenes.firstOrNull()?.film?.duration ?: 0
        return totalMinutes <= filmDuration
    }
}
