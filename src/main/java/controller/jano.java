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
import parsers.Lintu;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/")
public class jano {

    private Lintu lintu = new Lintu();

    @RequestMapping("/")
    public String showIndex(){
        return "index";
    }

    @RequestMapping(value = "/{ravintola}", method = RequestMethod.GET)
	public String printWelcome(@PathVariable String ravintola, Model model) {
        List<Beer> beerList = null;// = new ArrayList<Beer>();
        //todo hae parse metodista tulos tähän ja palauta se modelissa
        if(ravintola.equalsIgnoreCase("lintu")) {
            beerList = lintu.parsePage();
        }
        model.addAttribute("olvi", beerList);
		return "beerList";
	}
}
