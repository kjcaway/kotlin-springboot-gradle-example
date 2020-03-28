package com.example.demo.spring

import org.apache.ibatis.session.*
import org.apache.ibatis.type.JdbcType

class MyBatisConfig: Configuration() {
    init {
        super.cacheEnabled = false
        super.lazyLoadingEnabled = true
        super.multipleResultSetsEnabled = true
        super.useColumnLabel = true
        super.autoMappingBehavior = AutoMappingBehavior.FULL
        super.autoMappingUnknownColumnBehavior = AutoMappingUnknownColumnBehavior.NONE
        super.defaultExecutorType = ExecutorType.SIMPLE
        super.useGeneratedKeys = false
        super.safeRowBoundsEnabled = false
        super.mapUnderscoreToCamelCase = true
        super.localCacheScope = LocalCacheScope.SESSION
        super.jdbcTypeForNull = JdbcType.VARCHAR
    }
}