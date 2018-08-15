package com.ymm.info.logplatform.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author fanyu9488
 * @version Id: MainController, v 0.1 2018/8/14 10:12 fanyu9488 Exp $
 */

@Controller
@RequestMapping("/")
public class MainController {

    @RequestMapping("")
    public String index(){
        return "log";
    }

}
