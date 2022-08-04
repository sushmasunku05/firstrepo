package in.synxt.secureinventory.utils;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import in.synxt.secureinventory.entities.Accesses;
import in.synxt.secureinventory.entities.InventoryUsers;
import in.synxt.secureinventory.service.InventoryUserService;
@Service
public class InventoryUserDetailService implements UserDetailsService{

	@Autowired
	private InventoryUserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		InventoryUsers user=userService.loadUsername(username);
		
		if(user==null) {
			throw new UsernameNotFoundException(username+"is not present in the system");
		}
		
		UserDetails secureUser=new UserDetails() {

			@Override
			public Collection<? extends GrantedAuthority> getAuthorities() {
				List<Accesses> access=user.getAccess();
				List<GrantedAuthority> authorities=access.stream().map(e->new SimpleGrantedAuthority(e.getAccessName())).collect(Collectors.toList());
				return authorities;
			}

			@Override
			public String getPassword() {
				// TODO Auto-generated method stub
				return user.getPassword();
			}

			@Override
			public String getUsername() {
				// TODO Auto-generated method stub
				return user.getEmailId();
			}

			@Override
			public boolean isAccountNonExpired() {
				// TODO Auto-generated method stub
				return true;
			}

			@Override
			public boolean isAccountNonLocked() {
				// TODO Auto-generated method stub
				return true;
			}

			@Override
			public boolean isCredentialsNonExpired() {
				// TODO Auto-generated method stub
				return true;
			}

			@Override
			public boolean isEnabled() {
				// TODO Auto-generated method stub
				return true;
			}
			
		};
		
		return secureUser;
	}

}
