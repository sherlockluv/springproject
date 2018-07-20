package com.proejct.crtl;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.project.domain.MemberVO;
import com.project.persistence.MemberDAO;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
	locations ={"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class MemberDAO_Test {
	
	
	@Inject
	private MemberDAO bdao;
	private static Logger logger = LoggerFactory.getLogger(MemberDAO_Test.class);		
	@Test
	public void testInsert()throws Exception{		
		MemberVO bvo = new MemberVO();
	
		bvo.setId("b");
		bvo.setPtel("b");
		bvo.setPwd("a");
		bvo.setAddress("a");
		bvo.setBirthday("2018-08-08");
		bvo.setEmail("a");
		bvo.setName("a");
		bvo.setSchool("a");
		bvo.setTel("a");
		
		bdao.insertMember(bvo);
		
	}
		/*@Test
	public void testUpdate() throws Exception {
		MemberVO bvo = new MemberVO();
		
		bvo.setId("a");
		bvo.setPtel("010");
		bvo.setPwd("b");
		bvo.setAddress("b");
		bvo.setBirthday("2018-08-08");
		bvo.setEmail("b");
		bvo.setName("b");
		bvo.setSchool("b");
		bvo.setTel("b");
		
		bdao.updateMember(bvo);
	}
	
	@Test
	public void testDelete() throws Exception {
		MemberVO bvo = new MemberVO();
	
		bdao.deleteMember("a");
	}*/
	
	
}