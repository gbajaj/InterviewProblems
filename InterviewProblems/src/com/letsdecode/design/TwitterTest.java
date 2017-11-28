package com.letsdecode.design;

import static org.junit.Assert.*;

import org.junit.Test;

public class TwitterTest {

	@Test
	public void test() {
		Twitter twitter = new Twitter();
		twitter.postTweet(1, 5);
		System.out.println(twitter.getNewsFeed(1));
		twitter.follow(1, 2);
		twitter.postTweet(2, 6);
		System.out.println(twitter.getNewsFeed(1));
		twitter.unfollow(1, 2);
		System.out.println(twitter.getNewsFeed(1));
		// ["Twitter","postTweet","getNewsFeed","follow","postTweet","getNewsFeed","unfollow","getNewsFeed"]
		// [[],[1,5],[1],[1,2],[2,6],[1],[1,2],[1]]
	}

	// ["Twitter","postTweet","getNewsFeed","follow","getNewsFeed","unfollow","getNewsFeed"]
	// [[],[1,1],[1],[2,1],[2],[2,1],[2]]

	@Test
	public void tes2t() {
		Twitter twitter = new Twitter();
		twitter.postTweet(1, 1);
		System.out.println(twitter.getNewsFeed(1));
		twitter.follow(2, 1);
		System.out.println(twitter.getNewsFeed(2));
		twitter.unfollow(2, 1);
		System.out.println(twitter.getNewsFeed(2));
		// ["Twitter","postTweet","getNewsFeed","follow","postTweet","getNewsFeed","unfollow","getNewsFeed"]
		// [[],[1,5],[1],[1,2],[2,6],[1],[1,2],[1]]
	}
	@Test
	public void test3() {
		Twitter twitter = new Twitter();
		twitter.postTweet(1, 5);
		twitter.postTweet(2, 6);
		twitter.follow(1, 2);
		System.out.println(twitter.getNewsFeed(1));
	}
}
