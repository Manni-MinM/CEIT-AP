// BWOTSHECHB

import java.util.Date ;

/**
 * Main class
 *
 * @author Manni Moghimi
 * @version v1.0
 */
public class Main {
	public static void main(String[] args) {
		Inventory inventory = new Inventory() ;

		Product carrot = new Product("Carrot" , "Vegetables" , 5 , 20f , new Date(2020 , 3 , 15) , new Date(2021 , 3 , 15)) ; //10
		Product apple = new Product("Apple" , "Fruits" , 10 , 50f , new Date(2020 , 4 , 1) , new Date(2020 , 8 , 1)) ; //20
		Product eggs12x = new Product("12xEggs" , "Egg" , 100 , 40f , new Date(2020 , 1 , 1) , new Date(2020 , 6 , 1)) ; //50
		Product oats = new Product("Oats" , "Grains" , 70 , 100f , new Date(2020 , 6 , 1) , new Date(2021 , 1 , 1)) ; //45
		Product salmon = new Product("Salmon" , "Seafood" , 150 , 250f , new Date(2020 , 1 , 1) , new Date(2020 , 2 , 1)) ; //5
		Product stake = new Product("Stake" , "Meat" , 800 , 1000f , new Date(2020 , 3 , 1) , new Date(2020 , 9 , 1)) ; //5
		Product milk = new Product("Milk" , "Dairy" , 100 , 20f , new Date(2020 , 1 , 10) , new Date(2020 , 1 , 25)) ; //20
		Product cheese = new Product("Cheese" , "Dairy" , 150 , 10f , new Date(2020 , 2 , 1) , new Date(2020 , 3 , 15)) ; //50

		inventory.stock(carrot , 10) ;
		inventory.stock(apple , 20) ;
		inventory.stock(eggs12x , 50) ;
		inventory.stock(oats , 45) ;
		inventory.stock(salmon , 5) ;
		inventory.stock(stake , 5) ;
		inventory.stock(milk , 20) ;
		inventory.stock(cheese , 50) ;

		
	}
}

