package com.project.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.project.domain.Criteria;
import com.project.domain.MemberVO;
import com.project.persistence.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Inject
	private MemberDAO mdao;
	
	@Override
	public void insertMember(MemberVO mvo) throws Exception {
		
		mdao.insertMember(mvo);
	}

	@Override
	public MemberVO getMember(String id) throws Exception {
		return mdao.getMember(id);
	}

	@Override
	public List<MemberVO> getMemberList(Criteria cri) throws Exception {
		
		return mdao.getMemberList(cri);
	}

	@Override
	public int checkMember(MemberVO mvo) throws Exception {
		return mdao.checkMember(mvo);
	}

	@Override
	public void deleteMember(String id) throws Exception {
		mdao.deleteMember(id);
	}

	@Override
	public int getTotal() throws Exception {
		
		return mdao.getTotal();
	}

	@Override
	public void stringToDate(MemberVO member) throws Exception {
		
			String year = member.getYear();
	        String month = member.getMonth();
	        String day = member.getDay();
	        
	        String birthday = String.valueOf(year+"-"+month+"-"+day);
	        MemberVO mvo = new MemberVO();
	        mvo.setBirthday(birthday);
	}

	@Override
	public String checkbirthday(String id) throws Exception {
		return mdao.checkbirthday(id);
	}

	@Override
	public void updateMember(MemberVO mvo) throws Exception {
		mdao.updateMember(mvo);

	}
}
