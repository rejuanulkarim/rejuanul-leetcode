class Solution {
    public double angleClock(int hour, int minutes) {
        double h = (hour%12)*30;
        double m = minutes*5.5;
        double diff = Math.abs(h-m);
        return Math.min(diff , 360-diff);
    }
}