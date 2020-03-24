package com.example.demo.api.base

import javax.persistence.EntityManager
import javax.persistence.criteria.CriteriaBuilder

open class BaseRepository(entityManager: EntityManager) {
    var entityManager: EntityManager = entityManager
    var criteriaBuilder: CriteriaBuilder? = null

    init {
        this.criteriaBuilder = entityManager.criteriaBuilder
    }
}