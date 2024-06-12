package com.sunbeam.beans;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;

public class DeleteCandidateBean {
	private int candId;
	private String message;
	public DeleteCandidateBean() {
	}
	public int getCandId() {
		return candId;
	}
	public void setCandId(int candId) {
		this.candId = candId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void deleteCandidate() {
		try(CandidateDao candDao = new CandidateDaoImpl()) {
			int count = candDao.deleteById(candId);
			this.message = "Candidates Deleted: " + count;
		} catch (Exception e) {
			e.printStackTrace();
			this.message = e.getMessage();
		}
	}
}
