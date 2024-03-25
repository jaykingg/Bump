package com.studio.account

import jakarta.validation.constraints.NotBlank

data class AccountTokenPayload(
    @field: NotBlank
    val accountId: String,

    @field: NotBlank
    val snsTokenToPassword: String
)