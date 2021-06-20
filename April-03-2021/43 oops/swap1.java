import java.io.*;
import java.util.*;

public class Main {
    
    public static class Person{
        String name;
        int age;
        
        public void sayHii(){
            System.out.println(name+" " + age +" says hii ");
        }
    }
    
    public static void main(String[] args) {
        Person p1 = new Person();
        p1.name = "A";
        p1.age = 10;
        
        // p1.sayHii();
        
        Person p2 = new Person();
        p2.name = "B";
        p2.age = 20;
        // p2.sayHii();
        
        swap(p1,p2);
        p1.sayHii();
        p2.sayHii();
    }
    
    public static void swap(Person p1, Person p2){
        Person temp = p1;
        p1 = p2;
        p2 = temp;
    }
    
}






