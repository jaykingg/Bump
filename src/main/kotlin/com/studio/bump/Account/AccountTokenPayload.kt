package com.studio.bump.Account

import jakarta.validation.constraints.NotBlank

data class AccountTokenPayload(
    @field: NotBlank
    val accountId: String,

    @field: NotBlank
    val password: String
)