package Cronservice;

import Beer.Beer;
import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import parsers.*;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: vulp
 * Date: 1/23/13
 * Time: 4:24 PM
 * To change this template use File | Settings | File Templates.
 */
@Component
public class WritePages {

    private static final Logger logger = Logger.getLogger(WritePages.class);
    private FileOutputStream fop = null;
    private File file;
    private StringBuffer bisset;
    private List<Beer> beerList;
    private List barList = new ArrayList();
    private final Lintu lintu = new Lintu();
    private final Kaisla kaisla = new Kaisla();
    private final Penni penni = new Penni();
    private final Urho urho = new Urho();
    private final OnePint onePint = new OnePint();
    private final Stones stones = new Stones();
    private final Bruuveri bruuveri = new Bruuveri();
    private final Teereenpeli teereenpeli = new Teereenpeli();
    private final Blackdoor blackdoor = new Blackdoor();
    private final Vltava vltava = new Vltava();
    @Scheduled(cron="0 0 1 ? * MON")
    //@Scheduled(fixedDelay = 5000)  //testiä varten  ajaa 5 sekunnin välein getpagesia !ei serverille tätä versiota kiitos!
    public void getPages() {
        logger.info("Starting cron task for beer parsing");
        barList.add(bruuveri.parsePage());
        barList.add(lintu.parsePage());
        barList.add(kaisla.parsePage());//parse pages
        barList.add(penni.parsePage());
        barList.add(urho.parsePage());
        barList.add(onePint.parsePage());
        barList.add(stones.parsePage());
        barList.add(teereenpeli.parsePage());
        barList.add(blackdoor.parsePage());
        barList.add(vltava.parsePage());

        List<String> baarit = new ArrayList<String>();
        baarit.add("bruuveri");
        baarit.add("lintu");
        baarit.add("kaisla");
        baarit.add("penni");
        baarit.add("urho");
        baarit.add("onePint");
        baarit.add("stones");
        baarit.add("teereenpeli");
        baarit.add("blackdoor");
        baarit.add("vlatava");
        int listPosition = 0;
        //check beerlist
        for(Object bar : barList) {
            beerList = (List<Beer>) bar;
            bisset = new StringBuffer();

            //write beer to stringbuffer
            bisset.append("<table>");
            bisset.append("<tbody>");
            for (Beer bisse : beerList){
                bisset.append("<tr>");
                bisset.append("<td>" + bisse.getName() + "</td><td>" +bisse.getPercent() + "</td><td>" + bisse.getPrice() + "</td><td>" + bisse.getDescription() +"</td>\n");
                bisset.append("</tr>");
            }
            bisset.append("</tbody>");
            bisset.append("</table>");
            writePages(bisset, baarit.get(listPosition));
            listPosition++;
            logger.info(baarit.get(listPosition) + " done!");
        }
    }

    private void writePages(StringBuffer parsedBeers, String  barName) {
        try {
            file = new File(barName + ".txt");
			fop = new FileOutputStream(file);

            // if file doesn't exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }

            // get the content in bytes
            byte[] contentInBytes = parsedBeers.toString().getBytes();
            fop.write(contentInBytes);
            fop.flush();
            fop.close();
        }catch(Exception e){
            logger.error("Cronservice error: " +e);
        } finally {
            try{
                 fop.close();
            } catch (Exception ee) {
                logger.error("Cronservice error2: " +ee);
            }
        }

    }
}
