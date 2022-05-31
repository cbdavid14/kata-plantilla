package com.kataplanitlla.kata.repositories

import com.kataplanitlla.kata.dtos.UsersCollections
import org.springframework.data.mongodb.repository.MongoRepository

interface IUserCollectionsRepository : MongoRepository<UsersCollections, Long>
