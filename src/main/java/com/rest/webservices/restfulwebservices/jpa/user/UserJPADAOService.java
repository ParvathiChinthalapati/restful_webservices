package com.rest.webservices.restfulwebservices.jpa.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;


@Component
public class UserJPADAOService {
	private static List<User> users = new ArrayList<>();
	private static int userCount = 0;
	
	static {
		users.add(new User(++userCount,"Parvathi",LocalDate.now().minusYears(34)));
		users.add(new User(++userCount,"Surya",LocalDate.now().minusYears(36)));
		users.add(new User(++userCount,"Eshaan",LocalDate.now().minusYears(6)));
	}
public List<User> getUsers(){
	return users;
}
public User getUserById(Integer id) {
	// TODO Auto-generated method stub
	return users.stream().filter(usr -> usr.getId().equals(id)).findAny().orElse(null);
}
public User saveUser(User user) {
	// TODO Auto-generated method stub
	user.setId(++userCount);
	users.add(user);
	return user;
}
public void deleteUser(Integer id) {
	// TODO Auto-generated method stub
	java.util.function.Predicate<? super User> predicate = user -> user.getId().equals(id);
	users.removeIf(predicate);
}
}
