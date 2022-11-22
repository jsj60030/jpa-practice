package com.bono.movie.Member;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member,Long> {
	
	//아이디로 검색
	Member findByMemberId(String memId);
	
	//이름으로 검색(이름은 동명이인 있는 경우가 있으므로 List)
	List<Member> findByMemberName(String memName);
}
