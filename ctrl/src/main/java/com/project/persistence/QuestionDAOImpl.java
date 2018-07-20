package com.project.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import com.project.domain.QuestionVO;
import com.project.domain.Criteria;
import com.project.domain.SearchCriteria;

@Repository
public class QuestionDAOImpl implements QuestionDAO {
	
	@Inject
	private SqlSession session;
	
	private static String namespace = "com.project.mapper.QuestionMapper";
	@Override
	public void create(QuestionVO qvo) throws Exception {
		session.insert(namespace+".create",qvo);
		
	}
	
	@Override
	public void create2(QuestionVO qvo) throws Exception {
		session.insert(namespace+".create2",qvo);
		
	}
	
	
	@Override
	public QuestionVO read(Integer bno) throws Exception {
		return session.selectOne(namespace+".read", bno);
	}
	
	@Override
	public QuestionVO read2(QuestionVO qvo) throws Exception {
		return session.selectOne(namespace+".read2", qvo);
	}
	
	@Override
	public void update(QuestionVO qvo) throws Exception {
		session.update(namespace+".update", qvo);
		
	}
	@Override
	public void delete(Integer bno) throws Exception {
		session.delete(namespace+".delete", bno);
		
	}
	@Override
	public List<QuestionVO> listAll() throws Exception {
		return session.selectList(namespace + ".listAll");
	}
	
	@Override
	public List<QuestionVO> listPage(int page) throws Exception {
		if (page <= 0) {
			page = 1;
		}
		page = (page - 1) * 10;
		return session.selectList(namespace + ".listPage", page);
	}
	
	@Override
	public List<QuestionVO> listCriteria(Criteria cri) throws Exception {
		return session.selectList(namespace + ".listCriteria", cri);
	}
	@Override
	public int countPaging(Criteria cri) throws Exception {
		return session.selectOne(namespace + ".countPaging", cri);
	}
	@Override
	public List<QuestionVO> listSearch(SearchCriteria cri) throws Exception {
		return session.selectList(namespace + ".listSearch", cri);
	}
	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		return session.selectOne(namespace + ".listSearchCount", cri);
	}
	@Override
	public void updateReplyCnt(Integer bno, int rcnt) throws Exception {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("bno", bno);
		paramMap.put("rcnt", rcnt);
		session.update(namespace + ".updateReplyCnt", paramMap);
		
	}
	@Override
	public void updateViewCnt(Integer bno) throws Exception {
		session.update(namespace + ".updateViewCnt", bno);
		
	}
	@Override
	public void addAttach(String fullname) throws Exception {
		session.insert(namespace + ".addAttach", fullname);
		
	}
	@Override
	public List<String> getAttach(Integer bno) throws Exception {
		return session.selectList(namespace + ".getAttach", bno);
	}
	@Override
	public void deleteAttach(Integer bno) throws Exception {
		session.delete(namespace + ".deleteAttach", bno);
		
	}
	@Override
	public void replaceAttach(String fullname, Integer bno) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();

		paramMap.put("bno", bno);
		paramMap.put("fullname", fullname);

		session.insert(namespace + ".replaceAttach", paramMap);
		
	}

	

	


}