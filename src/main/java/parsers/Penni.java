package parsers;

import model.Beer;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: vulp / vetoketju
 * Date: 1/7/13
 * Time: 10:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class Penni {
    private Document doc;
    private List<Beer> beerList;
    private static final Logger logger = Logger.getLogger(Penni.class);
    public List<Beer> parsePage() {
        try {
            beerList = new ArrayList<Beer>();
            doc = Jsoup.connect("http://oluttupa.viisipennia.fi/hanassa-nyt").userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.97 Safari/537.11").get();
            Elements elements = doc.select("div#txt p");

            Beer thisBeer = null;
            boolean allow = false;
            for (Element element : elements) {
                String eT = element.text().replaceAll("\u00A0", " ").trim();
                if (!eT.equalsIgnoreCase("Hanassa Nyt") && !eT.equalsIgnoreCase("&nbsp;") && eT.length() > 1) {
                    if (!eT.startsWith("-")) {
                        allow = true;
                    }
                    if(!eT.startsWith("-") && eT.endsWith("%")) {
                        allow = true;
                    }else {
                        allow = false;
                    }
                    if (allow) {
                        if (thisBeer != null) beerList.add(thisBeer);
                        thisBeer = new Beer();
                        thisBeer.setPrice(-1);
                        int prosenttimerkinKohta = eT.indexOf("%");
                        int alku = 0;
                        for (int i = prosenttimerkinKohta - 1; i >= alku; i--) {
                            if (!Character.isDigit(eT.charAt(i)) && eT.charAt(i) != ',' && eT.charAt(i) != '.' && eT.charAt(i) != ' ') {
                                alku = i;
                                break;
                            }
                        }
                        thisBeer.setName(eT.substring(0, alku + 1).trim());
                        thisBeer.setPercent(Double.parseDouble(eT.substring(alku + 1, prosenttimerkinKohta).replace(',', '.').trim()));

                    } else {
                        if (thisBeer.getDescription() == null) {
                            thisBeer.setDescription(eT.replaceFirst("-", ""));
                        } else {
                            thisBeer.setDescription(thisBeer.getDescription() + "," + eT.replaceFirst("-", ""));
                        }
                    }
                }
            }

        } catch (Exception e) {
            logger.error("Penni error: " +e);
        }
        return beerList;
    }

}
