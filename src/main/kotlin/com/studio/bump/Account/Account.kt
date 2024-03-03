package com.studio.bump.Account

import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import org.springframework.data.annotation.CreatedDate
import java.net.URL
import java.time.Instant

@Entity
@Table(name = "account")
data class Account(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(unique = true)
    val accountId: String,

    val nickname: String = "임시 아이디",

    @NotNull
    var password: String,

    @NotNull
    val scope: Scope,

    @NotNull
    val username: String,

    val instagramPictureURL: URL?,

    @NotNull
    val gender: Gender,

    @CreatedDate
    val createAt: Instant? = Instant.now()

)