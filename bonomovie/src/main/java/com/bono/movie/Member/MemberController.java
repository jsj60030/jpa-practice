package com.bono.movie.Member;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class MemberController {

	private final MemberService memberService;

	public MemberController(MemberService memberSerivce) {
		this.memberService = memberSerivce;
	}

	@GetMapping(value = "/test")
	public String test(@RequestParam(value = "name", required = false) String name) {

		return "Hi " + name;
	}

	@GetMapping(value = "/main")
	public String main() {
		log.info("------------connect main---------------");
		return "Hello, World!";
	}

	/*
	 * 위에처럼 작성하는게 트랜드라고.. 그래서 이건 주석처리
	 * 
	 * @Autowired MemberService memberService;
	 * 
	 */

	// 회원가입 서비스 실행
	@PostMapping(value = "/memberJoin")
	public Member memberJoin(@RequestBody MemberInfo request) {

		return memberService.memberJoin(request);
	}

	// admin으로 변경
	@GetMapping(value = "/updateAdmin")
	@Transactional
	public Member updateAdmin(@RequestParam Long memberNum) {

		return memberService.updateAdmin(memberNum);
	}

	// 전체 회원목록 조회
	@GetMapping(value = "/memberListAll")
	public List<Member> getMemberListAll() {

		return memberService.getMemberListAll();
	}

	// 회원 삭제(상태변경)
	@GetMapping(value = "/deleteMember")
	@Transactional
	public Member deleteMember(@RequestParam Long memberNum) {

		return memberService.deleteMember(memberNum);
	}

	// 아이디로 회원조회
	@GetMapping(value = "/findMemByMemberId")
	@Transactional
	public Member findMemByMemberId(@RequestParam String memberId) {

		return memberService.findMemberId(memberId);
	}

	// 회원번호로 회원조회
	@GetMapping(value = "/findMemByMemberNum")
	@Transactional
	public Member findMemByMemberNum(@RequestParam Long memberNum) {

		return memberService.findMemByMemberNum(memberNum);
	}

	// 이름으로 회원조회
	@GetMapping(value = "/findMemByMemberName")
	@Transactional
	public List<Member> findMemByMemberName(@RequestParam String memberName) {

		return memberService.findMemByMemberName(memberName);
	}

	// 로그인
	@GetMapping(value = "/memberLogin")
	@Transactional
	public boolean memberLogin(Member member) {

		return memberService.memberLogin(member);
	}

}