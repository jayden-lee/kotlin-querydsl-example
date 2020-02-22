package com.jayden.kotlin.querydsl

import com.jayden.kotlin.querydsl.entity.Member
import com.jayden.kotlin.querydsl.repository.MemberRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class QuerydslApplication {

	@Bean
	fun init(repository: MemberRepository) = CommandLineRunner {
		repository.save(Member(null, "jayden", "jayden@test.com"))
		repository.save(Member(null, "ella", "ella@test.com"))
		repository.save(Member(null, "kelly", "kelly@test.com"))
		repository.save(Member(null, "robb", "robb@test.com"))
		repository.save(Member(null, "issac", "issac@test.com"))
		repository.save(Member(null, "brant", "brant@test.com"))
		repository.save(Member(null, "andrew", "andrew@test.com"))
	}
}

fun main(args: Array<String>) {
	runApplication<QuerydslApplication>(*args)
}
