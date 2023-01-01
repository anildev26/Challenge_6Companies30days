package challenge_6Company_30Days;

import java.util.Stack;

public class mReversePolishNotation {

    public static int evalRPN(String [] tokens){
        Stack<Integer> s = new Stack<Integer>();
        for(String x :tokens){
            if(x == "+"){
                int a = s.peek();
                s.pop();
                int b = s.peek();
                s.pop();
                s.push(a+b);
            }
            else if(x == "*"){
                int a = s.peek();
                s.pop();
                int b = s.peek();
                s.pop();
                s.push(a*b);
            }
            else if(x == "-"){
                int a = s.peek();
                s.pop();
                int b = s.peek();
                s.pop();
                s.push(b-a);
            }
            else if(x == "/"){
                int a = s.peek();
                s.pop();
                int b = s.peek();
                s.pop();
                s.push(b/a);
            }else {
                s.push(Integer.valueOf(x));
            }
        }
        return s.peek();
    }
    public static void main(String[] args) {
        String [] tokens= {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(evalRPN(tokens));

    }
}
