package recursion;

public class Print1ToN {

    private static void reverseCounter(int N){
        if(N==0) return;
        System.out.println(N);
        reverseCounter(N-1);
    }

    private static void counter(int N){
        if(N==0)return;
        counter(N-1);
        System.out.println(N);
    }

    public static void main(String[] args) {
        int N = 10;
        counter(N);
        reverseCounter(N);
    }

}
