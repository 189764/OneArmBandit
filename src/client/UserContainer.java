package client;

import java.util.ArrayList;
import java.util.List;

public class UserContainer {

	private List<User> listOfUsers = new ArrayList<User>( );
	
	public void addUser(User user) {
		listOfUsers.add( user );
	}
	
	public void deleteUser(User user) {
		listOfUsers.remove( user );
	}

	public User getUser(String login) {
		
	    for ( User tempUser : this.listOfUsers ) { 
	        if ( tempUser.equals(login) ) {
	              return tempUser; 
	              }
	    }
		return null;        
	}
}
	


