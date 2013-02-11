package parsers;

import Beer.Beer;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;
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
    private static final Logger logger = Logger.getLogger(Urho.class);
    private Document doc;
    private List<Beer> beerList;

        public List<Beer> parsePage() {
        try {
            beerList = new ArrayList<Beer>();
            doc  = Jsoup.connect("http://www.botta.fi/fi/st+urhos+pub/hanasta/").get();
            Elements elements = doc.select("div#wrap td");
            String nimi = "";
            String desc = "";
            double price;
            double percent = 0;
            int i = 0;
            int kierros = 0;
            for(Element element : elements) {
                    if(!element.text().equalsIgnoreCase("Koko") && !element.text().equalsIgnoreCase("Hinta") && !element.text().equalsIgnoreCase("Nimi") && !element.text().equalsIgnoreCase("Tyyli") && !element.text().equalsIgnoreCase("Maa") && !element.text().equalsIgnoreCase("Til") && !element.text().equalsIgnoreCase("pieni") && !element.text().equalsIgnoreCase("Iso") && !element.text().equalsIgnoreCase("Til %") ) {
                        if(i == 0) {
                            if(element.text().length() < 40) {
                                nimi = element.text();
                            }
                            i++;
                        } else if(kierros == 1 && i == 1) {
                            desc = element.text()+",";
                            i++;
                        } else if(kierros == 1 && i == 2) {
                            desc += element.text();
                            i++;
                        } else if(kierros == 1 && i == 3) {
                            if(element.text().length() > 0 && element.text().length() < 8) {
                                percent = Double.parseDouble(element.text());
                            }else {
                                percent = -1;
                            }
                            i++;
                        } else if(i == 7) {
                            if(element.text().length() > 0) {
                                price = Double.parseDouble(element.text());
                            }else {
                                price = -1;
                            }
                            i = 0;
                            beerList.add(new Beer(nimi,price,percent,desc));
                        } else {
                            if(i == 3 && kierros == 0 && element.text().length() < 2) {
                                i = 0; kierros = 1;
                            } else {
                                i++;
                            }
                        }
                    }
            }

        } catch (Exception e) {
            logger.error("Urho error: " +e);
        }
            return beerList;
        }
}
