import java.util.*;
public class main {

    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your grouping: ");
        String grp= sc.nextLine();
        LStack ls = new LStack();
        for (int i=0; i<grp.length(); i++){
            String cur = String.valueOf(grp.charAt(i));
            //it says to make a stack of strings?
            if (cur.equals("(") || cur.equals("[")){
                ls.push(cur);
            }
            String top = (String) ls.topValue();
            if (cur.equals(")") && top.equals("(")){
                    ls.pop();
                }
            if (cur.equals("]") && top.equals("[")){
                ls.pop();
            }
        }
        System.out.println("This grouping is: "+ ls.isEmpty());
    }
}
