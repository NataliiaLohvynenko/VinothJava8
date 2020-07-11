package tasks;

public class polyndrom {

    public static void main(String[] args) {
        String s = "abcba";


        String revence ="";
        int length = s.length()-1;
        for (int i = length; i>=0; i--)
        {
            revence = revence+s.charAt(i);
        }
        System.out.println(revence + "  " + s);
        if(s.equals(revence)){
            System.out.println("yes");
        }else{
            System.out.println("no");
        }
    }
}
