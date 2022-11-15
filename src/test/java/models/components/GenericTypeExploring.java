package models.components;

import java.lang.reflect.Constructor;

public class GenericTypeExploring {
    public <T extends  LoginPage>void login (Class<T>LoginPageClass){
        Class<?>[] parameters = new Class[]{};
try{
   Constructor<T> constructor =  LoginPageClass.getConstructor(parameters);
   T loginPageOpj =  constructor.newInstance();
loginPageOpj.Login();


}catch (Exception e){
    e.printStackTrace();
}
    }

    public static void main(String[] args) {
        new GenericTypeExploring().login(InternalLoginPage.class);
        new GenericTypeExploring().login(ExternalLoginPage.class);
    }
}
