package core.loginWithGoogle;

public class loginWithGoogle {
	public void loginGoogle(String email,String password){
		
		if(email.isEmpty() && password.isEmpty()) {
			System.out.println("Formunuzda eksik yerler var.");
			return;
		}
		
		System.out.println("Google adresinizle giris yaptiniz.");
		
	}
}
