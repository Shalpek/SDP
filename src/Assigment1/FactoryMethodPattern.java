package Assigment1;

public class FactoryMethodPattern {
    // Интерфейс Transport с методом deliver()
    interface Transport {
        void deliver();
    }

    // Класс Truck для доставки по суше
    static class Truck implements Transport {
        @Override
        public void deliver() {
            System.out.println("Доставка по суше с использованием грузовика.");
        }
    }

    // Класс Ship для доставки по воде
    static class Ship implements Transport {
        @Override
        public void deliver() {
            System.out.println("Доставка по воде с использованием корабля.");
        }
    }

    // Класс Drone для доставки по воздуху
    static class Drone implements Transport {
        @Override
        public void deliver() {
            System.out.println("Доставка по воздуху с использованием дрона.");
        }
    }

    // Фабрика для создания объектов транспорта
    abstract static class TransportFactory {
        abstract Transport createTransport(String type);

        public static TransportFactory getFactory() {
            return new DeliveryTransportFactory();
        }
    }

    // Конкретная реализация фабрики
    static class DeliveryTransportFactory extends TransportFactory {
        @Override
        Transport createTransport(String type) {
            return switch (type.toLowerCase()) {
                case "суша" -> new Truck();
                case "вода" -> new Ship();
                case "воздух" -> new Drone();
                default -> throw new IllegalArgumentException("Неизвестный тип доставки: " + type);
            };
        }
    }

    // Тестирование работы фабрики и транспорта
    public static class Main {
        public static void main(String[] args) {
            TransportFactory factory = TransportFactory.getFactory();

            // Тест доставки по суше
            Transport landTransport = factory.createTransport("суша");
            landTransport.deliver();

            // Тест доставки по воде
            Transport waterTransport = factory.createTransport("вода");
            waterTransport.deliver();

            // Тест доставки по воздуху
            Transport airTransport = factory.createTransport("воздух");
            airTransport.deliver();

            Transport strangeTransport = factory.createTransport("asdasads");
            strangeTransport.deliver();
        }
    }

}
