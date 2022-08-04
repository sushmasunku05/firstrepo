package in.synxt.secureinventory.utils;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import in.synxt.secureinventory.entities.InventoryUsers;
import in.synxt.secureinventory.service.InventoryUserService;
@Service
public class DBAuthenticationProvider implements AuthenticationProvider{
	@Autowired
	private InventoryUserService userService;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username=authentication.getName();
		String password=authentication.getCredentials().toString();
		InventoryUsers user=userService.loadUsername(username);
		if(user==null) {
			throw new UsernameNotFoundException("User not found"); 
		}
		else if(password.equals(user.getPassword())) {
			List<GrantedAuthority> authorities=user.getAccess().stream().map(e->new SimpleGrantedAuthority(e.getAccessName())).collect(Collectors.toList());
			return new UsernamePasswordAuthenticationToken(username,password,authorities);
		}
		else {
			throw new UsernameNotFoundException("Username or Password are Invalid");
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return authentication.equals(UsernamePasswordAuthenticationToken.class)?true:false ;
	}

}
