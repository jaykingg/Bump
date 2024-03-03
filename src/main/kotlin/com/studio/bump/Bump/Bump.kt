package com.studio.bump.Bump

import com.studio.bump.Account.Gender
import java.net.URL

data class Bump(
    val accountId: String,
    val username: String,
    val instagramURL: URL? = null,
    val gender: Gender
)