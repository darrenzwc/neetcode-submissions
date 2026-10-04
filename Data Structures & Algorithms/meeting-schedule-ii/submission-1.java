/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if(intervals.size() < 1) {
            return 0;
        }
        // Sort the intervals in increasing start time
        intervals.sort(Comparator.comparingInt(interval -> interval.start));
        // earliest meeting end times at the front
        PriorityQueue<Interval> minHeap = new PriorityQueue<>(Comparator.comparingInt(interval -> interval.end));
        for(Interval meeting : intervals) {
            // Check if earliest meeting ended can be used for another
            if(!minHeap.isEmpty() && meeting.start >= minHeap.peek().end) {
                minHeap.poll();
            }
            minHeap.add(meeting);
        }
        return minHeap.size();
    }
}
