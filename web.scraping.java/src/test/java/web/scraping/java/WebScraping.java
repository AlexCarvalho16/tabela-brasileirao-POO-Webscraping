package web.scraping.java;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class WebScraping {
	public List<Clube> getClubes() {
		
		
		
		List<Clube> clubes = new ArrayList<Clube>();
		
		try {
			
			String urlBrasileiraoCBF = "https://www.cbf.com.br/futebol-brasileiro"; // url do site da CBF
			
			Document documento = Jsoup.connect(urlBrasileiraoCBF).get();
			
			Elements nomeClubes = documento.select("span.hidden-xs");
			Elements pontos = documento.select("th[scope=row]");
			
			for (int i = 0; i < nomeClubes.size(); i++) {
				
				clubes.add(new Clube(nomeClubes.get(i).text(), Integer.valueOf(pontos.get(i).text())));
			}
			
			return clubes;
		}
		
		catch (IOException e) {
			e.printStackTrace();
			
			return clubes = null;
		}
	}
}
