package com.example.prueba.entity

import jakarta.persistence.*

@Entity
@Table(name = "characters")
data class Characters(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(updatable = false)
    var description: String? = null,

    var cost: Double? = null,

    var stock: Int? = null,

    @ManyToOne
    @JoinColumn(name = "scene_id", updatable = false)
    var scene: Scene? = null
)