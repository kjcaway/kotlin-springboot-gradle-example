package com.example.demo.api.member.service

import com.example.demo.api.member.domain.Member

interface MemberService {
    fun getMember(id: String): Member
    fun setMember(member: Member)
    fun getMemberList(type: String?): MutableList<Member>?
    fun getMemberCnt() : Int
}