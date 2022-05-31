package com.kataplanitlla.kata.repositories

import com.kataplanitlla.kata.dtos.UsersCollections
import com.kataplanitlla.kata.models.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Component

@Component
class UserRepository {

    @Autowired private lateinit var mongoOperations: MongoOperations

    @Autowired private lateinit var userCollections: IUserCollectionsRepository

    @Autowired private lateinit var namedParameterJdbcTemplate: NamedParameterJdbcTemplate

    fun getUserMongoDB(): List<User> {
        saveUser()
        return userCollections.findAll().map {
            User(id = 0, name = it.name, state = it.state)
        }
    }

    fun saveUser() {
        mongoOperations.save(UsersCollections(name = "david", state = "active"))
    }

    fun getUserPostgres(): List<User> {

        return namedParameterJdbcTemplate.jdbcTemplate.query(
            "select * from user_kata",
            BeanPropertyRowMapper(User::class.java)
        )
    }
}
