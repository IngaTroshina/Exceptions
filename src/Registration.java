import exception.WrongLoginException;
import exception.WrongPasswordException;

import java.util.regex.Pattern;

public class Registration {
    public static boolean verification(
        String login,
        String password,
        String confirmPassword
    ) {
        try {
            if (!Pattern.matches("^[a-zA-Z0-9_]{1,20}$", login)) {
                throw new WrongLoginException("Неверный формат логина");
            }
            if (!Pattern.matches("^[a-zA-Z0-9_]{1,19}$", password)) {
                throw new WrongPasswordException("Неверный формат пароля");
            }
            if (!password.equals(confirmPassword)) {
                throw new WrongPasswordException("Пароли не совпадают");
            }
        } catch (WrongLoginException wrongLoginException){
            wrongLoginException.printStackTrace();
            return false;
        } catch (WrongPasswordException wrongPasswordException){
            wrongPasswordException.printStackTrace();
            return false;
        } finally {
            System.out.println("Проверка завершена");
        }
        return true;
    }
}
