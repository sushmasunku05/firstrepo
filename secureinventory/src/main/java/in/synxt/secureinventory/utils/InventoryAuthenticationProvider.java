package in.synxt.secureinventory.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

public class InventoryAuthenticationProvider implements AuthenticationProvider{

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username=authentication.getName();
		String password=authentication.getCredentials().toString();
		if(!username.equals(password)) {
			List<GrantedAuthority> authorities=new ArrayList<>();
			authorities.add(new SimpleGrantedAuthority("ADMIN"));
			return new UsernamePasswordAuthenticationToken(authentication,password,authorities);
		}
		throw new UsernameNotFoundException("Username or password cannot be same");
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return authentication.equals(UsernamePasswordAuthenticationToken.class)?true:false;
	}

}
