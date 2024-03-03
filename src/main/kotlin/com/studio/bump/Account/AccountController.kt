package com.studio.bump.Account

import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/account")
class AccountController(
    private val accountService: AccountService,
) {
    @PostMapping("/register")
    fun registerAccount(
        @RequestBody
        accountCreatePayload: AccountCreatePayload
    ): ResponseEntity<String> {
        accountService.save(accountCreatePayload)
        return ResponseEntity.ok("ok")
    }

    @PostMapping("/token")
    fun getAccountToken(
        @Valid @RequestBody
        accountTokenPayload: AccountTokenPayload
    ): ResponseEntity<AccountTokenView> {
        val token = accountService.getAccountToken(accountTokenPayload)
        return ResponseEntity.ok(
            AccountTokenView(
                token = token
            )
        )
    }
}