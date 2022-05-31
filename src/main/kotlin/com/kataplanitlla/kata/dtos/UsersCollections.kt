package com.kataplanitlla.kata.dtos

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "user_collections")
data class UsersCollections(
    @Id
    var id: Long = 0,
    val name: String,
    val state: String
)
