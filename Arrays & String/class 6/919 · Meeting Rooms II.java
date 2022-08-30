class MyComparator implements Comparator<Pair>
 {
     public int compare(Pair p1 , Pair p2)
     {
         return p1.time - p2.time;
     }
 }
class Pair{
    int time , roomReq;
    public Pair(int time , int roomReq)
    {
        this.time = time;
        this.roomReq = roomReq;
    }
}
public class Solution {
    /**
     * @param intervals: an array of meeting time intervals
     * @return: the minimum number of conference rooms required
     */
     /*
     8:00 am - 10:00 am : SDE2 
     8:30 am - 9:00 am : SDE 1 
     9:15 am - 12:15 pm : SDE 3  
     */
    public int minMeetingRooms(List<Interval> intervals) {
        List<Pair> time = new ArrayList<>();
        for(int i = 0 ; i < intervals.size() ; i++) // N
        {
            int startTime = intervals.get(i).start;
            int endTime = intervals.get(i).end;
            time.add(new Pair(startTime , 1));
            time.add(new Pair (endTime , -1));

        }
        Collections.sort(time , new MyComparator()); // Mlog M
        int min_meetingRooms = 0;
        int currentMeetingRooms = 0;
        for(int i = 0 ; i < time.size() ; i++) // M
        {
            Pair p = time.get(i);
            currentMeetingRooms += p.roomReq;
            min_meetingRooms = Math.max(min_meetingRooms , currentMeetingRooms);
        }
        return min_meetingRooms;
    }
}
// TC : O(Mlog M)
// SC : O(M)
