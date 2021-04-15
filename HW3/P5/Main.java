// BWOTSHECHB

import org.json.simple.* ;
import com.fasterxml.jackson.core.* ;
import com.fasterxml.jackson.databind.* ;
import com.fasterxml.jackson.annotation.* ;

import java.util.Scanner ;

/**
 * Main class
 *
 * @author Manni Moghimi
 * @version v1.0
 */
public class Main {
	public static void main(String[] args) {
		Basket basket = new Basket() ;
		Inventory inventory = new Inventory() ;
		Scanner input = new Scanner(System.in) ;
//		ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT) ;

		Product carrot = new Product("Carrot" , "Vegetables" , 5 , 20f , "15-03-2020" , "15-03-2021") ;
		Product apple = new Product("Apple" , "Fruits" , 10 , 50f , "01-04-2020" , "01-08-2020") ;
		Product eggs12x = new Product("12xEggs" , "Egg" , 100 , 40f , "01-01-2020" , "01-06-2020") ;
		Product oats = new Product("Oats" , "Grains" , 70 , 100f , "01-06-2020" , "01-01-2021") ;
		Product salmon = new Product("Salmon" , "Seafood" , 150 , 250f , "01-01-2020" , "01-02-2020") ;
		Product stake = new Product("Stake" , "Meat" , 800 , 1000f , "01-03-2020" , "01-09-2020") ;
		Product milk = new Product("Milk" , "Dairy" , 100 , 20f , "10-01-2020" , "25-01-2020") ;
		Product cheese = new Product("Cheese" , "Dairy" , 150 , 10f , "01-02-2020" , "15-03-2020") ;

		inventory.stock(carrot , 10) ;
		inventory.stock(apple , 20) ;
		inventory.stock(eggs12x , 50) ;
		inventory.stock(oats , 45) ;
		inventory.stock(salmon , 5) ;
		inventory.stock(stake , 5) ;
		inventory.stock(milk , 20) ;
		inventory.stock(cheese , 50) ;

		prettyPrintJson(carrot) ;
		
	}
	public static void prettyPrintJson(Object object) {
		ObjectMapper mapper = new ObjectMapper() ;
		try {
			System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(object)) ;
		}
		catch (JsonProcessingException exception) {
			// Pass
		}
	}
}

