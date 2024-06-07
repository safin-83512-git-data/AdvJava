package com.sunbeam;

public class Main 



public class User {
    private int id;
    private String email;
    private String password;
    private boolean voted;
	public User(int id, String email, String password, boolean voted) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.voted = voted;
	}

    // Constructors, getters and setters
}

public class Candidate {
    private int id;
    private String name;
    private String party;
    private int votes;
	public Candidate(int id, String name, String party, int votes) {
		super();
		this.id = id;
		this.name = name;
		this.party = party;
		this.votes = votes;
	}

    // Constructors, getters and setters
}
