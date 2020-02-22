package com.jayden.kotlin.querydsl.service

import com.jayden.kotlin.querydsl.entity.Member
import com.jayden.kotlin.querydsl.repository.MemberRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class MemberService(
    private val memberRepository: MemberRepository
) {

    fun getMember(id: Long): Optional<Member> {
        return memberRepository.findById(id)
    }

    fun searchMember(teamName: String?): List<Member> {
        return memberRepository.searchMember(teamName)
    }

}