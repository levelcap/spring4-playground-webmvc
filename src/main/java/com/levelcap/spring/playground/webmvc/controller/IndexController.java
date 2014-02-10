package com.levelcap.spring.playground.webmvc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//Using @RestController, new to Spring 4, that removes the need for @ResponseBody on methods
@RestController
class IndexController
{
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showIndex()
    {
        return "<h1>Hello!</h1>";
    }

    @RequestMapping(value = "/bye", method = RequestMethod.GET)
    public String showBye()
    {
        return "<h1>Bye :( </h1>";
    }

}
