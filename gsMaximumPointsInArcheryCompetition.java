package challenge_6Company_30Days;

public class gsMaximumPointsInArcheryCompetition {

    static int bobPoint = 0;
    static int[] maxbob = new int[12];
    public static int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        int[] bob = new int[12];
        calculate(aliceArrows, bob, 11, numArrows, 0);  //Start with max point that is 11
        return maxbob;
    }
    public static void calculate(int[] alice, int[] bob, int index, int remainArr, int point) {
        if(index < 0 || remainArr <= 0) {
            if(remainArr > 0)
                bob[0] += remainArr;
            if(point > bobPoint) { // Update the max points and result output
                bobPoint = point;
                maxbob = bob.clone();
            }
            return;
        }
        //part 1: assign 1 more arrow than alice
        if(remainArr >= alice[index]+1) {
            bob[index] = alice[index] + 1;
            calculate(alice, bob, index-1, remainArr-(alice[index]+1), point + index);
            bob[index] = 0;
        }
        //part 2: assign no arrow and move to next point
        calculate(alice, bob, index-1, remainArr, point);
        bob[index] = 0;
    }

    public static void main(String[] args) {
        int numArrows = 9;
        int [] aliceArrows = {1, 1, 0, 1, 0, 0, 2, 1, 0, 1, 2, 0};
        System.out.println(maximumBobPoints(numArrows,aliceArrows));

    }
}
