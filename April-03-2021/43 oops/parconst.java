import java.io.*;
import java.util.*;

public class Main {
    
    public static class Person{
        String name;
        int age;
        
        // default constructor
        Person(){
            // System.out.println("in const...");
        }
        
        // parameter... constructor
        Person(String name, int age){
            this.name = name;
            this.age = age;
        }
        
        public void sayHii(){
            System.out.println(name+" " + age +" says hii ");
        }
    }
    
    public static void main(String[] args) {
        Person p1 = new Person();
        p1.name = "A";
        p1.age = 10;
        
        p1.sayHii();
        
        Person p2 = new Person("B", 20);
        // p2.name = "B";
        // p2.age = 20;
        p2.sayHii();
    }
}
