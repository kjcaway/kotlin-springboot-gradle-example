package com.example.demo.api.member.repository

import org.apache.ibatis.annotations.Mapper
import org.springframework.stereotype.Repository

@Repository
@Mapper
interface MemberSqlMapper {
    fun selectMemberCnt() : Int
}