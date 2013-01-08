package parsers;

import model.Beer;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: vulp
 * Date: 1/7/13
 * Time: 10:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class Kaisla {
    private Document doc;
    private List<Beer> beerList;

    public List<Beer> parsePage() {
        try {
            beerList = new ArrayList<Beer>();
            doc  = Jsoup.connect("http://www.oluthuone.fi/kaisla-juomalista.html").get();
            Elements elements = doc.select("div#c165 td");

            double percent;
            String nimi;
            for (Element element : elements) {
                System.out.println("test " +element.text());
                if(!element.text().equalsIgnoreCase("Hanaoluet") &&
                        !element.text().equalsIgnoreCase("Suomalaiset") &&
                        !element.text().equalsIgnoreCase("KUUKAUDEN HANAOLUT >") &&
                        !element.text().equalsIgnoreCase("VAIHTUVA PIENPANIMO-OLUT >") &&
                        !element.text().equalsIgnoreCase("Brittiläiset") &&
                        !element.text().equalsIgnoreCase("Belgialaiset") &&
                        !element.text().equalsIgnoreCase("Saksalaiset") &&
                        !element.text().equalsIgnoreCase("Muut Maat")
                ) {
                    try {
                        percent = Double.parseDouble(element.text().substring(element.text().indexOf(",")-2, element.text().length()-1).replaceAll(",","."));
                    } catch (Exception e) {
                        percent = -1;
                    }
                    if(percent != -1) {
                        nimi = element.text().substring(0,element.text().indexOf(",")-2);
                    } else {
                        //todo tarkista onko prossa ilman pilkkua
                       nimi = element.text();
                    }
                    beerList.add(new Beer(nimi, -1, percent,""));
                }
            }
        } catch (Exception e) {
            System.out.println("Error "+ e);
        }
        return beerList;
    }
}
