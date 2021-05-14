package business.concretes;

import java.util.List;
import business.abstracts.UserService;
import core.logger.LoggerManager;
import dataAccess.abstracts.UserDao;
import entities.concretes.User;

public class UserManager implements UserService{
	
	private UserDao userDao;
	private LoggerManager loggerManager;
	
	public UserManager(UserDao userDao, LoggerManager loggerManager) {
		super();
		this.userDao = userDao;
		this.loggerManager = loggerManager;
	}
	


	@Override
	public void register(User user) {
		boolean email_isSuccess = validationEmail(user);
		boolean pass_isSuccess = validationPassword(user);
		boolean name_isSuccess = checkName(user);
		boolean checkEmail = checkEmail(user);

		if(pass_isSuccess == false || email_isSuccess == false || name_isSuccess == false || checkEmail == false)
		{
			return;
		}
		
		System.out.println("Email adresinize dogrulama maili gonderildi.Onayladiginizda bu profil acilacaktir.");
		
		try
		{
		    Thread.sleep(1000);
		}
		catch(InterruptedException ex){}
		
		System.out.println("Adresinizi dogruladiniz.Siteye yonlendiriliyorsunuz....");
		
		try
		{
		    Thread.sleep(2000);
		}
		catch(InterruptedException ex){}
		
		userDao.register(user);
		this.loggerManager.LogToDatabase(user.getEmail());
	}
	
	public void login(User user) {

		this.userDao.login(user);
		this.loggerManager.LogToDatabase(user.getEmail());

	}
	
	@Override
	public List<User> getAll() {
		return userDao.getAll();
	}
	
//-----------------------------Is Kodlari--------------------------------	
	public static boolean validationPassword(User user)
	{
		String password = user.getPassword();
		String regex = "^(?=.*[0-9])(?=.*[a-zA-Z]).{8,20}$";
		boolean is_Success = password.matches(regex);
        
		if(is_Success == false) {
			System.out.println("Þifre 8-20 karakter arasýnda olmalý ve en az 1 harf ve 1 rakam icermeli.");
			return false;
		}
		else {
			return true;
		}
		
	}
	
	public static boolean validationEmail(User user)
	{
		String email = user.getEmail();
		String regex = "^([\\w-\\.]+){1,64}@([\\w&&[^_]]+){2,255}.[a-z]{2,}$";
		boolean is_Success = email.matches(regex);
		if(is_Success == false) {
			System.out.println("Boyle bir email adresi mumkun degilidir.");
			return false;
		}
		else {
			return true;
		}
	}
	
	public static boolean checkName(User user)
	{
		String firstName = user.getFirstName();
		String lastName = user.getLastName();
		if(firstName.length() < 3 || lastName.length() < 2)
		{
			System.out.println("Ad veya soyad bos olamaz...");
			return false;
		}
		else {
			return true;
		}
	}
	
	public static boolean checkEmail(User user)
	{
		if(user.getEmail() == "meteakcan@gmail.com")
		{
			System.out.println("Bu email adresi zaten kullanilmaktadir.Sifrenizi unuttuysaniz buraya tiklayin...");
			return false;
		}
		else {
			return true;
		}
	}
}
