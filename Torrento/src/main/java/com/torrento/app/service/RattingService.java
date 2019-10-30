package com.torrento.app.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.torrento.app.bean.Rattings;

@Service
public class RattingService {
	
	static Map<String,List<Rattings>> rattingsMap = new HashMap<>();
	
	// To store the json value in map
	
	public void saveRattings(List<Rattings> rattings){
		rattingsMap.put("userRatting", rattings);
		
	}
	//  to display list  value present in hashmap
	
	public Iterable<List<Rattings>> list() {
		
        return rattingsMap.values();
    }


}
