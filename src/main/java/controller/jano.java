package controller;

/**
 * Created by IntelliJ IDEA.
 * User: vulp
 * Date: 1/6/13
 * Time: 6:17 PM
 * To change this template use File | Settings | File Templates.
 */
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import parsers.Lintu;


@Controller
@RequestMapping("/")
public class jano {

    private Lintu parse;

    @RequestMapping()
	public String printWelcome(Model model) {

        //todo hae parse metodista tulos tähän ja palauta se modelissa
        parse = new Lintu();
		model.addAttribute("olvi", parse.parsePage());
		return "index";

	}
}
