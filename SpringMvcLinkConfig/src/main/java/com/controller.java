package com;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class controller {

   /** @RequestMapping("/")
    public String index(){
        return "index";
    }
**/
    @RequestMapping("/category")
    public String category(){
        return "category";
    }
}
