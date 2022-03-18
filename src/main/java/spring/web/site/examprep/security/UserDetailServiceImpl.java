package spring.web.site.examprep.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import spring.web.site.examprep.dao.UserDAO;
import spring.web.site.examprep.entity.User;

@Service("userDetailsServiceImpl")
public class UserDetailServiceImpl implements UserDetailsService {
    private final UserDAO userDAO;

    @Autowired
    public UserDetailServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userDAO.findUserByLogin(username).orElseThrow(
                () ->new UsernameNotFoundException("User does not exist."));

        System.out.println(user);
        return SecurityUser.fromUser(user);
    }
}
