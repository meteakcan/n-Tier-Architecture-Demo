import business.abstracts.UserService;
import business.concretes.UserManager;
import core.logger.LoggerManager;
import core.loginWithGoogle.loginWithGoogle;
import dataAccess.concretes.DataAccessUserDao;
import entities.concretes.User;

public class consoleUI {

	public static void main(String[] args) {
		UserService userService = new UserManager(new DataAccessUserDao(),new LoggerManager());
		loginWithGoogle google = new loginWithGoogle();		
		
		User user1 = new User(1,"Mete","Akcan","meteakcan@gmail.com","123456789A");
		userService.register(user1);
		
		userService.login(user1);
		
		google.loginGoogle("meteakcan@gmail.com","123456789");
	}

}
