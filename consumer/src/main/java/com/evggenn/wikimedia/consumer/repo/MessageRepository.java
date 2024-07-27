package com.evggenn.wikimedia.consumer.repo;

import com.evggenn.wikimedia.consumer.message.WikiMessage;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends MongoRepository<WikiMessage, String> {
}
