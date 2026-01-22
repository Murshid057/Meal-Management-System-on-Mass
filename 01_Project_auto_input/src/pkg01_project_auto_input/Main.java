/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg01_project_auto_input;

import java.util.*;

interface Meal{
   double calculateCost();
   void display_info();
}

//----------------------------StandardMeal---------------------------
class StandardMeal implements Meal{
    String name;
    double base_price;
    
    StandardMeal(String name,double base_price){
        this.name = name;
        this.base_price = base_price;
    }
    
    @Override
    public double calculateCost(){
        double price = base_price *1.2;
        return price;
    }
    
    @Override
    public void display_info(){
        System.out.println("Name is: " + name);
        System.out.println("Total Price is: " + calculateCost());
        System.out.println();
    }
}

//------------------------------ComboMela---------------------------
class ComboMeal implements Meal{
    String name;
    double base_price;
    
    ComboMeal(String name, double base_price){
        this.name = name;
        this.base_price = base_price;
    }
    
    @Override
    public double calculateCost(){
        double price = base_price * 2.5;
        return price;
    }
    
    @Override
    public void display_info(){
        System.out.println("Name is: " + name);
        System.out.println("Total Price is: " + calculateCost());
        System.out.println();
    }
}

//-------------------------------DiscountMeal----------------------------
class DiscountMeal implements Meal{
    String name;
    double base_price;
    double discountPercentage;
    
    DiscountMeal(String name, double base_price, double discountPercentage){
        this.name = name;
        this.base_price = base_price;
        this.discountPercentage = discountPercentage;
    }
    
    @Override
    public double calculateCost(){
        double price = (base_price-base_price*discountPercentage);
        return price;
    }
    
    @Override
    public void display_info(){
        System.out.println("Name is: " + name);
        System.out.println("Total price is: " + calculateCost());
        System.out.println();
    }
}

//-------------------------------Meal Manager---------------------------
class MealManager{
    ArrayList<Meal> meal = new ArrayList<>();
    
    //Add new Meal;
    void add_meal(Meal m){
        meal.add(m);
        System.out.println("Mill add successfull");
    }
    
    //Remove meal;
    void del_meal(int per){
        if(per >= 0 && per<meal.size()){
            meal.remove(per);
            System.out.println("Mela remove Successful");
        }
        else{
            System.out.println("Invalid meal index");
        }
    
    }
    
    //Display ;
    void display(){
        if(meal.isEmpty()){
            System.out.println("Meal no aviable.");
            return;
        }
        for(Meal m : meal){
            m.display_info();
            System.out.println();
        }
    }
    
    //Total Revenue;
    double total_revenue(){
        double sum =0;
        for(Meal m : meal){
            sum += m.calculateCost();
        }
        return sum;
    }
}
public class Main {

    public static void main(String[] args) {
       
        MealManager m = new MealManager();
        
        Meal m1 = new StandardMeal("Naim", 5600);
        Meal m2 = new StandardMeal("Murshid", 4500);
        Meal m3 = new ComboMeal("Mizanur", 3500);
        Meal m4 = new ComboMeal("Oli", 4000);
        Meal m5 = new DiscountMeal("Murshid",5600,0.25);
        
        m.add_meal(m1);
        m.add_meal(m2);
        m.add_meal(m3);
        m.add_meal(m4);
        m.add_meal(m5);
        
        m.display();
        m.del_meal(2);
        
        System.out.println("Total Revenue: " + m.total_revenue());
    }
    
}
