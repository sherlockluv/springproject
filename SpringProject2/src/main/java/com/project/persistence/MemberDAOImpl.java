package com.project.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.project.domain.Criteria;
import com.project.domain.MemberVO;
@Repository
public class MemberDAOImpl implements MemberDAO {
	private static final Logger logger = LoggerFactory.getLogger(MemberDAOImpl.class);

	@Inject
	private SqlSession session;
	
	private static String namespace="com.project.mapper.memberMapper";
	
	@Override
	public void insertMember(MemberVO mvo) throws Exception {
		 
		session.insert(namespace+".insert",mvo);
		
	}

	@Override
	public MemberVO getMember(String id) throws Exception {
		return session.selectOne(namespace + ".getMember", id);
	}

	@Override
	public List<MemberVO> getMemberList(Criteria cri) throws Exception {
		return session.selectList(namespace +".getMemberList", cri);
	}

	

	@Override
	public int checkMember(MemberVO mvo) throws Exception {
		return session.selectOne(namespace+".checkMember", mvo);
	}

	@Override
	public void deleteMember(String id) throws Exception {
		session.delete(namespace+".delete",id);

	}

	@Override
	public int getTotal() throws Exception {
		return session.selectOne(namespace+".getTotal");
	}

	@Override
	public String stringToDate(MemberVO member) throws Exception {
		return session.selectOne(namespace+".stringToDate",member);
	}

	@Override
	public String checkbirthday(String id) throws Exception {
		return session.selectOne(namespace+".checkbirthdate",id);
	}

	@Override
	public void updateMember(MemberVO mvo) throws Exception {
		session.update(namespace+".update",mvo);

	}
}
