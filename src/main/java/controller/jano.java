package controller;

/**
 * Created by IntelliJ IDEA.
 * User: vulp
 * Date: 1/6/13
 * Time: 6:17 PM
 * To change this template use File | Settings | File Templates.
 */
import model.Beer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import parsers.*;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/")
final class jano {

    private Lintu lintu = new Lintu();
    private Kaisla kaisla = new Kaisla();
    private Penni penni = new Penni();
    private Urho urho = new Urho();
    private OnePint onePint = new OnePint();
    private Stones stones = new Stones();
    private Bruuveri bruuveri = new Bruuveri();
    private List<Beer> beerList = null;
    private Teereenpeli teereenpeli = new Teereenpeli();
    private Blackdoor blackdoor = new Blackdoor();
    private Vltava vltava = new Vltava();
    @RequestMapping("/")
    public String showIndex(){
        return "index";
    }

    @RequestMapping(value = "/{ravintola}", method = RequestMethod.GET)
	public String printWelcome(@PathVariable String ravintola, Model model) {
        if(ravintola.equalsIgnoreCase("lintu")) {
            beerList = lintu.parsePage();
        } else if(ravintola.equalsIgnoreCase("penni")) {
            beerList = penni.parsePage();
        } else if(ravintola.equalsIgnoreCase("kaisla")) {
            beerList = kaisla.parsePage();
        } else if(ravintola.equalsIgnoreCase("stones")) {
            beerList = stones.parsePage();
        } else if(ravintola.equalsIgnoreCase("bruuveri")) {
            beerList = bruuveri.parsePage();
        } else if(ravintola.equalsIgnoreCase("onepint")) {
            beerList = onePint.parsePage();
        } else if(ravintola.equalsIgnoreCase("blackdoor")) {
            beerList = blackdoor.parsePage();
        } else if(ravintola.equalsIgnoreCase("vltava")) {
            beerList = vltava.parsePage();
        } else if(ravintola.equalsIgnoreCase("teerenpeli")) {
            beerList = teereenpeli.parsePage();
        } else if(ravintola.equalsIgnoreCase("urho")) {
            beerList = urho.parsePage();
        } else if(ravintola.equalsIgnoreCase("onnela") || ravintola.equalsIgnoreCase("tiger")) {
            Beer beer = new Beer();
            beer.setName("Kotona saat vettä ilmaiseksi");
            beer.setPrice(777);
            beer.setDescription("Koitahan hakea jollain seuraavista: kaisla, urho, penni");
            beerList = new ArrayList<Beer>();
            beerList.add(beer);
        } else {
            Beer beer = new Beer();
            beer.setName("Nyt on bisse hukassa");
            beerList = new ArrayList<Beer>();
            beerList.add(beer);
        }
        model.addAttribute("olvi", beerList);
		return "beerList";
	}
}
