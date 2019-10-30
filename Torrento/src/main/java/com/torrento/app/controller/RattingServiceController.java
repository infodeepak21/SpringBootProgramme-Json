package com.torrento.app.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.torrento.app.bean.Rattings;
import com.torrento.app.service.RattingService;

@RestController

// Api call used operation Name

@RequestMapping("/rattings") 
public class RattingServiceController {
	private RattingService rattingService;

    public RattingServiceController(RattingService rattingService) {
        this.rattingService = rattingService;
        
    }
    
	/*
	 * Api call used after operation Name like "http://localhost:8080/rattings/list "
	 */
    
    @GetMapping("/list")
    public Iterable<List<Rattings>> getRattingsList() {    	
    	
        return rattingService.list();
    }

}
