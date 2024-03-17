package com.studio.bump.Account

import com.studio.bump.security.JwtUtil
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class AccountService(
    private val accountRepository: AccountRepository,
    private val authenticationManager: AuthenticationManager,
    private val jwtUtil: JwtUtil,
    private val passwordEncoder: BCryptPasswordEncoder
) {
    fun save(payload: AccountCreatePayload): Account {
        val encodedToken = passwordEncoder.encode(payload.token)
        return accountRepository.save(
            Account(
                accountId = payload.accountId,
                username = payload.username,
                tokenForPassword = encodedToken,
                scope = payload.scope
            )
        )
    }

    fun getAccountToken(payload: AccountTokenPayload): String {
        authenticationManager.authenticate(
            UsernamePasswordAuthenticationToken(payload.accountId, payload.tokenForPassword)
        )
        return jwtUtil.generateToken(payload.accountId)
    }


}