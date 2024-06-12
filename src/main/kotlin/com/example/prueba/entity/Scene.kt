package com.example.prueba.entity

import jakarta.persistence.*

@Entity
@Table(name = "scene")
data class Scene(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(updatable = false)
    var description: String? = null,

    var budget: Double? = null,

    var minutes: Int? = null,

    @ManyToOne
    @JoinColumn(name = "film_id", updatable = false)
    var film: Film? = null
)