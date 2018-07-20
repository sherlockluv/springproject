package com.project.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.project.domain.Criteria;
import com.project.domain.QuestionVO;
import com.project.domain.SearchCriteria;
import com.project.persistence.QuestionDAO;




@Service
public class QuestionServiceImpl implements QuestionService {
	@Inject
	private QuestionDAO qdao;

	@Transactional
	@Override
	public void regist(QuestionVO qvo) throws Exception {
		qdao.create(qvo);
		String[] files = qvo.getFiles();

		if (files != null) {
			for (String fileName : files) {
				qdao.addAttach(fileName);
			}
		}
	}

	@Transactional(isolation = Isolation.READ_COMMITTED)
	@Override
	public QuestionVO read(Integer bno) throws Exception {
		qdao.updateViewCnt(bno);
		
		return qdao.read(bno);
		
	}

	@Transactional
	@Override
	public void modify(QuestionVO qvo) throws Exception {
		qdao.update(qvo);

		Integer bno = qvo.getBno();

		qdao.deleteAttach(bno);

		String[] files = qvo.getFiles();

		if (files != null) {
			for (String fileName : files) {
				qdao.replaceAttach(fileName, bno);
			}
		}
	}

	@Transactional
	@Override
	public void remove(Integer bno) throws Exception {
		qdao.deleteAttach(bno);
		qdao.delete(bno);
	}

	@Override
	public List<QuestionVO> listAll() throws Exception {
		return qdao.listAll();
	}

	@Override
	public List<QuestionVO> listCriteria(Criteria cri) throws Exception {
		return qdao.listCriteria(cri);
	}

	@Override
	public int listCountCriteria(Criteria cri) throws Exception {
		return qdao.countPaging(cri);
	}

	@Override
	public List<QuestionVO> listSearchCriteria(SearchCriteria cri) throws Exception {
		return qdao.listSearch(cri);
	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		return qdao.listSearchCount(cri);
	}

	@Override
	public List<String> getAttach(Integer bno) throws Exception {
		return qdao.getAttach(bno);
	}



}