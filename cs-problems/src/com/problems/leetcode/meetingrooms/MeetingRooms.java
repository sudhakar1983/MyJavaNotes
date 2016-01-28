package com.problems.leetcode.meetingrooms;

import java.util.Arrays;
import java.util.Comparator;

/*
 * 
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.

For example,

Given [[0, 30],[5, 10],[15, 20]],
return false.
	
	
	My Solution :
		Tree Based approach will process this  logn 
 * 
 */
public class MeetingRooms {

	public static void main(String[] args) {
		
		canAttendMeetings(new Interval[]{new Interval(0, 30),new Interval(10, 20),new Interval(10, 15)} );
	}
	
	public static boolean canAttendMeetings(Interval[] intervals){
		
		 if (intervals == null)
			    return false;

			  // Sort the intervals by start time
			  Arrays.sort(intervals, new Comparator<Interval>() {
			    public int compare(Interval a, Interval b) { return a.start - b.start; }
			  });

			  for(Interval inter : intervals){
				  System.out.println(inter); 
			  }
			 
			  
			  
			  for (int i = 1; i < intervals.length; i++)
			    if (intervals[i].start < intervals[i - 1].end)
			      return false;

			  return true;
	}
}

class Interval {
	public int start;
	public int end;
	
	public Interval(int start,int end){
		this.start = start;
		this.end = end;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "["+start+","+end+"]";
	}
}
