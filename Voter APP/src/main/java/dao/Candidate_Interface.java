package dao;

import java.sql.SQLException;
import java.util.List;

import pojos.Candidate;

public interface Candidate_Interface {

	List<Candidate> getAllCandidates() throws SQLException;
	String updateVote(int id) throws SQLException;
}
