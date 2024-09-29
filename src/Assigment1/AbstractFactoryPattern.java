package Assigment1;

public class AbstractFactoryPattern {
    // Интерфейс Button
    interface Button {
        void render();
    }

    // Интерфейс Window
    interface Window {
        void render();
    }

    // Реализация кнопки для Windows
    static class WindowsButton implements Button {
        @Override
        public void render() {
            System.out.println("Отрисовка кнопки для Windows.");
        }
    }

    // Реализация окна для Windows
    static class WindowsWindow implements Window {
        @Override
        public void render() {
            System.out.println("Отрисовка окна для Windows.");
        }
    }

    // Реализация кнопки для Mac
    static class MacButton implements Button {
        @Override
        public void render() {
            System.out.println("Отрисовка кнопки для Mac.");
        }
    }

    // Реализация окна для Mac
    static class MacWindow implements Window {
        @Override
        public void render() {
            System.out.println("Отрисовка окна для Mac.");
        }
    }

    // Абстрактная фабрика для создания связанных продуктов
    interface GUIFactory {
        Button createButton();
        Window createWindow();
    }

    // Фабрика для Windows
    static class WindowsFactory implements GUIFactory {
        @Override
        public Button createButton() {
            return new WindowsButton();
        }

        @Override
        public Window createWindow() {
            return new WindowsWindow();
        }
    }

    // Фабрика для Mac
    static class MacFactory implements GUIFactory {
        @Override
        public Button createButton() {
            return new MacButton();
        }

        @Override
        public Window createWindow() {
            return new MacWindow();
        }
    }

    // Клиентский код, использующий фабрику
    public static class Main {
        public static void main(String[] args) {
            // Выбор платформы (например, Windows)
            GUIFactory factory = getFactoryByPlatform("Windows");

            // Создание кнопки и окна с использованием абстрактной фабрики
            Button button = factory.createButton();
            Window window = factory.createWindow();

            // Отрисовка интерфейса
            button.render();
            window.render();
        }

        // Метод для получения фабрики по выбранной платформе
        public static GUIFactory getFactoryByPlatform(String platform) {
            if (platform.equalsIgnoreCase("Windows")) {
                return new WindowsFactory();
            }
            else if (platform.equalsIgnoreCase("Mac")) {
                return new MacFactory();
            }
            else {
                throw new IllegalArgumentException("Неизвестная платформа: " + platform);
            }
        }
    }

}
