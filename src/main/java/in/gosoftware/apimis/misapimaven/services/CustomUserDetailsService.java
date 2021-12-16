package in.gosoftware.apimis.misapimaven.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import in.gosoftware.apimis.misapimaven.model.Role;
import in.gosoftware.apimis.misapimaven.model.User;
import in.gosoftware.apimis.misapimaven.model.UserGroup;
import in.gosoftware.apimis.misapimaven.repository.CompanyRepo;
import in.gosoftware.apimis.misapimaven.repository.RoleRepository;
import in.gosoftware.apimis.misapimaven.repository.UserGroupRepository;
import in.gosoftware.apimis.misapimaven.repository.UserRepository;




@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserGroupRepository userGroupRepository;
   

    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    public void deleteUserByEmail(String email) {
        userRepository.deleteByEmail(email);
    }
    public boolean findUserByPin(String pin) {
        return userRepository.existsByPin(pin);
    }
    public User findUserBycmpid(String cmpid) {
        return userRepository.findByCid(cmpid);
    }
	public User update(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		 return userRepository.save(user);
	}
    public void saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setEnabled(true);
       
        userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(email);
        if(user != null) {
            List<GrantedAuthority> authorities = getUserAuthority(user.getUserGroups());
            return buildUserForAuthentication(user, authorities);
        } else {
            throw new UsernameNotFoundException("username not found");
        }
    }

    private List<GrantedAuthority> getUserAuthority(Set<UserGroup> userGroups) {
        Set<GrantedAuthority> roles = new HashSet<>();
        userGroups.forEach((role) -> {
            roles.add(new SimpleGrantedAuthority(role.getName()));
        });

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>(roles);
        return grantedAuthorities;
    }

    private UserDetails buildUserForAuthentication(User user, List<GrantedAuthority> authorities) {
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
    }
}