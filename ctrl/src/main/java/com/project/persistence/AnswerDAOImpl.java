package com.project.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.project.domain.Criteria;
import com.project.domain.AnswerVO;


@Repository
public class AnswerDAOImpl implements AnswerDAO {
	
	@Inject
	private SqlSession session;

	private static String namespace = "com.project.mapper.AnswerMapper";

	@Override
	public List<AnswerVO> list(Integer bno) throws Exception {
		 return session.selectList(namespace + ".list", bno);
	}

	@Override
	public void create(AnswerVO rvo) throws Exception {
		  session.insert(namespace + ".create", rvo);
		
	}

	@Override
	public void update(AnswerVO rvo) throws Exception {
		session.update(namespace + ".update", rvo);
		
	}

	@Override
	public void delete(Integer rno) throws Exception {
		 session.update(namespace + ".delete", rno);
		
	}

	@Override
	public List<AnswerVO> listPage(Integer bno, Criteria cri) throws Exception {
		 Map<String, Object> paramMap = new HashMap<>();
		    paramMap.put("bno", bno);
		    paramMap.put("cri", cri);
		    return session.selectList(namespace + ".listPage", paramMap);
	}

	@Override
	public int count(Integer bno) throws Exception {
		  return session.selectOne(namespace + ".count", bno);
	}

	@Override
	public int getBno(Integer rno) throws Exception {
		  return session.selectOne(namespace + ".getBno", rno);
	}
	
	

}
