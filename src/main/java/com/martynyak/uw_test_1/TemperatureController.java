package com.martynyak.uw_test_1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class TemperatureController {

    @Autowired
    private TemperatureService service;

    @GetMapping("/")
    public String welcome(Map<String, Object> model) {
        model.put("temp", service.getLast());
        return "welcome";
    }

    @RequestMapping("temperature")
    @ResponseBody
    public Integer getTemperature(){
        return service.getLast();
    }

}
