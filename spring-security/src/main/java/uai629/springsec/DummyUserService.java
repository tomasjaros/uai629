package uai629.springsec;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class DummyUserService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if ("test-a".equals(username)) {
            return new TestUser(username, "abrakadabra");
        }
        throw new UsernameNotFoundException("Username '" + username + "' was not found.");
    }

}
