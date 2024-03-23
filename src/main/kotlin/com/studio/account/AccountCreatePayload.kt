package com.studio.account

import jakarta.validation.constraints.NotBlank

data class AccountCreatePayload(
    @field: NotBlank
    val accountId: String,

    @field: NotBlank
    val username: String,

    @field: NotBlank
    val scope: Scope,

    @field: NotBlank
    val snsTokenToPassword: String
)