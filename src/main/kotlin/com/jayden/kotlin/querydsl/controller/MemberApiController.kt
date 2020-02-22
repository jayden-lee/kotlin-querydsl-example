package com.jayden.kotlin.querydsl.controller

import com.jayden.kotlin.querydsl.controller.dto.MemberDto
import com.jayden.kotlin.querydsl.service.MemberService
import org.springframework.http.HttpStatus.NOT_FOUND
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import kotlin.streams.toList

@RestController
@RequestMapping("/api/v1/members")
class MemberApiController(
    private val memberService: MemberService
) {

    @GetMapping("/{id}")
    fun getMember(@PathVariable id: Long): MemberDto {
        val member = memberService.getMember(id).orElseThrow {
            throw ResponseStatusException(NOT_FOUND, "This member does not exist")
        }

        return MemberDto(member)
    }

    @GetMapping
    fun searchMember(@RequestParam(required = false) teamName: String?): List<MemberDto> {
        return memberService.searchMember(teamName)
            .stream()
            .map { MemberDto(it) }
            .toList()
    }

}