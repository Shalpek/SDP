package Assigment1;

public class SingletonPattern {
    // Класс Logger с реализацией паттерна "Одиночка"
    static class Logger {
        // Единственный экземпляр Logger
        private static Logger instance;

        // Приватный конструктор для предотвращения создания объектов извне
        private Logger() {}

        // Метод для получения единственного экземпляра Logger
        public static Logger getInstance() {
            if (instance == null) {
                instance = new Logger();
            }
            return instance;
        }

        // Метод для логирования сообщений
        public void log(String message) {
            System.out.println("Лог: " + message);
        }
    }

    // Тестирование системы логирования
    public static class Main {
        public static void main(String[] args) {
            // Получение единственного экземпляра Logger
            Logger logger1 = Logger.getInstance();
            Logger logger2 = Logger.getInstance();

            // Логирование сообщений
            logger1.log("Сообщение от первого объекта.");
            logger2.log("Сообщение от второго объекта.");

            // Проверка того, что оба объекта logger1 и logger2 указывают на один и тот же экземпляр
            System.out.println("logger1 и logger2 это один и тот же объект: " + (logger1 == logger2));
        }
    }

}
