package com.sunbeam.beans;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.pojos.Candidate;

import java.util.List;

public class CandidateListBean {
    private List<Candidate> candidateList;

    public void setCandidateList(List<Candidate> candidateList) {
		this.candidateList = candidateList;
	}

	public List<Candidate> getCandidateList() {
        try (CandidateDao candidateDao = new CandidateDaoImpl()) {
            return candidateDao.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
