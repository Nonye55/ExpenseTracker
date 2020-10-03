package com.shecodes.expense.Service;

import com.shecodes.expense.repository.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.shecodes.expense.model.ExpenseUser;



import org.springframework.stereotype.Service;

import static java.util.Collections.emptyList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	private UserRepository userRepository;

	public UserDetailsServiceImpl(UserRepository  userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		ExpenseUser expenseUser = userRepository.findByUsername(username);
		if (expenseUser == null) {
			throw new UsernameNotFoundException(username);
		}
		return new User(expenseUser.getUsername(), expenseUser.getPassword(), emptyList());
	}
}