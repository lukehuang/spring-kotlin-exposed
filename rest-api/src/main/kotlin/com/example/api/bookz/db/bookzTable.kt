package com.example.api.bookz.db

import com.example.util.exposed.instant
import com.example.util.exposed.jsonb
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.jetbrains.exposed.sql.Table
import java.time.Instant
import java.util.*

object BookzTable : Table("bookz") {
    val id = uuid("id").primaryKey()
    val createdAt = instant("created_at")
    val modifiedAt = instant("updated_at")
    val data = jsonb("data", BookzData::class.java, jacksonObjectMapper())
}

data class BookzRecord(
        val id: UUID, val createdAt: Instant, val modifiedAt: Instant,
        val data: BookzData
)

data class BookzData(val title: String, val genres: List<String>, val published: Boolean)