package com.studio.account

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.security.Principal

@RestController
@RequestMapping("/api/account")
@Tag(name = "계정", description = "계정 및 토큰 관련 API")
class AccountController(
    private val accountService: AccountService,
) {
    @Operation(description = "회원가입")
    @PostMapping("/register")
    fun registerAccount(
        @RequestBody
        payload: AccountCreatePayload
    ): ResponseEntity<String> {
        accountService.save(payload)
        return ResponseEntity.ok("ok")
    }

    @Operation(description = "회원정보 가져오기")
    @GetMapping
    fun getAccount(
        principal: Principal
    ): ResponseEntity<Account> {
        val account = accountService.getAccount(principal)
        return ResponseEntity.ok(account)
    }

    @Operation(description = "회원정보 수정")
    @PostMapping("/modify")
    fun modifyAccount(
        @RequestBody
        payload: AccountModifyPayload,
        principal: Principal
    ): ResponseEntity<Account> {
        val updateAccount = accountService.modifyAccount(payload, principal)
        return ResponseEntity.ok(updateAccount)
    }


    @Operation(description = "Jwt 생성 및 발급")
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