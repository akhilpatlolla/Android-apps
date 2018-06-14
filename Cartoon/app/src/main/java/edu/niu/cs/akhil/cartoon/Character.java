package edu.niu.cs.akhil.cartoon;

/**
 * Created by akhil on 2/14/17.
 */

public class Character {
	private String characterDescription ;
	private int characterId;

	public Character(String characterDescription, int characterId) {
		this.characterDescription = characterDescription;
		this.characterId = characterId;
	}

	public String getCharacterDescription() {
		return characterDescription;
	}

	public void setCharacterDescription(String characterDescription) {
		this.characterDescription = characterDescription;
	}

	public int getCharacterId() {
		return characterId;
	}

	public void setCharacterId(int characterId) {
		this.characterId = characterId;
	}
}
