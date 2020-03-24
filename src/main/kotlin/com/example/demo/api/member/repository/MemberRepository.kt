package com.example.demo.api.member.repository

import com.example.demo.api.base.BaseRepository
import com.example.demo.api.member.domain.Member
import org.springframework.stereotype.Repository
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
import javax.persistence.criteria.CriteriaQuery
import javax.persistence.criteria.Predicate
import javax.persistence.criteria.Root

@Repository
@PersistenceContext
class MemberRepository(entityManager: EntityManager): BaseRepository(entityManager) {
    fun getMember(id: String): Member {
        return entityManager.find(Member::class.java, id)
    }
    fun setMember(member: Member) {
        entityManager.merge((member))
    }

    fun setMemberList(type: String?): MutableList<Member>? {
        val criteriaBuilder = entityManager.criteriaBuilder
        val query: CriteriaQuery<Member> = criteriaBuilder!!.createQuery(Member::class.java)
        val root: Root<Member> = query.from(Member::class.java)
        val mainPredicates: MutableList<Predicate> = mutableListOf()

        if(type != null){
            mainPredicates.add(criteriaBuilder.equal(root.get<String>("type"), type))
        }

        query.select(root).where(
            criteriaBuilder.and(*mainPredicates.toTypedArray() as Array<out Predicate>)
        )

        val exeQuery = entityManager.createQuery(query)

        return exeQuery.resultList
    }
}