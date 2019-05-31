package com;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(name = "/dev")
public class controller {
    @RequestMapping("/linkme")
    public String linkme(){
        return "linkme";
    }
}
