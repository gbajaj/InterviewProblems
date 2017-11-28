package com.letsdecode.problems;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class timebucket {
	long TONIGHT;
	long TOMORROW_NIGHT;
	long HOURS_24 = 1000 * 60 * 60 * 60 * 24;

	public timebucket() {

	}

	public static class Bucket {
		Date date;
		String bucket;
		String expected;

		public Bucket(Date date, String bucket, String expected) {
			this.date = date;
			this.bucket = bucket;
			this.expected = expected;
		}
	}

	String[] months = { "January", "February", "March", "April", "May", "June",
			"July", "August", "September", "October", "November", "December" };

	public void init(Bucket b[]) {
		long currentTime = System.currentTimeMillis();
		Calendar now = Calendar.getInstance();
//		now.set(Calendar.HOUR, 0);
//		now.set(Calendar.MINUTE, 0);
//		now.set(Calendar.SECOND, 0);
//		now.set(Calendar.HOUR_OF_DAY, 0);
//		TONIGHT = now.getTime().getTime();
		for (Bucket bk : b) {
			System.out.println(bk.date.getTime());
			Calendar taskTime = Calendar.getInstance();
			taskTime.setTime(bk.date);
			if (taskTime.get(Calendar.YEAR) - now.get(Calendar.YEAR) > 1) {
				bk.bucket = "Some Day";
			} else if (taskTime.get(Calendar.YEAR) - now.get(Calendar.YEAR) == 1) {
				bk.bucket = "Next Year";
			} else if (taskTime.get(Calendar.YEAR) - now.get(Calendar.YEAR) == 0) {
				bk.bucket = "Same Year";
				if (taskTime.get(Calendar.MONTH) - now.get(Calendar.MONTH) > 1) {
					bk.bucket = months[taskTime.get(Calendar.MONTH)];
				} else if (taskTime.get(Calendar.MONTH)
						- now.get(Calendar.MONTH) == 1) {
					bk.bucket = "Next month";
				} else if (taskTime.get(Calendar.MONTH)
						- now.get(Calendar.MONTH) == 0) {
					if (taskTime.get(Calendar.WEEK_OF_MONTH)
							- now.get(Calendar.WEEK_OF_MONTH) > 1) {
						bk.bucket = "This Month";
					} else if (taskTime.get(Calendar.WEEK_OF_MONTH)
							- now.get(Calendar.WEEK_OF_MONTH) == 1) {
						bk.bucket = "Next Week";
					} else if (taskTime.get(Calendar.WEEK_OF_MONTH)
							- now.get(Calendar.WEEK_OF_MONTH) == 0) {
						if (taskTime.get(Calendar.DAY_OF_WEEK)
								- now.get(Calendar.DAY_OF_WEEK) > 1) {
							bk.bucket = "In "
									+ (taskTime.get(Calendar.DAY_OF_WEEK) - now
											.get(Calendar.DAY_OF_WEEK))
									+ " days";
						} else if (taskTime.get(Calendar.DAY_OF_WEEK)
								- now.get(Calendar.DAY_OF_WEEK) == 1) {
							bk.bucket = "Tomorrow";
						} else if (taskTime.get(Calendar.DAY_OF_WEEK)
								- now.get(Calendar.DAY_OF_WEEK) == 0) {
							bk.bucket = "Today";
							if (taskTime.getTime().getTime() < currentTime) {
								bk.bucket = "Overdue";
							}
						}
					}

				} else  {
					bk.bucket = "Overdue";
				}
				
			}
		}
		// Calendar now = Calendar.getInstance();
		// now.set(Calendar.HOUR, 0);
		// now.set(Calendar.MINUTE, 0);
		// now.set(Calendar.SECOND, 0);
		// now.set(Calendar.HOUR_OF_DAY, 0);
		// TONIGHT = now.getTime().getTime();
		// TOMORROW_NIGHT = now.getTime().getTime() + HOURS_24;
		//
		// now.set(Calendar.SUNDAY, 0);
		//
	}
}
