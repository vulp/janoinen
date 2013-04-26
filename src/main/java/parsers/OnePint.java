package parsers;

import java.util.ArrayList;
import java.util.List;

import Beer.Beer;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/*
* @author Ville Valta
* Date: 7.1.2013
*
*/


public class OnePint {
    private Document doc;
    private List<Beer> beerList;
    private static final Logger logger = Logger.getLogger(OnePint.class);
    public List<Beer> parsePage() {
        try {
            beerList = new ArrayList<Beer>();
            doc = Jsoup.connect("http://www.onepintpub.com/?page_id=6").get();
            Elements elements = doc.select("div.entry-content p");
            for (Element element : elements) {
                if (element.text().trim().equalsIgnoreCase("Tulossa:")) break;

                String eT = element.ownText().trim();
                if (!eT.equals("") && eT.length() > 1) {
                    int prosenttimerkinKohta = eT.indexOf("%");
                    int alku = 0;
                    for (int i = prosenttimerkinKohta - 1; i >= alku; i--) {
                        if (!Character.isDigit(eT.charAt(i)) && eT.charAt(i) != ',' && eT.charAt(i) != ' ') {
                            alku = i;
                            break;
                        }
                    }
                    if (prosenttimerkinKohta >= alku +1) {
                            beerList.add(new Beer(eT.substring(0, alku + 1).trim(), -1,
                            Double.parseDouble(eT.substring(alku + 1, prosenttimerkinKohta).replace(',', '.')),
                            ""));
                    } else {}//do nothing, wrong beer
                }
            }
        } catch (Exception e) {
            logger.error("Onepint error: " +e);
        }
        return beerList;
    }

}
