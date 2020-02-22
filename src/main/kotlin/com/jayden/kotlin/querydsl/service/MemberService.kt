package com.jayden.kotlin.querydsl.service

import com.jayden.kotlin.querydsl.entity.Member
import com.jayden.kotlin.querydsl.repository.MemberRepository
import org.springframework.stereotype.Service
import java.lang.IllegalArgumentException

@Service
class MemberService(
        val memberRepository: MemberRepository
) {

    fun getMember(id: Long): Member {
        return memberRepository.findById(id)
                .orElseThrow { throw IllegalArgumentException("Not Found User") }
    }

    fun searchMember(email: String): List<Member> {
        return memberRepository.searchMember(email)
    }

}