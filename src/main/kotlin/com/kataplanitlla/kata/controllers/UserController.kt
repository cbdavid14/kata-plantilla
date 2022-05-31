package com.kataplanitlla.kata.controllers

import com.kataplanitlla.kata.models.User
import com.kataplanitlla.kata.services.UserService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cache.annotation.Cacheable
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.time.Instant
import java.util.*

@RestController()
@RequestMapping("/user")
class UserController {

    @Autowired private lateinit var userService: UserService

    @Autowired private val stringRedisTemplate: StringRedisTemplate? = null

    private val logger = LoggerFactory.getLogger(javaClass)

    @GetMapping("/mongodb")
    fun getUserMongoDB(): ResponseEntity<List<User>> {
        val users = userService.getUserMongoDB()

        return ResponseEntity(users, HttpStatus.OK)
    }

    @GetMapping("/postgres")
    fun getUserPostgres(): ResponseEntity<List<User>> {
        val users = userService.getUserPostgres()

        return ResponseEntity(users, HttpStatus.OK)
    }

    @GetMapping("/redis")
    fun doTest(): String? {
        val _key = "time"
        stringRedisTemplate?.opsForValue()
            ?.set(_key, java.lang.String.valueOf(Instant.now().epochSecond))
        return stringRedisTemplate?.opsForValue()?.get(_key)
    }

    @GetMapping("/redisDeclarative")
    @Cacheable(value = ["cache_redis"])
    fun cacheDeclarative(): String {
        logger.info("set cache")
        return "cache + ${Instant.now().epochSecond}"
    }

    @GetMapping("/testUnit5/{name}")
    fun getTestUnit5(
        @PathVariable(name = "name") name: String,
        @RequestParam(name = "age") age: Int
    ): ResponseEntity<String> {

        return ResponseEntity("Hello World $name, by $age", HttpStatus.OK)
    }
}
