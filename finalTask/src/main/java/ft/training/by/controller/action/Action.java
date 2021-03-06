package ft.training.by.controller.action;

import ft.training.by.bean.User;
import ft.training.by.bean.enums.Role;
import ft.training.by.service.interfaces.ServiceFactory;
import ft.training.by.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class Action {
    private Set<Role> allowedRoles = new HashSet<>();
    private User authorizedUser;
    private String name;

    protected ServiceFactory factory;

    public void setFactory(ServiceFactory factory) {
        this.factory = factory;
    }

    public Set<Role> getAllowedRoles() {
        return allowedRoles;
    }

    public void setAllowedRoles(Set<Role> allowedRoles) {
        this.allowedRoles = allowedRoles;
    }

    public User getAuthorizedUser() {
        return authorizedUser;
    }

    public void setAuthorizedUser(User authorizedUser) {
        this.authorizedUser = authorizedUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract Forward exec(HttpServletRequest request, HttpServletResponse response) throws ServiceException;

    public static class Forward implements Serializable {
        private String forward;
        private boolean redirect;
        private Map<String, Object> attributes = new HashMap<>();

        public Forward(String forward, boolean redirect) {
            this.forward = forward;
            this.redirect = redirect;
        }

        public Forward(String forward) {
            this(forward, true);
        }

        public String getForward() {
            return forward;
        }

        public void setForward(String forward) {
            this.forward = forward;
        }

        public boolean isRedirect() {
            return redirect;
        }

        public void setRedirect(boolean redirect) {
            this.redirect = redirect;
        }

        public Map<String, Object> getAttributes() {
            return attributes;
        }
    }
}
