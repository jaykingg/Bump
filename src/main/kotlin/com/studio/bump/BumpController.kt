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
class BumpController(
    val bumpService: BumpService
) {

    @Operation(description = "Bump List 가져오기")
    @GetMapping("/list")
    fun getBumpList(): BumpListView {
        val dummyLocationData = bumpService.dummyLocationData()
        return BumpListView(
            listOf(
                Bump(
                    accountId = "test1",
                    username = "테스트 유저이름1",
                    location = Location(
                        dummyLocationData[0].first,
                        dummyLocationData[0].second
                    ),
                    gender = Gender.FEMALE
                ),
                Bump(
                    accountId = "test2",
                    username = "테스트 유저이름2",
                    location = Location(
                        dummyLocationData[1].first,
                        dummyLocationData[1].second
                    ),
                    gender = Gender.MALE
                ),
                Bump(
                    accountId = "test3",
                    username = "테스트 유저이름3",
                    location = Location(
                        dummyLocationData[2].first,
                        dummyLocationData[2].second
                    ),
                    gender = Gender.FEMALE
                ),
                Bump(
                    accountId = "test4",
                    username = "테스트 유저이름4",
                    location = Location(
                        dummyLocationData[3].first,
                        dummyLocationData[3].second
                    ),
                    gender = Gender.FEMALE
                ),
                Bump(
                    accountId = "test5",
                    username = "테스트 유저이름5",
                    location = Location(
                        dummyLocationData[4].first,
                        dummyLocationData[4].second
                    ),
                    gender = Gender.MALE
                ),
                Bump(
                    accountId = "test5",
                    username = "테스트 유저이름",
                    location = Location(
                        dummyLocationData[5].first,
                        dummyLocationData[5].second
                    ),
                    gender = Gender.MALE
                )
            )
        )
    }
}