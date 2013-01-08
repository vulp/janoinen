package parsers;

import java.util.ArrayList;
import java.util.List;

import model.Beer;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/*
* @author Ville Valta
* Date: 7.1.2013
*
*/


public class OnePint {
    private Document doc;

    private List<Beer> beerList;

    public List<Beer> parsePage() {
        try {
            beerList = new ArrayList<Beer>();
            doc = Jsoup.connect("http://www.onepintpub.com/?page_id=6").get();
            Elements elements = doc.select("div.entry-content p");
            for (Element element : elements) {
                if (element.text().trim().equalsIgnoreCase("Tulossa:")) break;

                String eT = element.ownText().trim();
                if (!eT.equals("")) {
                    //System.out.println(eT);
                    int prosenttimerkinKohta = eT.indexOf("%");
                    int alku = 0;
                    for (int i = prosenttimerkinKohta - 1; i >= alku; i--) {
                        if (!Character.isDigit(eT.charAt(i)) && eT.charAt(i) != ',' && eT.charAt(i) != ' ') {
                            alku = i;
                            break;
                        }
                    }
                    beerList.add(new Beer(eT.substring(0, alku + 1).trim(), -1,
                            Double.parseDouble(eT.substring(alku + 1, prosenttimerkinKohta).replace(',', '.')),
                            ""));
                    //System.out.println("--------------------------------");
                    //System.out.println("Prossat =" + eT.substring(alku+1,prosenttimerkinKohta));
                    //System.out.println("Name="+ eT.substring(0,alku+1).trim());


                }

            }
        } catch (Exception e) {
            System.out.println("error " + e);
        }
        return beerList;
    }

}
