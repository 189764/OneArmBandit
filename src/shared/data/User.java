package shared.data;
import shared.data.userExceptions.OutOfRangeStakeException;;


public class User implements Comparable<User> {

	private String login;
	private String password;
	private Integer points;
	private boolean isAdmin;
	private int stake;
	
	public User (String login, String password, Integer points, boolean isAdmin ) {
	  this.login = login;
	  this.password = password;
	  this.points = points;
	  this.isAdmin = isAdmin; 
	  this.stake = 1;
	}
	
	public int getStake() {
		return stake;
	}

	public void setStake(int stake) {
		this.stake = stake;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}


	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getPoints() {
		return points;
	}
	public void setPoints(Integer points) {
		this.points = points;
	}
	public boolean getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (isAdmin ? 1231 : 1237);
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + points;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (isAdmin != other.isAdmin)
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (points != other.points)
			return false;
		return true;
	}
	
	/**
	 * It sorts by points.
	 */
	@Override
	public int compareTo(User o) {
		int flag = points.compareTo(o.getPoints());
		
		
		return flag;
	
	
	}
	
	public void increaseStake() throws OutOfRangeStakeException {
		if(stake == 20) {
		throw new OutOfRangeStakeException();
		} else {
		stake += 1;
		}
		
	}
	
	public void decreaseStake() throws OutOfRangeStakeException {
		if(stake == 1) {
			throw new OutOfRangeStakeException();
		} else {
		stake -= 1;
		}
		
	}

	public void addPoints(int prize) {
		points += prize;
		
	}


	
	
	
	
}
