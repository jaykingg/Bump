package com.studio.bump.Account

import jakarta.validation.constraints.NotBlank
import java.net.URL

data class AccountCreatePayload(
    @field: NotBlank
    val accountId: String,

    @field: NotBlank
    val password: String,

    @field: NotBlank
    val scope: Scope,

    @field: NotBlank
    val username: String,

    val instagramPictureURL: URL?,

    @field: NotBlank
    val gender: Gender

)