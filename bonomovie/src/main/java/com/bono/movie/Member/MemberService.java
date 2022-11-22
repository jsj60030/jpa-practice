package com.bono.movie.Member;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MemberService {

	private final MemberRepository memberRepository;

	public MemberService(MemberRepository memberRepository) {

		this.memberRepository = memberRepository;
	}

	// 회원가입
	public Member memberJoin(@RequestBody MemberInfo request) {

		Member member = new Member();

		member.setMemId(request.getMemId());
		member.setMemPw(request.getMemPw());
		member.setMemName(request.getMemName());
		member.setMemGender(request.getMemGender());
		member.setMemBirthday(request.getMemBirthday());
		member.setMemMobile(request.getMemMobile());
		member.setMemEmail(request.getMemEmail());
		member.setMemPoint(request.getMemPoint());
		member.setMemMoney(request.getMemMoney());
		member.setMemAdmin(MemberAdmin.USER);
		member.setMemState(MemberState.NORMAL);
		member.setMemJoindate(null);
		member.setMemSysdate(null);

		// DB에 저장
		member = memberRepository.save(member);

		return member;
	}

	// admin 변경
	public Member updateAdmin(@RequestParam Long memNum) {
		log.info("/updateAdmin, ud : {}", memNum);

		Member member = memberRepository.findById(memNum)
				.orElseThrow(() -> new IllegalArgumentException("No Member"));

		member.setMemAdmin(MemberAdmin.ADMIN);

		log.info(member.toString());

		return member;

	}

	// 회원리스트
	public List<Member> getMemberListAll() {
		log.info("getMemberListAll");
		List<Member> memberList = memberRepository.findAll();

		log.info(memberList.toString());

		return memberList;
	}

	// 회원 삭제
	public Member deleteMember(@RequestParam Long memberNum) {
		log.info("/deleteMember, ud : {}", memberNum);

		Member member = memberRepository.findById(memberNum)
				.orElseThrow(() -> new IllegalArgumentException("No Member"));

		member.setMemState(MemberState.DELETED);

		log.info(member.toString());

		return member;

	}

	// memberId로 회원 검색
	public Member findMemberId(@RequestParam String memId) {

		Optional<Member> member = Optional.of(memberRepository.findByMemberId(memId));

		return member.orElseThrow(() -> new IllegalArgumentException("No Member"));
	}

	// memberNum으로 회원 검색
	public Member findMemByMemberNum(@RequestParam Long memNum) {

		Member member = memberRepository.findById(memNum)
				.orElseThrow(() -> new IllegalArgumentException("No Member"));

		return member;
	}

	// memberName으로 회원 검색
	public List<Member> findMemByMemberName(@RequestParam String memName) {

		List<Member> member = Optional.of(memberRepository.findByMemberName(memName))
				.orElseThrow(() -> new IllegalArgumentException("No Member"));

		return member;
	}

	// 로그인
	public boolean memberLogin(Member member) {

		Member findMember = memberRepository.findByMemberId(member.getMemId());

		if (findMember == null) {
			return false;
		}

		if (!findMember.getMemPw().equals(member.getMemPw())) {
			return false;
		}
		return true;
	}
}
