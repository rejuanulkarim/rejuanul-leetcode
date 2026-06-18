class Solution {
    public double angleClock(int hour, int minutes) {
        double h = (hour%12)*30; // hour hand move per hour 30 degree
        double m = minutes*5.5; // defferent between hour and minutes hand (6 - 0.5) degree
        double angel = Math.abs(h-m); 
        return (angel > 180)? 360 - angel:angel;
    }
}