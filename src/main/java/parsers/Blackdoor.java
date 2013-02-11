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
*
*/

public class Blackdoor {
    private Document doc;
    private List<Beer> beerList;
    private static final Logger logger = Logger.getLogger(Blackdoor.class);

    public List<Beer> parsePage() {
        try {
            beerList = new ArrayList<Beer>();
            doc = Jsoup.connect("http://www.delifox.fi/blackdoor/valikoima%3Fstart=1.html").userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.97 Safari/537.11").get();
            Elements elements = doc.select("div#content table.contentpaneopen").last().select("tbody tr td div:not(.pagenavcounter,.pagenavbar)");

            for (Element element : elements) {
                String eT = element.text().replace('\u00A0', ' ').trim();
                if (!eT.equals("")) {
                    if (eT.indexOf("Siideri") != -1 || eT.indexOf("siideri") != -1) break;
                    beerList.add(new Beer(eT, -1, -1, ""));
                }
            }

        } catch (Exception e) {
            logger.error("Blackdoor error: " +e);
        }
        return beerList;
    }
}
