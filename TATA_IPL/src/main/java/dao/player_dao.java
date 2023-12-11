package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojos.player;

import static utils.DBUtils.*;

public class player_dao {

	private static Connection cn;
	private static PreparedStatement pst1, pst2,pst3;

	public player_dao() throws SQLException {

		cn = openConnection();
		pst1 = cn.prepareStatement("select abbrevation from teams;");
		pst2 = cn.prepareStatement("insert into players values(default,?,?,?,?,?,?);");
		pst3 = cn.prepareStatement("select team_id from teams where abbrevation=?;");
	}

	public static List<String> getAllAbbrevation() throws SQLException {

		List<String> alist = new ArrayList<String>();
		try (ResultSet res = pst1.executeQuery()) {
			while (res.next()) {
				alist.add(res.getString(1));
			}
		}
		return alist;

	}
	
	public static int getIdByAbbrevation(String abrivation) throws SQLException
	{
		pst3.setString(1, abrivation);
		try(ResultSet res = pst3.executeQuery())
		{
			int id=0;
			while(res.next())
			{
			 id = res.getInt(1);				
			}
			
			return id;
		}
		
	}

	public static String addplayer(player p1) throws SQLException {
		System.out.println(p1);
		pst2.setString(1, p1.getFname());
		pst2.setString(2, p1.getLname());
		pst2.setDate(3, p1.getDob());
//		pst2.setString(3, p1.getDob().toString());
		pst2.setDouble(4, p1.getBatting_avg());
		pst2.setInt(5, p1.getWickets());
		pst2.setInt(6, p1.getTeamId());
		System.out.println("in addplayer");
		int i = pst2.executeUpdate();
		System.out.println("in addplayer");
		if(i!=0)
		{
			return "<h3 style='background-color:cyan; color:red'>Player is Added....<h3><br><h2 style='background-color:pink; color:red'> Let's play...";
		}
		return "plyer is not Added....";
	}
}
