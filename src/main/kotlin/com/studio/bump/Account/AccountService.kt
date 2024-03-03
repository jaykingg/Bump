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
    fun save(payload: AccountCreatePayload) {
        val encodedPassword = passwordEncoder.encode(payload.password)
        accountRepository.save(
            Account(
                accountId = payload.accountId,
                password = encodedPassword,
                scope = payload.scope,
                username = payload.username,
                instagramPictureURL = payload.instagramPictureURL,
                gender = payload.gender
            )
        )
    }

    fun getAccountToken(payload: AccountTokenPayload): String {
        authenticationManager.authenticate(
            UsernamePasswordAuthenticationToken(payload.accountId, payload.password)
        )
        return jwtUtil.generateToken(payload.accountId)
    }


}