package com.xr.chain.api.security.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xr.chain.api.security.service.ECAAService;

/*
 * Created by xps15 on 2016/12/12.
 */
@RestController
@RequestMapping("/security")
public class SecurityController {
	
	@Autowired
	private ECAAService ecaaService;
	

    @RequestMapping(value = "/ecerts/{id}",method = RequestMethod.GET)
    public String getEcerts(@PathVariable(name = "id")String id) throws Exception {
        return id;
    }
    

    @RequestMapping(value = "/r/{id}",method = RequestMethod.GET)
    public String get(@PathVariable(name = "id")String id) throws Exception {
    	this.ecaaService.registerUser(id, "bank_a");
        return id;
    }


	public ECAAService getEcaaService() {
		return ecaaService;
	}


	public void setEcaaService(ECAAService ecaaService) {
		this.ecaaService = ecaaService;
	}
    
    
}
