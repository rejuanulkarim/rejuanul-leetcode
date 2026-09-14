
class Solution {

    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return forX(rec1, rec2) && forY(rec1, rec2);
    }

    boolean forX(int[] a, int[] b) {
        return a[0] < b[2] && a[2] > b[0];
    }

    boolean forY(int[] a, int[] b) {
        return a[1] < b[3] && a[3] > b[1];
    }
}