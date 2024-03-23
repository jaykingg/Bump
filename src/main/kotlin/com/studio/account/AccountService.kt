package com.studio.account

import com.studio.security.JwtUtil
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import java.security.Principal

@Service
class AccountService(
    private val accountRepository: AccountRepository,
    private val authenticationManager: AuthenticationManager,
    private val jwtUtil: JwtUtil,
    private val passwordEncoder: BCryptPasswordEncoder
) {
    fun save(payload: AccountCreatePayload): Account {
        val encodedToken = passwordEncoder.encode(payload.snsTokenToPassword)
        return accountRepository.save(
            Account(
                accountId = payload.accountId,
                username = payload.username,
                snsTokenToPassword = encodedToken,
                scope = payload.scope
            )
        )
    }

    fun getAccount(principal: Principal): Account {
        return accountRepository.findByAccountId(principal.name)
    }

    fun modifyAccount(
        payload: AccountModifyPayload,
        principal: Principal
    ): Account {
        val account = accountRepository.findByAccountId(principal.name)
        return accountRepository.save(
            account.copy(
                username = payload.username,
                instagramPictureURL = payload.instagramPictureURL,
                gender = payload.gender
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