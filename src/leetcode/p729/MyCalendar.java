package leetcode.p729;

import java.util.TreeSet;

public class MyCalendar {

    private TreeSet<int[]> calendar;

    public MyCalendar() {
        this.calendar= new TreeSet<>((int[] one, int[] other) -> one[0]-other[0]);
    }

    public boolean book(final int start, final int end) {
        final int[] newInterval= new int[] {start, end};

        // check existing interval right before the new interval
        int[] floor= calendar.floor(newInterval);
        if (floor != null && floor[1] > start) return false;

        // check existing interval right after the new interval
        int[] ceiling= calendar.ceiling(newInterval);
        if(ceiling != null && ceiling[0] < end) return false;

        // good to go
        calendar.add(newInterval);
        return true;
    }
}