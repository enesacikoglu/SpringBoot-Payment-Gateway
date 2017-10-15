package com.ingenico.payment.challange.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ingenico.payment.challange.conf.ApplicationInfo;

@Controller
public class AppController {

	@Autowired
	ApplicationInfo app;

	@RequestMapping(path = { "/", "/app" }, method = RequestMethod.GET)
	@ResponseBody
	public ApplicationInfo appInfo() {
		return app;
	}

}
