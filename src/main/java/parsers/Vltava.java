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
public class Vltava {
    private Document doc;
    private List<Beer> beerList;

    public List<Beer> parsePage() {
        try {
            beerList = new ArrayList<Beer>();
            doc = Jsoup.connect("http://www.vltava.fi/juomalista.html").get();
            Elements elements = doc.select("table.contenttable tr");

            for (Element element : elements) {

                if (element.html().contains("MUUT - OTHERS")) {
                    break;
                }
                if (!element.text().contains("OLUET") &&
                        !element.text().contains("VLTAVA HOUSE BRAND") &&
                        !element.text().contains("HANASSA") &&
                        !element.text().contains("Muut")) {

                    try {

                        Element tietoEl = element.select("td").first();
                        Element hintaEl = element.select("td").last();

                        //TIEDOT
                        String nimi = tietoEl.select("p strong").text();
                        String descr = tietoEl.select("p").first().ownText();

                        int prosenttimerkinKohta = nimi.indexOf("%");
                        int alku = 0;
                        for (int i = prosenttimerkinKohta - 1; i >= alku; i--) {
                            if (!Character.isDigit(nimi.charAt(i)) && nimi.charAt(i) != ',' && nimi.charAt(i) != '.' && nimi.charAt(i) != ' ') {
                                alku = i;
                                break;
                            }
                        }

                        double percent = -1;
                        double hinta = -1;

                        try {
                            hinta = Double.parseDouble(hintaEl.text().substring(0, hintaEl.text().indexOf('€') - 1).replace('\u00A0', ' ').trim().replace(',', '.'));
                        } catch (Exception e) {
                        }

                        try {
                            percent = Double.parseDouble(nimi.substring(alku + 1, prosenttimerkinKohta).replace(',', '.').trim());
                        } catch (Exception es) {
                        }

                        nimi = nimi.substring(0, alku + 1).trim();

                        beerList.add(new Beer(nimi.replace('\u00A0', ' ').trim(), hinta, percent, descr.replace('\u00A0', ' ').trim()));
                    } catch (Exception e) {
                        //e.printStackTrace();
                    }

                }

            }


        } catch (Exception e) {
            System.out.println("error " + e);
        }
        return beerList;
    }
}
