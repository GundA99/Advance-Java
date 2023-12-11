package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dao.*;
import pojos.Candidate;

import static utils.DBUtils.*;
import static utils.DBUtils.*
;public class Candidate_Dao implements Candidate_Interface {

	private Connection cn ;
	private PreparedStatement pst1,pst2;
	public Candidate_Dao() throws SQLException
	{
	
		cn = getConnection();
		pst1 = cn.prepareStatement("select *from candidates;");
		pst2 = cn.prepareStatement("update candidates set votes=votes+1 where id=?;");
		System.out.println("candidate dao created....");
		
		
	}
	@Override
	public List<Candidate> getAllCandidates() throws SQLException
	{
		List< Candidate> Clist = new ArrayList<>();
		
		try(ResultSet res = pst1.executeQuery())
		{
			while(res.next())
			{
				Clist.add(new Candidate(res.getInt(1), res.getString(2), res.getString(3), res.getInt(4)));
			}
		}
		return Clist;
	}
	@Override
	public String updateVote(int id) throws SQLException
	{
		pst2.setInt(1, id);
		int i = pst2.executeUpdate();
		if(i!=1)
		{
			return "Not updation failed !!";
		}
		return "Vote updated !!";
	}
	
}
