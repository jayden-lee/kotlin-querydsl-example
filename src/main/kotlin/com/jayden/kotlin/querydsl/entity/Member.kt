package com.jayden.kotlin.querydsl.entity

import javax.persistence.*

@Entity(name = "members")
@Table(name = "members")
class Member(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null,

        @Column
        var name: String? = "",

        @Column
        var email: String? = ""
)