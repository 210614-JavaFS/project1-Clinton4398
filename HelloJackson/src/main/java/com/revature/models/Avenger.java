package com.revature.models;

public class Avenger {
	
	private int superheroId;
	private String superheroName;
	private String superheroPower;
	private String firstName;
	private String lastName;
	private int powerLevel;
	private Home home;
	
	public Avenger(int superheroId, String superheroName, String superheroPower, String firstName, String lastName,
			int powerLevel, Home home) {
		super();
		this.superheroId = superheroId;
		this.superheroName = superheroName;
		this.superheroPower = superheroPower;
		this.firstName = firstName;
		this.lastName = lastName;
		this.powerLevel = powerLevel;
		this.home = home;
	}

	public Avenger() {
		super();
	}

	public int getSuperheroId() {
		return superheroId;
	}

	public void setSuperheroId(int superheroId) {
		this.superheroId = superheroId;
	}

	public String getSuperheroName() {
		return superheroName;
	}

	public void setSuperheroName(String superheroName) {
		this.superheroName = superheroName;
	}

	public String getSuperheroPower() {
		return superheroPower;
	}

	public void setSuperheroPower(String superheroPower) {
		this.superheroPower = superheroPower;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getPowerLevel() {
		return powerLevel;
	}

	public void setPowerLevel(int powerLevel) {
		this.powerLevel = powerLevel;
	}

	public Home getHome() {
		return home;
	}

	public void setHome(Home home) {
		this.home = home;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((home == null) ? 0 : home.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + powerLevel;
		result = prime * result + superheroId;
		result = prime * result + ((superheroName == null) ? 0 : superheroName.hashCode());
		result = prime * result + ((superheroPower == null) ? 0 : superheroPower.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Avenger other = (Avenger) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (home == null) {
			if (other.home != null)
				return false;
		} else if (!home.equals(other.home))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (powerLevel != other.powerLevel)
			return false;
		if (superheroId != other.superheroId)
			return false;
		if (superheroName == null) {
			if (other.superheroName != null)
				return false;
		} else if (!superheroName.equals(other.superheroName))
			return false;
		if (superheroPower == null) {
			if (other.superheroPower != null)
				return false;
		} else if (!superheroPower.equals(other.superheroPower))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Avenger [superheroId=" + superheroId + ", superheroName=" + superheroName + ", superheroPower="
				+ superheroPower + ", firstName=" + firstName + ", lastName=" + lastName + ", powerLevel=" + powerLevel
				+ ", home=" + home + "]";
	}
	
	

}
