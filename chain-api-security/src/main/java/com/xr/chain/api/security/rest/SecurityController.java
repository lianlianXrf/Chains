package com.xr.chain.api.security.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/*
 * Created by xps15 on 2016/12/12.
 */
@RestController
@RequestMapping("/security")
public class SecurityController {

    @RequestMapping(value = "/ecerts/{id}",method = RequestMethod.GET)
    public String getEcerts(@PathVariable(name = "id")String id) throws Exception {
        return id;
    }
}
