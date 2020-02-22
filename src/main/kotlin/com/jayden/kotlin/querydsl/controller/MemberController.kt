package com.jayden.kotlin.querydsl.controller

import com.jayden.kotlin.querydsl.entity.Member
import com.jayden.kotlin.querydsl.service.MemberService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/members")
class MemberController(
        val memberService: MemberService
) {

    @GetMapping("/{id}")
    fun getMember(@PathVariable id: Long): Member {
        return memberService.getMember(id)
    }

    @GetMapping("/search")
    fun searchMember(@RequestParam email: String): List<Member> {
        return memberService.searchMember(email)
    }

}