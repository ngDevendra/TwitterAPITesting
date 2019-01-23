package com.twitter.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

@SpringBootApplication
public class TwitterApiTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(TwitterApiTestApplication.class, args);

		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true)
				.setOAuthConsumerKey("******************")
				.setOAuthConsumerSecret("******************")
				.setOAuthAccessToken("******************")
				.setOAuthAccessTokenSecret("******************");
		TwitterFactory tf = new TwitterFactory(cb.build());

		try {
			Twitter twitter = tf.getInstance();
			String message="Let's post it using Twitter API and Twitter4j lib";
			Status status = twitter.updateStatus(message);
			System.out.println("Twitter Posting Status : "+status);

			User user = twitter.verifyCredentials();

			System.out.println("User Id: "+ user.getId());
			System.out.println("User Name: "+ user.getName());
			System.out.println("User Email: "+ user.getEmail());
			System.out.println("User Followers Count: "+ user.getFollowersCount());

		} catch (TwitterException e){
			e.printStackTrace();
		}

	}

}

