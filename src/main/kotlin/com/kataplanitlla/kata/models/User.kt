package com.kataplanitlla.kata.models

import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming
import java.io.Serializable

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
data class User(
    var id: Int = 0,
    var name: String = "",
    var state: String = ""
) : Serializable
