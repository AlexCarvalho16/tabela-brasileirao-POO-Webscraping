package web.scraping.java;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class TabelaTeste {
	public static void main(String[] args) {
		
		try {
            System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8.name()));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
		
		System.out.println("Tabela Brasileirão série A");
		
		List<Clube> clubes = new WebScraping().getClubes();  
		
		for (Clube clube : clubes) {
			
			System.out.println((clubes.indexOf(clube) + 1 ) + "º " + clube.getNome() + " pontos: " + clube.getPontos());
		}
		
		System.out.println("\nFeito!");
	}
}
