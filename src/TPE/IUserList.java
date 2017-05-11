package TPE;

import java.util.ArrayList;

public interface IUserList {
	
	public void altaUsuarios(ArrayList<User> users);
	
	public void searchUsers(String pathABuscar);
	
	public void saveResult(User user, int size, long result);
}
