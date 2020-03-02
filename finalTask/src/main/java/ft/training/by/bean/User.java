package ft.training.by.bean;

import java.util.Arrays;
import java.util.Objects;

public class User {
    private int id;
    private String login;
    private char[] password;
    private Role role;
    private String surname;
    private String name;
    private String patronymic;

    public User() {
    }

    public User(int id) {
        this.id = id;
    }

    public User(int id, String login, char[] password, Role role,
                String surname, String name, String patronymic) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.role = role;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public char[] getPassword() {
        return password;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                login.equals(user.login) &&
                Arrays.equals(password, user.password) &&
                role == user.role &&
                surname.equals(user.surname) &&
                name.equals(user.name) &&
                patronymic.equals(user.patronymic);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, login, role, surname, name, patronymic);
        result = 31 * result + Arrays.hashCode(password);
        return result;
    }

    // переписать
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password=" + Arrays.toString(password) +
                ", role=" + role +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                '}';
    }
}
