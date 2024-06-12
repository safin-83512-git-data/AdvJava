package com.sunbeam.beans;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.pojos.Candidate;

public class FindCandidateBean {
	private int candId;
	private Candidate candidate;
	
	public FindCandidateBean() {
	}

	public int getCandId() {
		return candId;
	}

	public void setCandId(int candId) {
		this.candId = candId;
	}
	
	public Candidate getCandidate() {
		return candidate;
	}
	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}
	
	
	
	public void fetchCandidate() {
		
		try(CandidateDao candDao=new CandidateDaoImpl()){
			this.candidate = candDao.findById(this.candId);
			System.out.println("Candidate ***"+this.candidate);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	
}
