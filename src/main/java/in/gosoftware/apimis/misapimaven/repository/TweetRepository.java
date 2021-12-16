package in.gosoftware.apimis.misapimaven.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import in.gosoftware.apimis.misapimaven.model.Tweet;



@Repository
public interface TweetRepository extends ReactiveMongoRepository<Tweet, String> {

}