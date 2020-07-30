package com.neuda.shorturl.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.neuda.shorturl.domain.ShortUrl;
import com.neuda.shorturl.service.UrlService;

@RestController()
public class UrlController {

	@Autowired
	private UrlService urlService;
	
	@GetMapping("/r/{id}")
	public void redirect(@PathVariable String id, HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		ShortUrl url = urlService.getShortUrl(id).get();
		if(url == null) {
			throw new  ResponseStatusException(HttpStatus.NOT_FOUND, "Url Not Found");
		}else {
			response.sendRedirect(url.getOriginalUrl());
		}
	}
    
	@GetMapping("/url/{id}")
	public ShortUrl getShortUrl(@PathVariable("id") String id) {
		ShortUrl url = urlService.getShortUrl(id).get();
		if(url == null) {
			throw new  ResponseStatusException(HttpStatus.NOT_FOUND, "Url Not Found");
		}else {
			return url;
		}
		
	}
	
	@PostMapping("/url")
	public ShortUrl createShortUrl(@RequestBody String url) {
		ShortUrl shortUrl = new ShortUrl();
		shortUrl.setOriginalUrl(url);
		return urlService.addShortUrl(shortUrl);
		
	}
	
	@DeleteMapping("/url/{id}")
	public void deleteShortUrl(@PathVariable("id") String id) {
		urlService.deleteShortUrl(id);
		
	}
}
