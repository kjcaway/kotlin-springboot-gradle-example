package com.example.demo.api.redistest.repository

import com.example.demo.api.redistest.domain.MemberRedis
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface MemberRepositoryRedis : CrudRepository<MemberRedis, String>