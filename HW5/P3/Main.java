// BWOTSHEWCHB

/**
 * Main Class
 *
 * @author Manni Moghimi
 * @version v1.0
 */
public class Main {
	// Methods
	public static void main(String[] args) {
		Club ManchesterUnited = new Club() ;
		Club Chelsea = new Club() ;
		
		Follower manni = new Follower("Manni" , "Moghimi") ;
		Follower jaber = new Follower("Jaber" , "Jaberkhani") ;
		Follower bagher = new Follower("Bagher"  , "Bagherzade") ;
	
		manni.subscribe(ManchesterUnited.playerNews()) ;
		manni.subscribe(Chelsea.clubNews()) ;

		jaber.subscribe(ManchesterUnited.clubNews()) ;
		jaber.subscribe(Chelsea.playerNews()) ;

		bagher.subscribe(ManchesterUnited.matchdayNews()) ;
		
		ManchesterUnited.addPlayer(new Player("Bruno" , "Fernandes" , "0001" , 26)) ;
		Chelsea.addPlayer(new Player("Kai" , "Havertz" , "0002" , 21)) ;
	
		ManchesterUnited.addMatch(new Match("Manchester United" , "Arsenal" , "1401/2/1")) ;
		Chelsea.addMatch(new Match("Liverpool" , "Chelsea" , "1401/2/2")) ;
		
		ManchesterUnited.addNews("Pedare Bashgah Fot Shod !" , "Random Context For Title Pedare Bashgah Fot Shod") ;	
	
		manni.unsubscribe(ManchesterUnited.playerNews()) ;
		jaber.subscribe(ManchesterUnited.clubNews()) ;
		jaber.subscribe(ManchesterUnited.playerNews()) ;
		ManchesterUnited.addPlayer(new Player("Juan" , "Mata" , "0003" , 33)) ;
		
		manni.subscribe(ManchesterUnited.playerNews()) ;
		ManchesterUnited.addPlayer(new Player("Edinson" , "Cavani" , "0004" , 34)) ;
	
		bagher.unsubscribe(ManchesterUnited.matchdayNews()) ;
		bagher.unsubscribe(ManchesterUnited.matchdayNews()) ;
		Chelsea.addMatch(new Match("Arsenal" , "Chelsea" , "1401/2/3")) ;
	}
}

