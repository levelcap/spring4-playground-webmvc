package com.levelcap.spring.playground.webmvc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for the root ("/") and /bye endpoints which return String
 * responses. Using @RestController, new to Spring 4, that removes the need for @ResponseBody
 * on @RequestMapping methods.
 * 
 * @author Dave Cohen
 * 
 */
@RestController
class IndexController
{
    /**
     * showIndex handles the root mapping and returns a hello message.
     * 
     * @return The hello message String.
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showIndex()
    {
        return "<h1>Hello!</h1>";
    }

    /**
     * showIndex handles the /bye mapping and returns a bye message.
     * 
     * @return The goodbye message String.
     */
    @RequestMapping(value = "/bye", method = RequestMethod.GET)
    public String showBye()
    {
        return "<h1>Bye :( </h1>";
    }
}
