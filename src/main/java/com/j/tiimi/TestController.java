package com.j.tiimi;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by jan on 30/03/2017.
 */

@Controller
public class TestController {

    @RequestMapping("*")
    @ResponseBody
    public String home() {
        return "Hei maailma";
    }

}
