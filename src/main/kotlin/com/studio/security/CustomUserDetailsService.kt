package com.studio.security

import com.studio.account.AccountRepository
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class CustomUserDetailsService(private val accountRepository: AccountRepository) :
    UserDetailsService {
    override fun loadUserByUsername(accountId: String): UserDetails {
        val user = accountRepository.findByAccountId(accountId)

        return User.withUsername(user.accountId)
            .password(user.snsTokenToPassword)
            .authorities(emptyList())
            .accountExpired(false)
            .accountLocked(false)
            .credentialsExpired(false)
            .disabled(false)
            .build()
    }
}