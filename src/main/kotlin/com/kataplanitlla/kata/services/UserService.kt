package com.kataplanitlla.kata.services

import com.kataplanitlla.kata.models.User
import com.kataplanitlla.kata.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class UserService {

    @Autowired private lateinit var userRepository: UserRepository

    fun getUserMongoDB(): List<User> {
        return userRepository.getUserMongoDB()
    }

    fun getUserPostgres(): List<User> {
        return userRepository.getUserPostgres()
    }
}
