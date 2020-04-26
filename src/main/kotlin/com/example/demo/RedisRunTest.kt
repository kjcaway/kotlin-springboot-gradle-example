package com.example.demo

import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.stereotype.Component

@Component
class RedisRunTest(
        val stringRedisTemplate : StringRedisTemplate
) : ApplicationRunner  {
    override fun run(args: ApplicationArguments?) {
        var value = stringRedisTemplate.opsForValue()
        value.set("Hello", "World")
    }
}