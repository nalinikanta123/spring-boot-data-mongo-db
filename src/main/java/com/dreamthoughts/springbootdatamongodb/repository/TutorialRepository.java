package com.dreamthoughts.springbootdatamongodb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.dreamthoughts.springbootdatamongodb.entity.Tutorial;

public interface TutorialRepository extends MongoRepository<Tutorial, String> {

	List<Tutorial> findByTitleContaining(String title);

	List<Tutorial> findByPublished(boolean published);
}
