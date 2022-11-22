/*
 * package com.bono.bonomovie;
 * 
 * import java.util.Optional;
 * 
 * import org.junit.Test; import org.junit.runner.RunWith; import
 * org.springframework.boot.test.context.SpringBootTest;
 * 
 * import com.bono.movie.Member.Member; import
 * com.bono.movie.Member.MemberAdmin;
 * 
 * import lombok.extern.java.Log;
 * 
 * @RunWith(SpringRunner.class)
 * 
 * @SpringBootTest
 * 
 * @Log public class MemberRepositoryTest {
 * 
 * @Autowired MemberRepository memberRepository;
 * 
 * @Test public void insertTest() { for(int i=0; i<100; i++) { Member member =
 * new Member(); member.setUid("user" + i); member.setUpw("pw" + i);
 * member.setUemail("hihi@" + i); MemberAdmin role = new MemberAdmin(); if(i <=
 * 80) { role.setRoleName("BASIC"); }else if(i <= 90) {
 * role.setRoleName("MANAGER"); }else { role.setRoleName("ADMIN"); }
 * member.setRoles(Arrays.asList(role)); memberRepository.save(member); } }
 * 
 * @Test public void testMember() { Optional<Member> result =
 * Optional.ofNullable(memberRepository.findOne(85L)); result.ifPresent(member
 * -> log.info("member " + member)); } }
 */