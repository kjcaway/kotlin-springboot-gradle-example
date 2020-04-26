package com.example.demo.api.redistest.domain

import org.springframework.data.redis.core.RedisHash
import javax.persistence.Id

@RedisHash("member")
data class MemberRedis (
        @Id
        val id : String? = null,
        val name : String? = null,
        val email: String? = null,
        var age: Int? = null
)