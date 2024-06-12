package com.example.prueba.repository

import com.example.prueba.entity.Scene
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SceneRepository: JpaRepository<Scene, Long?> {
}
