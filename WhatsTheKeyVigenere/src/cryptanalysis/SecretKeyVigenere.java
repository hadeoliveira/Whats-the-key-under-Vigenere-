package cryptanalysis;

import java.util.ArrayList;
import java.util.List;

public class SecretKeyVigenere {
	
	private static final int BEGIN = 32;
	private static final int END = 127; 
	private static final int ALPHABET = END - BEGIN;
	
	private String key;
	

	public void processSecret(String secret, String text, int keySize) {
		List<String> groupInParts = splitMessage(secret, keySize); 
		String charMoreFrequents = "";
		
		for(int i = 0; i < keySize; i++) {
			List<FrequencyCounter> countLetters = 
					countFrequencyInParts(groupInParts, i);
			charMoreFrequents += 
					String.valueOf(searchMoreFrequents(countLetters));
		}
		
		String key = "";
		
		for(int i = 0; i < charMoreFrequents.length(); i++) {
			int character = charMoreFrequents.charAt(i) - BEGIN;
			key += (char)((character % ALPHABET) + BEGIN);
		}
		System.out.println("A chave eh: " + key);
		
	}
	
	private List<String> splitMessage(String text, int parts) {
		
		List<String> groupInParts = new ArrayList<>();
		int amount = text.length() / parts; 
		int count = 0;
		
		for(int i = 0; i < text.length() - parts; i = i + parts) {
			String newstring = text.substring(i, i+parts);
			count++;
			groupInParts.add(newstring);
		}
		
		return groupInParts;
	}
	
	private List<FrequencyCounter> countFrequencyInParts
								(List<String> groupString, int pos) {
		
		List<FrequencyCounter> counter = new ArrayList<>(); 
		
		for (String text : groupString) {
			FrequencyCounter freq = new FrequencyCounter();
			freq.setCharacter(text.charAt(pos));
			
			if(counter.contains(freq)) {
				int index = counter.indexOf(freq);
				counter.get(index).setFreq(counter.get(index).getFreq() + 1);
			} else {
				freq.setFreq(1);
				counter.add(freq);
			}
		}
		
		return counter;
	}
	
	private char searchMoreFrequents(List<FrequencyCounter> countLetters) {
		
		int highFrequency = 0;
		char character = 'a';
		
		for(FrequencyCounter counter : countLetters) {
			if(counter.getFreq() > highFrequency) {
				character = counter.getCharacter();
				highFrequency = counter.getFreq();
			}
		}
		return character;
	}
	
}
