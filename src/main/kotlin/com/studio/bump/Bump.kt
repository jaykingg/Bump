package com.studio.bump

import com.studio.account.Gender
import java.net.URL

data class Bump(
    val accountId: String,
    val username: String,
    val location: Location,
    val instagramURL: URL? = null,
    val gender: Gender
)