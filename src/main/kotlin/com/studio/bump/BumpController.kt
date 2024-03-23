package com.studio.bump

import com.studio.account.Gender
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/bump")
@Tag(name = "Bump", description = "Bump Service 관련 API")
class BumpController {

    @Operation(description = "Bump List 가져오기")
    @GetMapping("/list")
    fun getBumpList(): BumpListView {
        return BumpListView(
            listOf(
                Bump(
                    accountId = "test1",
                    username = "테스트 유저이름1",
                    gender = Gender.FEMALE
                ),
                Bump(
                    accountId = "test2",
                    username = "테스트 유저이름2",
                    gender = Gender.MALE
                ),
                Bump(
                    accountId = "test3",
                    username = "테스트 유저이름3",
                    gender = Gender.FEMALE
                ),
                Bump(
                    accountId = "test4",
                    username = "테스트 유저이름4",
                    gender = Gender.FEMALE
                ),
                Bump(
                    accountId = "test5",
                    username = "테스트 유저이름5",
                    gender = Gender.MALE
                ),
                Bump(
                    accountId = "test5",
                    username = "테스트 유저이름",
                    gender = Gender.MALE
                )
            )
        )
    }
}