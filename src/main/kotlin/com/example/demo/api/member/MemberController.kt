package com.example.demo.api.member

import com.example.demo.api.member.domain.Member
import com.example.demo.api.member.service.MemberService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/members")
class MemberController(
        val memberService: MemberService
) {
    @GetMapping()
    fun getMemberList(@RequestParam type: String?): ResponseEntity<*> {
        val users = memberService.getMemberList(type)

        return ResponseEntity.ok(users?: listOf(0))
    }

    @GetMapping("/{id}")
    fun getMember(@PathVariable id: String): ResponseEntity<*> {
        val users = memberService.getMember(id)

        return ResponseEntity.ok(users)
    }

    @PostMapping()
    fun setMember(@RequestBody member: Member): ResponseEntity<*> {
        val res = memberService.setMember(member)

        return ResponseEntity.ok(res)
    }

}