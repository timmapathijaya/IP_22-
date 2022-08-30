class MyComparator implements Comparator<Interval>
{
    public int compare(Interval meeting_a , Interval meeting_b)
    {
        return meeting_a.start - meeting_b.start;
    }
}
public class Solution {
    /**
     * @param intervals: an array of meeting time intervals
     * @return: if a person could attend all meetings
     */
    public boolean canAttendMeetings(List<Interval> intervals) {
        Collections.sort(intervals , new MyComparator());
        // Check for overlapping 
        // if no meeting is getting overlapped => Person can attend all the meetings
        for(int i = 1 ; i < intervals.size() ; i++)
        {
            int end_time = intervals.get(i-1).end;
            int start_time = intervals.get(i).start;
            if(start_time >= end_time)
            continue;
            else
            return false;
        }
        return true;
    }
}
// TC : O(N)
// SC : O(1)
