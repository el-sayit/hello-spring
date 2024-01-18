package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class HelloContoller {
    @GetMapping("/")
    public String displayName(Model model){
        String name = "Mike";
        double price = 12.99;
        model.addAttribute("name1",name);
        model.addAttribute("price", price);
        ArrayList<String> listOfNames =new ArrayList<>(
        Arrays.asList("John", "Todd","Bob")
        );
        model.addAttribute("listOfNames",listOfNames);
        ArrayList<String> coffeeNames = new ArrayList<>(
                Arrays.asList("French Toast", "Arabica", "Espresso")
        );
        model.addAttribute("coffeeOptions", coffeeNames);
        ArrayList<String> description =new ArrayList<>(
                Arrays.asList("Mild","Robust","Light")
        );
        model.addAttribute("coffeeDescription",description);
        return "index";
    }
    @GetMapping("hello-names")
    public String helloNames(Model model){
        List<String> names =new ArrayList<>();
        names.add("Mars");
        names.add("Jupiter");
        names.add("saturn");
        model.addAttribute("names", names);
        ArrayList<Integer> numbers = new ArrayList<>(
                Arrays.asList(2,5,-8,-7,-9)
        );
        model.addAttribute("numbers", numbers);
        return "hello-list";
    }

    @GetMapping("form")
        public String displayForm() {
        return "form";

    }

    @RequestMapping(value = "form/add", method = {RequestMethod.GET})
    @ResponseBody
    public String postForm(@RequestParam String name, @RequestParam String language) {

  return createMessage(name, language);
    }

    public static String createMessage(String name, String language) {
        String msg = null;
        if (language.equals("english")) {
            msg = "<html>" +
                    "<body style='background:#d3d3d3'>" +
                    "<h1 style='text-align:center'>Hello " + name + "<h1>";
        } else if (language.equals("french")) {
            msg = "<html>" +
                    "<body style='background:#d3d3d3'>" +
                    "<h1 style='text-align:center'>Bonjour " + name + "<h1>";

        }else if (language.equals("german")) {
            msg = "<html>" +
                    "<body style='background:#d3d3d3'>" +
                    "<h1 style='text-align:center'>Hallo " + name + "<h1>";

        }else if (language.equals("spanish")) {
            msg = "<html>" +
                    "<body style='background:#d3d3d3'>" +
                    "<h1 style='text-align:center'>Hola " + name + "<h1>";
        }else if (language.equals("russian")) {
            msg = "<html>" +
                    "<body style='background:#d3d3d3'>" +
                    "<h1 style='text-align:center'>Privet " + name + "<h1>";
        }
    return msg;
    }
}