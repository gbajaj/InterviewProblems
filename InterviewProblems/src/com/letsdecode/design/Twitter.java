package com.letsdecode.design;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

import com.letsdecode.problems.linkedlist.LRUCache;

public class Twitter {
	class Tweet {
		int id;
		long time;

		public Tweet(int id) {
			this.id = id;
			this.time = s_time++;
		}
	}

	class Pair {
		Iterator<Tweet> it;
		Tweet t;

		public Pair(Iterator<Tweet> it, Tweet t) {
			this.it = it;
			this.t = t;
		}
	}

	class User {
		int id;
		LinkedList<Tweet> tweets = new LinkedList();
		HashSet<Integer> followed = new HashSet();

		public void follow(int id) {
			followed.add(id);
		}

		public void unFollow(int id) {
			followed.remove(id);
		}

		public User(int userId) {
			id = userId;
		}
	}

	HashMap<Integer, User> users = new HashMap<>();
	public static long s_time;
	/** Initialize your data structure here. */
	public Twitter() {

	}

	/** Compose a new tweet. */
	public void postTweet(int userId, int tweetId) {
		User user = users.get(userId);
		if (user == null) {
			user = new User(userId);
			users.put(userId, user);
		}
		user.tweets.addFirst(new Tweet(tweetId));
	}

	/**
	 * Retrieve the 10 most recent tweet ids in the user's news feed. Each item
	 * in the news feed must be posted by users who the user followed or by the
	 * user herself. Tweets must be ordered from most recent to least recent.
	 */
	public List<Integer> getNewsFeed(int userId) {
        List<Integer> l = new ArrayList<>();
        PriorityQueue<Pair> q = new PriorityQueue<>(10, new Comparator<Pair>() {
        	@Override
        	public int compare(Pair o1, Pair o2) {
        		return (int) (o2.t.time-o1.t.time);
        	}
		});
        ArrayList<Iterator<Tweet>> list= new ArrayList<>();
        User curUser = users.get(userId);
        if (curUser != null) {
        	list.add(curUser.tweets.iterator());
        	for (Integer id: curUser.followed) {
        		User u = users.get(id);
        		if (u != null) {
        			list.add(u.tweets.iterator());
        		}
        	}
        }
        for (Iterator<Tweet> it: list) {
        	if (it.hasNext()) {
        		q.add(new Pair(it, it.next()));
        	}
        }
        int i = 0;
        while (q .isEmpty() == false && i < 10) {
        	Pair p = q.poll();
        	l.add(p.t.id);
        	if (p.it.hasNext()) {
        		q.add(new Pair(p.it, p.it.next()));
        	}
        	i++;
        }
        return l;
        
    }
	 public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
	}

	 /**
	 * Follower follows a followee. If the operation is invalid, it should be a
	 * no-op.
	 */
	public void follow(int followerId, int followeeId) {
    	if (users.get(followerId)  == null) {
    		users.put(followerId, new User(followerId));
    	}
    	if (users.get(followeeId)  == null) {
    		users.put(followeeId, new User(followeeId));
    	}
    	
    	if (followerId == followeeId) {
    		return;
    	}
    	
        User curUser = users.get(followerId);
        if (curUser != null) {
        	curUser.followed.add(followeeId);
        }
	}

	/**
	 * Follower unfollows a followee. If the operation is invalid, it should be
	 * a no-op.
	 */
	public void unfollow(int followerId, int followeeId) {
        User curUser = users.get(followerId);
        if (curUser != null) {
        	curUser.followed.remove(followeeId);
        }
	}
}

/**
 * Your Twitter object will be instantiated and called as such: Twitter obj =
 * new Twitter(); obj.postTweet(userId,tweetId); List<Integer> param_2 =
 * obj.getNewsFeed(userId); obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
