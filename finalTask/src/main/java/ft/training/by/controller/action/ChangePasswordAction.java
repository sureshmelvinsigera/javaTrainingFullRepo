package ft.training.by.controller.action;

import ft.training.by.bean.User;
import ft.training.by.service.interfaces.UserService;
import ft.training.by.service.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

public class ChangePasswordAction extends AuthorizedUserAction {
    private static final Logger LOGGER = LogManager.getLogger();

    private static final String PARAM_NAME_OLD_PASSWORD = "old_password";
    private static final String PARAM_NAME_NEW_PASSWORD = "new_password";
    private static final String PARAM_NAME_NEW_PASSWORD_AGAIN = "new_password_again";

    @Override
    public Forward exec(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        String oldPassword = request.getParameter(PARAM_NAME_OLD_PASSWORD);
        String newPassword = request.getParameter(PARAM_NAME_NEW_PASSWORD);
        String newPasswordAgain = request.getParameter(PARAM_NAME_NEW_PASSWORD_AGAIN);
        if (oldPassword != null && newPassword != null && newPasswordAgain != null) {
            User currentUser = (User) request.getSession().getAttribute("authorizedUser");
            if (!Arrays.equals(currentUser.getPassword(), oldPassword.toCharArray())) {
                request.setAttribute("passwordMessage", "Old password was entered incorrectly");
                return null;
            }
            if (!newPassword.equals(newPasswordAgain)) {
                request.setAttribute("passwordMessage", "New password was repeated incorrectly");
                return null;
            }
            if (oldPassword.equals(newPassword)) {
                request.setAttribute("passwordMessage", "You've entered the same password");
                return null;
            }
            currentUser.setPassword(newPassword.toCharArray());
            UserService userService = factory.createService(UserService.class);
            userService.update(currentUser);
            return new Forward("/logout.html");
        }
        return null;
    }
}
