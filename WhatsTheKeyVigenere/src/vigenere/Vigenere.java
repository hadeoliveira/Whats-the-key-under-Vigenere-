package vigenere;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import cryptanalysis.SecretKeyVigenere;

public class Vigenere {

	private static final Scanner scan = new Scanner(System.in);
	private static final String text = "texto.txt";
	private static final String filename04 = "texto_cripto_chave04.txt";
	private static final String filename20 = "texto_cripto_chave20.txt";
	
	public static void main(String[] args) throws IOException {
			
		
//		Definitions all secrets and text
		BufferedReader inFile04 = new BufferedReader
					(new InputStreamReader(new FileInputStream(filename04)));	
		String secret04 = inFile04.readLine();
		
		BufferedReader inFile20 = new BufferedReader
				(new InputStreamReader(new FileInputStream(filename20)));	
		String secret20 = inFile20.readLine();
		
		BufferedReader inText = new BufferedReader
				(new InputStreamReader(new FileInputStream(text)));	
		String text = inText.readLine();
		
		SecretKeyVigenere processingSecret04 = 
				new SecretKeyVigenere();
		SecretKeyVigenere processingSecret20 = 
				new SecretKeyVigenere();
		
		processingSecret04.processSecret(secret04, text, 4);
		processingSecret20.processSecret(secret20, text, 20);
		
	}
	
}
