package io.totem.aang

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AangApplication

fun main(args: Array<String>) {
    runApplication<AangApplication>(*args)
}
