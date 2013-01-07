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
import parsers.Kaisla;
import parsers.Lintu;
import parsers.Penni;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/")
public class jano {

    private Lintu lintu = new Lintu();
    private Kaisla kaisla = new Kaisla();
    private Penni penni = new Penni();

    @RequestMapping("/")
    public String showIndex(){
        return "index";
    }

    @RequestMapping(value = "/{ravintola}", method = RequestMethod.GET)
	public String printWelcome(@PathVariable String ravintola, Model model) {
        List<Beer> beerList = null;

        if(ravintola.equalsIgnoreCase("lintu")) {
            beerList = lintu.parsePage();
        } else if(ravintola.equalsIgnoreCase("penni")) {

        } else if(ravintola.equalsIgnoreCase("kaisla")) {

        } else if(ravintola.equalsIgnoreCase("urho")) {

        } else if(ravintola.equalsIgnoreCase("sedula")) {
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
