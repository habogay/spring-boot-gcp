package com.fcs.controller;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;

@Controller

public class HomeController {

	@Autowired
	Firestore firestore;

	@GetMapping(value = "/")
	public String index() throws InterruptedException, ExecutionException {

		return "views/home/index";
	}
	@GetMapping(value = "/welcome")
	public String welcome() throws InterruptedException, ExecutionException {

		return "welcome";
	}
	@GetMapping(value = "/firestore/libversion")
	@ResponseBody
	public String status() throws InterruptedException, ExecutionException {
		
		return firestore.getOptions().getLibraryVersion();
	}

}
