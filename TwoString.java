import java.util.*;

public class TwoString {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int q=sc.nextInt();
        while(q>0){
            q--;
            String str1=sc.next();
            String dummy=str1.toUpperCase();
            String str2=sc.next();
           boolean flag=true;
            if(flag){
                for (int i = 0; i < str2.length(); i++) {
                   // if(str1.charAt(i)==str2.charAt(i))continue;
                    String helper=""+str1.charAt(i);
                    helper=helper.toUpperCase();
                    //System.out.println("Helper  : "+helper);
                    if(helper.charAt(0)==str2.charAt(i))continue;
                    if(str1.charAt(i)<('z'+1)) {
                        flag=false;
                        for (int j = i+1; j < str1.length(); j++) {
                            String helper1=""+str1.charAt(i);
                            helper=helper1.toUpperCase();
                            if(helper1.charAt(0)==str2.charAt(i)){flag=true;break;};
                        }

                    }
                    flag=false; break;
                }
                if(flag) System.out.println("YES");
                else System.out.println("NO");

            }
            else{
                System.out.println("NO");
            }


        }
    }

}