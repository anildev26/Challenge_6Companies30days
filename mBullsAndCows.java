package challenge_6Company_30Days;

public class mBullsAndCows {
    public static String getHint(String secret, String guess){
        int bull = 0;
        int cows = 0;
        int[] secretArr = new int[10];   //to store count of every integer of secret String in index. (size - 10 : Number will be made in between 0-9)
        int[] guessArr = new int[10];    //to store count of every integer of secret String in index
        for(int i=0; i<secret.length(); i++){
            if(secret.charAt(i) == guess.charAt(i)){  //checking which integer matches on same index
                bull++;
            }else{
                secretArr[secret.charAt(i) - '0' ]++;  //increment the index value of given i th
                                                       //index ex: ('1'-'0'= ascii) increment that index value

                guessArr[guess.charAt(i) - '0' ]++;    //Same here too
            }
        }

        for(int i=0; i<10; i++){        //looping from 1-10 to loop each index of array size 10.
            cows += Math.min(secretArr[i],guessArr[i]);   //storing the minimum value from both the arr of ith index,
                                                          //if one array has 1 as a value and other has 0 it will add 0 to cows
                                                          //which won't affect our cows count. other ex: 5-2 it will take 2 and add to cow
        }
        String ans = bull + "A" + cows + "B"; //Creating a String variable to return
        return ans;
    }

    public static void main(String[] args) {
        String secret = "1107";
        String guess = "7717";
        System.out.println(getHint(secret,guess));

    }
}
