package com.letsdecode.problems;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import com.letsdecode.problems.timebucket.Bucket;

public class timebucketTest {

	@Test
	public void test() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String startTime = "Wed Jun 22 21:00:00 PDT 2016";
		String tonight = "Wed Jun 22 23:59:00 PDT 2016";
		Date start = new Date(startTime);
		System.out.println(new Date(tonight));
		System.out.println(new Date(System.currentTimeMillis()));

		Bucket[] d = {
				 new timebucket.Bucket(start, "", "Overdue"),
				 new timebucket.Bucket(new Date(tonight), "", "Today"),
				 new timebucket.Bucket(new
				 Date("Wed Jun 22 23:59:00 PDT 2017"),
				 "", "Next Year"),
				 new timebucket.Bucket(new
				 Date("Wed Jun 22 23:59:00 PDT 2018"),
				 "", "Some Day"),
				 new timebucket.Bucket(new
				 Date("Wed Aug 22 23:59:00 PDT 2016"),
				 "", "August"),
				 new timebucket.Bucket(new
				 Date("Wed Dec 22 23:59:00 PDT 2016"),
				 "", "December"),
				 new timebucket.Bucket(new
				 Date("Wed Jan 22 23:59:00 PDT 2016"),
				 "", "Overdue"),
				 new timebucket.Bucket(
				 new Date("Mon July 04 23:59:00 PDT 2016"), "",
				 "Next month"),
				 new Date("Mon July 04 23:59:00 PDT 2016"), "",
				 "Next month"),
				
				new timebucket.Bucket(new Date("Wed Jun 23 23:59:00 PDT 2016"),
						"", "Tomorrow"),
				new timebucket.Bucket(new Date("Thu Jun 24 23:59:00 PDT 2016"),
						"", "In 2 days"),
				new timebucket.Bucket(new Date("Fri Jun 25 23:59:00 PDT 2016"),
						"", "In 3 days"),
				new timebucket.Bucket(new Date("Thu Jun 30 23:59:00 PDT 2016"),
						"", "Next Week")
				

		};
		new timebucket().init(d);
		for (Bucket b : d) {
			Assert.assertEquals(b.expected, b.bucket);
		}

	}

}
