package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloContoller {

    @GetMapping("form")
    @ResponseBody
    public String displayForm() {
        return
                "<html>" +
                        "<body>" +
                        "<form action='form/add'>" +
                        "<input type ='text' name='name' placeholder='name'>" +
                        "<select name='language'>" +
                        "<option value='english'> English</option>" +
                        "<option value='french'> French</option>" +
                        "<option value= 'german'> German </option>" +
                        "<option value = 'spanish'> Spanish </option>" +
                        "<option value='russian'> Russian</option>" +
                        "<input type='submit' value='Greet Me!'>" +
                        "</form>" +
                        "</body>" +
                        "</html>";
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