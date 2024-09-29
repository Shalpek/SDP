package Assigment1;

public class PrototypePattern {
    // Класс Product, реализующий интерфейс Cloneable
    static class Product implements Cloneable {
        private String name;
        private double price;
        private String category;

        public Product(String name, double price, String category) {
            this.name = name;
            this.price = price;
            this.category = category;
        }

        // Геттеры и сеттеры
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        // Метод для клонирования объекта
        @Override
        protected Product clone() {
            try {
                return (Product) super.clone();
            }
            catch (CloneNotSupportedException e) {
                throw new RuntimeException("Клонирование не поддерживается", e);
            }
        }

        @Override
        public String toString() {
            return "Product{" +
                    "name='" + name + '\'' +
                    ", price=" + price +
                    ", category='" + category + '\'' +
                    '}';
        }
    }

    // Тестирование работы паттерна Прототип
    public static class Main {
        public static void main(String[] args) {
            // Создание оригинального продукта
            Product originalProduct = new Product("Laptop", 1500.0, "Electronics");

            // Клонирование продукта
            Product clonedProduct = originalProduct.clone();

            // Вывод оригинального и клонированного продукта
            System.out.println("Оригинальный продукт: " + originalProduct);
            System.out.println("Клонированный продукт: " + clonedProduct);

            // Изменение цены в клонированном продукте
            clonedProduct.setPrice(1200.0);

            // Вывод после изменения цены в клоне
            System.out.println("\nПосле изменения цены в клоне:");
            System.out.println("Оригинальный продукт: " + originalProduct);
            System.out.println("Клонированный продукт: " + clonedProduct);
        }
    }

}
