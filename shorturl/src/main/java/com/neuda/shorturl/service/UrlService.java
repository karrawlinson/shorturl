package com.neuda.shorturl.service;

import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuda.shorturl.dao.UrlRepository;
import com.neuda.shorturl.domain.ShortUrl;

@Service
public class UrlService {
	
	@Autowired
	private UrlRepository repository;
	
	private String baseUrl = "http://localhost:8080/r/";
	
	/**
	 * Return a short url given the id
	 * @param id
	 * @return
	 */
	public Optional<ShortUrl> getShortUrl(String id) {

		return repository.findById(id);
	}
	
	/**
	 * Add a short url 
	 * @param id
	 * @return
	 */
	public ShortUrl addShortUrl(ShortUrl shortUrl) {

		shortUrl.setId(new Random().nextInt() + "");
		shortUrl.setUrl(baseUrl + shortUrl.getId());
		repository.save(shortUrl);	
		return shortUrl;
	}
	
	/**
	 * Delete a short url 
	 * @param id
	 * @return
	 */
	public void deleteShortUrl(String id) {

		repository.deleteById(id);
	}
}
