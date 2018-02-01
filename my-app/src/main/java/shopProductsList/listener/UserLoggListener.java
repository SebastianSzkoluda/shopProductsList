package shopProductsList.listener;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;

public class UserLoggListener implements ApplicationListener<AuthenticationSuccessEvent> {

	@Autowired
	HttpSession httpSession;
	
	@Override
	public void onApplicationEvent(AuthenticationSuccessEvent e) {
		String loggedUsserName = e.getAuthentication().getName();
		System.out.println(loggedUsserName + " logged in");
	}

}
