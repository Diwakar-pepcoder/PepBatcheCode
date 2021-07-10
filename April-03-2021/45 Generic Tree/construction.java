import java.io.*;
import java.util.*;

public class Main {
	
	public static class Node {
	    int data;
	    ArrayList<Node> childs = new ArrayList<>();
	    Node(int d){
	        data = d;
	    }
	}
	
	public static class GenericTree{
	    
	    Node root = null;
	    
	    public void construct(int arr[]){
	        Stack<Node> st = new Stack<>();
	        
	        for(int val : arr){
	            
	            if(val == -1){
	                st.pop();
	            }else{
	                Node n = new Node(val);
	                if(st.size() == 0){
	                    root = n;
	                }else{
	                    Node parent = st.peek();
	                    parent.childs.add(n);
	                }
	                st.push(n);
	            }
	        }
	    }
	    
	    public void displayHelper(Node node){
	        StringBuilder ans = new StringBuilder();
	        ans.append(node.data+" -> ");
	        for(Node child: node.childs){
	            ans.append(child.data+" ");
	        }
	        ans.append(".");
	        System.out.println(ans);
	        
	        for(Node child: node.childs){
	            displayHelper(child);
	        }
	    }
	    
	    public void display(){
	        displayHelper(root);
	    }
	    
	}
	
	public static void main(String[] args) {
	    
	    int arr[] = new int[]{10, 20, -1, 30, 50, -1, 60, -1, -1, 40, -1, -1};
	    GenericTree gt =  new GenericTree();
	    gt.construct(arr);
	    gt.display();
	}
}