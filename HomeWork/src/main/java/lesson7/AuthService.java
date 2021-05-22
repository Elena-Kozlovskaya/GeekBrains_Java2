package lesson7;

/**
 * Сервис авторизации
 */
public interface AuthService {
    /**
     * Запустить сервис
     */
    void start();

    /**
     * Остановить сервис
     */
    void stop();

    /**
     * Получить никнейм
     */
    String getNickByLoginAndPass(String login, String pass);
}
