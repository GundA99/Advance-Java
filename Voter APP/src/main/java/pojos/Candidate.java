package pojos;

public class Candidate {
//	| id | name    | party    | votes |
	
	private int id;
	private String party;
	private String name;
	private int votes;
	
	
	public Candidate(int id, String party, String name, int votes) {
		super();
		this.id = id;
		this.party = party;
		this.name = name;
		this.votes = votes;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getParty() {
		return party;
	}


	public void setParty(String party) {
		this.party = party;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getVotes() {
		return votes;
	}


	public void setVotes(int votes) {
		this.votes = votes;
	}


	@Override
	public String toString() {
		return "Candidate [id=" + id + ", party=" + party + ", name=" + name + ", votes=" + votes + "]";
	}
	
	
	
	
	
}
