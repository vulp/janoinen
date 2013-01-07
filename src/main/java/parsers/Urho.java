package parsers;

import model.Beer;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: vulp
 * Date: 1/7/13
 * Time: 10:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class Urho {

    private Document doc;
    private List<Beer> beerList;

        public List<Beer> parsePage() {
        try {
            beerList = new ArrayList<Beer>();
            doc  = Jsoup.connect("http://www.botta.fi/fi/st+urhos+pub/hanasta/").get();
            Elements elements = doc.select("td");
        } catch (Exception e) {
            System.out.println("error " + e);
        }
            return beerList;
        }
}
