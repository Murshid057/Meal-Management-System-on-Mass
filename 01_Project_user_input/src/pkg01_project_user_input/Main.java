/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg01_project_user_input;
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
        double price = (base_price-base_price)*discountPercentage;
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

//---------------------------------Main class---------------------------------
public class Main {

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        MealManager meal = new MealManager();
        
        while(true){
            System.out.println();
            System.out.print("Enter the meal number: ");
            int number = input.nextInt();
            
            if(number == 0)
                System.out.println("Work Stop");
            
            switch(number){
                case 1: {
                    System.out.print("Mela name is: ");
                    String name = input.nextLine();
                    input.nextLine();
                    
                    System.out.print("Enter base price is: ");
                    double price = input.nextDouble();
                    
                    Meal m1 = new StandardMeal(name,price);
                    meal.add_meal(m1);
                }
                
                case 2: {
                    System.out.print("Mela name is: ");
                    String name = input.nextLine();
                    input.nextLine();
                    
                    System.out.print("Enter base price is: ");
                    double price = input.nextDouble();
                    
                    Meal m2 = new ComboMeal(name,price);
                    meal.add_meal(m2);
                }
                
                case 3: {
                    System.out.print("Mela name is: ");
                    String name = input.nextLine();
                    input.nextLine();
                    
                    System.out.print("Enter base price is: ");
                    double price = input.nextDouble();
                    System.out.print("Enter DescoutnPercentage: ");
                    double des = input.nextDouble();
                    
                    Meal m3 = new DiscountMeal(name,price,des);
                    meal.add_meal(m3);
                }
                
                case 4: {
                    meal.display();
                    break;
                }
                
                case 5: {
                    System.out.print("Remove meal: ");
                    int remove = input.nextInt();
                    meal.del_meal(remove);
                    break;
                }
                
                case 6: {
                    System.out.println("Total Revenue: " + meal.total_revenue());
                    break;
                }
                
                case 0: {
                    System.out.println();
                    input.close();
                    return;
                }
                default:
                    System.out.println("Invalid meal Meal");
            }
        }
    }
    
}
