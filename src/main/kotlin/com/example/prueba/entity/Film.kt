package com.example.prueba.entity

import jakarta.persistence.*

@Entity
@Table(name = "film")
data class Film(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(updatable = false)
    var title: String? = null,

    var director: String? = null,

    var duration: Long? = null
)