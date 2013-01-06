package parsers;

import model.Beer;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: vulp
 * Date: 1/6/13
 * Time: 6:42 PM
 * To change this template use File | Settings | File Templates.
 */
public class Lintu {

    private Document doc;

    private List<Beer> beerList;

    public List<Beer> parsePage() {
        try {
            beerList = new ArrayList<Beer>();
            doc  = Jsoup.connect("http://pikkulintu.fi/juomat/hanassa-nyt.html").get();
            Elements elements = doc.select("div#maincontent li span");
            for(Element element : elements) {
                String eT = element.text();
                String nimi = eT.substring(0,eT.indexOf("-")).trim()+", ";
                //todo laske viivat   Magners omenasiideri, 4,5%  (väärin)
                nimi += eT.substring(eT.lastIndexOf("-") + 1, eT.length()).trim();
                double percent = Double.parseDouble(eT.substring(eT.indexOf("-") + 1 , eT.indexOf("%")).trim().replace(",", ".").replaceAll("\u00A0",""));
                beerList.add(new Beer(nimi, -1, percent));
            }
        }catch (Exception e) {
            System.out.println("error " +e);
        }
        return beerList;
    }
}
