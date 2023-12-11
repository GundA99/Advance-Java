package pojos;

import java.sql.Date;

public class player {

	private String fname,lname;
	private int wickets,teamId;
	private double batting_avg;
	private Date dob;
	
	public player(String fname, String lname, int wickets, int teamId, double batting_avg, Date dob) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.wickets = wickets;
		this.teamId = teamId;
		this.batting_avg = batting_avg;
		this.dob = dob;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public int getWickets() {
		return wickets;
	}

	public void setWickets(int wickets) {
		this.wickets = wickets;
	}

	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public double getBatting_avg() {
		return batting_avg;
	}

	public void setBatting_avg(double batting_avg) {
		this.batting_avg = batting_avg;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "player [fname=" + fname + ", lname=" + lname + ", wickets=" + wickets + ", teamId=" + teamId
				+ ", batting_avg=" + batting_avg + ", dob=" + dob + "]";
	}
	
	
	
	
}
