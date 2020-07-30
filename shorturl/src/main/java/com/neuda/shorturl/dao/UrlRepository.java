package com.neuda.shorturl.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.neuda.shorturl.domain.ShortUrl;

public interface UrlRepository extends MongoRepository<ShortUrl, String> {

  public Optional<ShortUrl> findById(String firstName);
  public List<ShortUrl> findByUrl(String url);

}