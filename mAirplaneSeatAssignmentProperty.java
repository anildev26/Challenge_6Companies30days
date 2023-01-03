package challenge_6Company_30Days;

public class mAirplaneSeatAssignmentProperty {

    public static double nthPersonGetsNthSeat(int n) {
        if(n==1)
            return 1;

        return 0.5d;

    }

    public static void main(String[] args) {
        int n = 2;
        System.out.println(nthPersonGetsNthSeat(n));
    }
}
