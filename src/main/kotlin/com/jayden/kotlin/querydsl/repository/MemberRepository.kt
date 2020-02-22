package com.jayden.kotlin.querydsl.repository

import com.jayden.kotlin.querydsl.entity.Member
import com.jayden.kotlin.querydsl.entity.QMember.member
import com.querydsl.core.types.dsl.BooleanExpression
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport

interface MemberRepository : JpaRepository<Member, Long>, CustomMemberRepository

interface CustomMemberRepository {
    fun searchMember(email: String): List<Member>
}

class CustomMemberRepositoryImpl : CustomMemberRepository, QuerydslRepositorySupport(Member::class.java) {

    override fun searchMember(email: String): List<Member> =
        from(member)
        .where(eqEmail(email))
        .fetch()

    private fun eqEmail(email: String): BooleanExpression? {
        return if (email == null) {
            null
        } else {
            member.email.eq(email)
        }
    }
}