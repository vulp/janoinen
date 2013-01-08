package parsers;

import model.Beer;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: vulp
 * Date: 1/7/13
 * Time: 10:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class Penni {
    private Document doc;
    private List<Beer> beerList;

    public List<Beer> parsePage() {
        try {
            beerList = new ArrayList<Beer>();
            Set beerSet;
            doc = Jsoup.connect("http://oluttupa.viisipennia.fi/hanassa-nyt").get();
            Elements elements = doc.select("div#txt span");
            String parseHelp = "";
            String nimi = "";
            for (Element element : elements) {

                if (!element.text().equalsIgnoreCase("Hanassa Nyt") &&
                        !element.text().equalsIgnoreCase("&nbsp;") &&
                        element.text().trim().length() > 1) {
                    System.out.println("test " + element.text() + "  " + element.text().trim().length());
                    //nimi = element.text();
                    beerList.add(new Beer(element.text(), -1, -1, ""));
                }
            }
            //todo poista duplikaatit ja parsi tämän jälkeen prossat

        } catch (Exception e) {

        }
        return beerList;
    }

}
