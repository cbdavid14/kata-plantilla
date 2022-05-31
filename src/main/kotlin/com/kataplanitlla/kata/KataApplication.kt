package com.kataplanitlla.kata

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan("com.kataplanitlla.kata")
class KataApplication

fun main(args: Array<String>) {
    runApplication<KataApplication>(*args)
}
