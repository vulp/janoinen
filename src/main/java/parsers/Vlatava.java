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
 * Date: 1/10/13
 * Time: 7:26 PM
 * To change this template use File | Settings | File Templates.
 */
public class Vlatava {
    private Document doc;
    private List<Beer> beerList;

    public List<Beer> parsePage() {
        try {
            beerList = new ArrayList<Beer>();
            doc = Jsoup.connect("http://www.vltava.fi/juomalista.html").get();
            Elements elements = doc.select("table.contenttable tr");

            for(Element element : elements) {

                if(element.html().contains("MUUT - OTHERS")) {
                    break;
                }
                if(!element.text().contains("OLUET") &&
                        !element.text().contains("VLTAVA HOUSE BRAND") &&
                        !element.text().contains("DRAFT Beers")&&
                        !element.text().contains("Muut") ) {
                       System.out.println("test " +element.text());

                }

            }
        } catch (Exception e) {
            System.out.println("error " +e );
        }
        return beerList;
    }
}
