package Lesson_3_add;

import java.io.Serializable;

 class Player implements Serializable {
     private String name;

     public Player(String name) {
         this.name = name;
     }

     void info(){
         System.out.println(name);
     }
 }
