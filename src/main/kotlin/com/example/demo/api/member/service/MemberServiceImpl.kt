package com.example.demo.api.member.service

import com.example.demo.api.member.domain.Member
import com.example.demo.api.member.repository.MemberRepository
import com.example.demo.api.member.repository.MemberSqlMapper
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class MemberServiceImpl(
        val memberRepository: MemberRepository,
        val memberSqlMapper: MemberSqlMapper
) : MemberService {
    private val logger = LoggerFactory.getLogger(MemberServiceImpl::class.java)

    override fun getMember(id: String): Member {
        return memberRepository.getMember(id)
    }

    override fun setMember(member: Member) {
        try {
            memberRepository.setMember(member)
        } catch (e: Exception){
            logger.error(e.localizedMessage, e)
            throw e
        }
    }

    override fun getMemberList(type: String?): MutableList<Member>? {
        try {
            return memberRepository.setMemberList(type)
        } catch (e: Exception){
            logger.error(e.localizedMessage, e)
            throw e
        }
    }

    override fun getMemberCnt(): Int {
        return memberSqlMapper.selectMemberCnt()
    }
}