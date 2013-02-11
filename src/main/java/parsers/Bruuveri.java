package parsers;

import Beer.Beer;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: vulp
 * Date: 1/9/13
 * Time: 8:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class Bruuveri {
    private Document doc;
    private List<Beer> beerList;
    private List<Beer> beerList2;
    private static final Logger logger = Logger.getLogger(Bruuveri.class);
    public List<Beer> parsePage() {
        try {
            beerList = new ArrayList<Beer>();
            beerList2 = new ArrayList<Beer>();
            doc = Jsoup.connect("http://bruuveri.fi/juomat/").get();
            Elements nimet = doc.select("div#beers-container div h4");
            Elements prossa = doc.select("div#beers-container div span");
            Elements desc = doc.select("div#beers-container div p");
            for (Element element : nimet) {
                beerList.add(new Beer(element.text(), -1, -1, ""));

            }
            int i = 0;
            for (Element element2 : prossa) {
                double percent = 0;
                String pross = element2.text().replace("%", " ").replace(",", ".").trim();
                percent = Double.parseDouble(pross.substring(pross.length() - 3, pross.length()));
                if(i < beerList.size()) {
                    beerList.get(i).setPercent(percent);
                }
                i++;
            }
            i = 0;
            for (Element element3 : desc) {
                if(i < beerList.size()) {
                    beerList.get(i).setDescription(element3.text());
                }
                i++;
            }
        } catch (Exception e) {
            logger.error("Bruuveri error: " +e);
        }
        return beerList;
    }
}
