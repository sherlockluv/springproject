package com.project.service;

import java.util.List;


import javax.inject.Inject;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.project.domain.Criteria;
import com.project.domain.SearchCriteria;
import com.project.domain.TeacherQ_VO;
import com.project.persistence.TeacherQ_DAO;



@Service
public class TeacherQ_ServiceImpl implements TeacherQ_Service {


	@Inject
	private TeacherQ_DAO tdao;
	
	@Transactional
	@Override
	public void regist(TeacherQ_VO tvo) throws Exception {
		tdao.create(tvo);
		String[] files = tvo.getFiles();

		if (files != null) {
			for (String fileName : files) {
				tdao.addAttach(fileName);
			}
		}
	}

	@Transactional(isolation = Isolation.READ_COMMITTED)
	@Override
	public TeacherQ_VO read(Integer qno) throws Exception {
		tdao.updateViewCnt(qno);
		return tdao.read(qno);
	}
	@Transactional
	@Override
	public void modify(TeacherQ_VO tvo) throws Exception {
		tdao.update(tvo);

		Integer qno = tvo.getQno();

		tdao.deleteAttach(qno);

		String[] files = tvo.getFiles();

		if (files != null) {
			for (String fileName : files) {
				tdao.replaceAttach(fileName, qno);
			}
		}

	}

	@Transactional
	@Override
	public void remove(Integer qno) throws Exception {
		tdao.deleteAttach(qno);
		tdao.delete(qno);

	}

	@Override
	public List<TeacherQ_VO> listAll() throws Exception {
		return tdao.listAll();
	}

	@Override
	public List<TeacherQ_VO> listCriteria(Criteria cri) throws Exception {
		return tdao.listCriteria(cri);
	}

	@Override
	public int listCountCriteria(Criteria cri) throws Exception {
		return tdao.countPaging(cri);
	}

	@Override
	public List<TeacherQ_VO> listSearchCriteria(SearchCriteria cri) throws Exception {
		return tdao.listSearch(cri);
	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		return tdao.listSearchCount(cri);
	}

	@Override
	public List<String> getAttach(Integer qno) throws Exception {
		return tdao.getAttach(qno);
	}
}
