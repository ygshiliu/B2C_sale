package com.wnn.mycontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	@RequestMapping("index.htm")
	public String index(){
		return "sale_index";
	}
}
