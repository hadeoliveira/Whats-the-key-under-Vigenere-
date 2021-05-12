package cryptanalysis;

import java.util.Objects;

public class FrequencyCounter {
	private char character;
	private int freq;
	
	public char getCharacter() {
		return character;
	}
	public void setCharacter(char character) {
		this.character = character;
	}
	public int getFreq() {
		return freq;
	}
	public void setFreq(int freq) {
		this.freq = freq;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(obj == null || getClass() != obj.getClass()) return false;
		FrequencyCounter frequencyCharacter = (FrequencyCounter) obj;
		return this.character == frequencyCharacter.character;
	}
	
}
