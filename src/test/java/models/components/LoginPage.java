package models.components;

public abstract class LoginPage {
    public void Login() {
        System.out.println(username());

        System.out.println(password());

        System.out.println(loginBtn());

    }

    public void verifyLoginSuccess() {
        System.out.println("Verify Dashboard display");
    }

    protected abstract String username();

    protected abstract String password();

    protected abstract String loginBtn();

}
