package com.example.demo.api.redistest

import com.example.demo.api.redistest.domain.MemberRedis
import com.example.demo.api.redistest.repository.MemberRepositoryRedis
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/redis-test")
class RedisTestController (
        val memberRepositoryRedis: MemberRepositoryRedis
) {
    @GetMapping("/members")
    fun getMemberList(): ResponseEntity<Any> {
        val users = memberRepositoryRedis.findAll()

        val data = HashMap<String, Any>()
        data["userList"] = users
        return ResponseEntity.ok(data)
    }

    @PostMapping("/member")
    fun setMember(@RequestBody member: MemberRedis): ResponseEntity<Any> {
        memberRepositoryRedis.save(member)

        val data = HashMap<String, Any>()
        data["stats"] = "success"
        return ResponseEntity.ok(data)
    }
}