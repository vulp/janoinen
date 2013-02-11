package parsers;

import Beer.Beer;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class Stones {
    private Document doc;
    private List<Beer> beerList;
    private static final Logger logger = Logger.getLogger(Stones.class);
    public List<Beer> parsePage() {
        try {
            ArrayList<Beer> smallerBeerList = new ArrayList<Beer>();

            beerList = new ArrayList<Beer>();
            doc = Jsoup.connect("http://www.stonespub.fi/?id=84").userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.97 Safari/537.11").get();
            Elements elements = doc.select("table tr td");
            for (Element element : elements) {
                String eT = element.ownText();
                if (!eT.equalsIgnoreCase("")) {
                    eT = eT.substring(eT.indexOf('.') + 1, eT.length()).trim();
                    Beer temp = new Beer(eT, -1, -1, "");
                    smallerBeerList.add(temp);
                }
            }

            doc = Jsoup.connect("http://www.stonespub.fi/m/juomalista").get();
            Elements els = doc.select("div.csc-default").first().select("h3");
            for (Element e : els) {
                String eT = e.ownText();
                if (eT.indexOf('%') != -1 && !eT.equalsIgnoreCase("")) {
                    int prosenttimerkinKohta = eT.indexOf("%");
                    int alku = 0;
                    for (int i = prosenttimerkinKohta - 1; i >= alku; i--) {
                        if (!Character.isDigit(eT.charAt(i)) && eT.charAt(i) != ',' && eT.charAt(i) != ' ') {
                            alku = i;
                            break;
                        }
                    }

                    beerList.add(new Beer(eT.substring(0, alku + 1).trim(), -1, Double.parseDouble(eT.substring(alku + 1, prosenttimerkinKohta).replace(',', '.')), ""));
                }
            }

            for (Beer beer : beerList) {
                for (Beer b : smallerBeerList) {
                    if (beer.getName().replace('Ü', 'U').contains(b.getName())) {
                        smallerBeerList.remove(b);
                        break;
                    }
                }
            }
            beerList.addAll(smallerBeerList);
        } catch (Exception e) {
            logger.error("Stones error: " +e);
        }
        return beerList;
    }


}
