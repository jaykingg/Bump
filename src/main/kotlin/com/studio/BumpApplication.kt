package com.studio

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BumpApplication

fun main(args: Array<String>) {
    runApplication<com.studio.BumpApplication>(*args)
}
