package com.sunbeam.beans;

import java.util.List;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.pojos.Candidate;

public class CandidateListBean {
	private List<Candidate> candList;
public CandidateListBean() {
}
public List<Candidate> getCandList() {
	return candList;
}
public void setCandList(List<Candidate> candList) {
	this.candList = candList;
}
public void fetchCandidateList() {
	try(CandidateDao candDao = new CandidateDaoImpl()) {
		candList = candDao.findAll();
		System.out.println(candList);
	}
	catch (Exception e) {
		e.printStackTrace();
		throw new RuntimeException(e);
	}
}

}
