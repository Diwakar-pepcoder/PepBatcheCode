public class Main{

    public static void main(String[]a){
        StringBuilder sb = new StringBuilder();
        
        sb.append("abc");
        System.out.println(sb);
        
        System.out.println(sb.length());
        
        char ch = sb.charAt(1);
        System.out.println(ch);
        
        sb.setCharAt(1, 'z');
        System.out.println(sb);
        
        sb.insert(1, 'b');
        System.out.println(sb);
        
        sb.deleteCharAt(2);
        System.out.println(sb);

        // character

        char ch = 'A';
        char ch1 = 'a';
        
        int diff = ch1 - ch;
        System.out.println(diff);
        
        char ans = (char)(65);
        System.out.println(ans);
    }
    
}