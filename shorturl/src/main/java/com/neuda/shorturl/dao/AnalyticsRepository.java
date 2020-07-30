package com.neuda.shorturl.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.neuda.shorturl.domain.Analytics;

public interface AnalyticsRepository extends MongoRepository<Analytics, String> {

	 

}