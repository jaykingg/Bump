package com.studio.account

import java.net.URL

data class AccountModifyPayload(
    val username: String? = "임시 아이디",
    val instagramPictureURL: URL? = null,
    val gender: Gender? = null
)
