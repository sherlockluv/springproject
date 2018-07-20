package com.project.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.project.domain.Criteria;
import com.project.domain.SearchCriteria;
import com.project.domain.TeacherQ_VO;

@Repository
public class TeacherQ_DAOImpl implements TeacherQ_DAO {
	private static final Logger logger = LoggerFactory.getLogger(TeacherQ_DAOImpl.class);

	@Inject
	private SqlSession session;
	
	private static String namespace = "com.project.mapper.TeacherMapper";
	
	@Override
	public void create(TeacherQ_VO tvo) throws Exception {
		session.insert(namespace+".create",tvo);

	}

	@Override
	public void create2(TeacherQ_VO tvo) throws Exception {
		session.insert(namespace+".create2",tvo);

	}

	@Override
	public TeacherQ_VO read(Integer qno) throws Exception {
		return session.selectOne(namespace+".read", qno);
	}

	@Override
	public TeacherQ_VO read2(Integer qno) throws Exception {
		return session.selectOne(namespace+".read2", qno);
	}

	@Override
	public void update(TeacherQ_VO tvo) throws Exception {
		session.update(namespace+".update", tvo);

	}

	@Override
	public void delete(Integer qno) throws Exception {
		session.delete(namespace+".delete", qno);

	}

	@Override
	public List<TeacherQ_VO> listAll() throws Exception {
		return session.selectList(namespace + ".listAll");
	}

	@Override
	public List<TeacherQ_VO> listPage(int page) throws Exception {
		if (page <= 0) {
			page = 1;
		}
		page = (page - 1) * 10;
		return session.selectList(namespace + ".listPage", page);
	}

	@Override
	public List<TeacherQ_VO> listCriteria(Criteria cri) throws Exception {
		return session.selectList(namespace + ".listCriteria", cri);
	}

	@Override
	public int countPaging(Criteria cri) throws Exception {
		return session.selectOne(namespace + ".countPaging", cri);
	}

	@Override
	public List<TeacherQ_VO> listSearch(SearchCriteria cri) throws Exception {
		return session.selectList(namespace + ".listSearch", cri);
	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		return session.selectOne(namespace + ".listSearchCount", cri);
	}

	@Override
	public void updateReplyCnt(Integer qno, int rcnt) throws Exception {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("qno", qno);
		paramMap.put("rcnt", rcnt);
		session.update(namespace + ".updateReplyCnt", paramMap);
	}

	@Override
	public void updateViewCnt(Integer qno) throws Exception {
		session.update(namespace + ".updateViewCnt", qno);

	}

	@Override
	public void addAttach(String fullname) throws Exception {
		session.insert(namespace + ".addAttach", fullname);

	}

	@Override
	public List<String> getAttach(Integer qno) throws Exception {
		return session.selectList(namespace + ".getAttach", qno);
	}

	@Override
	public void deleteAttach(Integer qno) throws Exception {
		session.delete(namespace + ".deleteAttach", qno);

	}

	@Override
	public void replaceAttach(String fullname, Integer qno) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();

		paramMap.put("qno", qno);
		paramMap.put("fullname", fullname);

		session.insert(namespace + ".replaceAttach", paramMap);

	}
}
