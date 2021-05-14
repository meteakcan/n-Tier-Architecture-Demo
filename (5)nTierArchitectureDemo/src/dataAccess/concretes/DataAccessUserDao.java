package dataAccess.concretes;

import java.util.List;

import dataAccess.abstracts.UserDao;
import entities.concretes.User;

public class DataAccessUserDao implements UserDao{

	@Override
	public void register(User user) {
		System.out.println("Basariyla uye oldunuz.Sitemize hosgeldiniz.");
		}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAccount(User user) {
		
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void login(User user) {
		System.out.println("Basariyla giris yapildi.");
	}

}
