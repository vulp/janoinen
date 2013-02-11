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
 * Date: 1/10/13
 * Time: 6:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class Teereenpeli {
    private Document doc;
    private List<Beer> beerList;
    private static final Logger logger = Logger.getLogger(Teereenpeli.class);
    public List<Beer> parsePage() {
        try {
            beerList = new ArrayList<Beer>();
            doc = Jsoup.connect("http://www.teerenpeli.com/panimo/tuotteet/").get();
            Elements elements = doc.select("div.maincontent_area tr td ");
            int i = 0;
            String nimi = "";
            double percent = 0;
            String desc = "";
            for(Element element : elements) {
                if(element.text().length() > 1) {
                    if(i == 0) {
                        nimi = element.text();
                        i++;
                    } else if(i == 1) {
                        percent = Double.parseDouble(element.text().replaceAll("\u00A0","").trim().replace(",","."));
                        i++;
                    } else if(i == 2){
                        desc = element.text();
                        beerList.add(new Beer(nimi,-1,percent,desc));
                        i = 0;
                    }
                }
            }
        } catch (Exception e) {
            logger.error("Teereenpeli error: " +e);
        }
        return beerList;
    }
}
