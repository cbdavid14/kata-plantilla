package com.kataplanitlla.kata.configuration

import com.mongodb.ConnectionString
import com.mongodb.MongoClientSettings
import com.mongodb.client.MongoClient
import com.mongodb.client.MongoClients
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration

@Configuration
class MongodbConfiguration : AbstractMongoClientConfiguration() {

    override fun getDatabaseName(): String {
        return "admin"
    }

    override fun mongoClient(): MongoClient {
        val connectionString = ConnectionString("mongodb://root:pass@localhost:2717/admin")
        val mongoClientSettings = MongoClientSettings.builder()
            .applyConnectionString(connectionString)
            .build()
        return MongoClients.create(mongoClientSettings)
    }

    public override fun getMappingBasePackages(): Collection<String> {
        return setOf("com.kata")
    }
}
