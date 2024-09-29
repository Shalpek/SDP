package Assigment1;

public class BuilderPattern {// Класс House, который описывает дом
    static class House {
        private final int numRooms;
        private final int numFloors;
        private final boolean hasPool;
        private final boolean hasGarage;

        // Приватный конструктор, доступный только через Builder
        private House(HouseBuilder builder) {
            this.numRooms = builder.numRooms;
            this.numFloors = builder.numFloors;
            this.hasPool = builder.hasPool;
            this.hasGarage = builder.hasGarage;
        }

        @Override
        public String toString() {
            return "House{" +
                    "numRooms=" + numRooms +
                    ", numFloors=" + numFloors +
                    ", hasPool=" + hasPool +
                    ", hasGarage=" + hasGarage +
                    '}';
        }

        // Вложенный статический класс HouseBuilder
        public static class HouseBuilder {
            private int numRooms;
            private int numFloors;
            private boolean hasPool;
            private boolean hasGarage;

            // Методы для настройки полей
            public HouseBuilder setNumRooms(int numRooms) {
                this.numRooms = numRooms;
                return this;
            }

            public HouseBuilder setNumFloors(int numFloors) {
                this.numFloors = numFloors;
                return this;
            }

            public HouseBuilder setHasPool(boolean hasPool) {
                this.hasPool = hasPool;
                return this;
            }

            public HouseBuilder setHasGarage(boolean hasGarage) {
                this.hasGarage = hasGarage;
                return this;
            }

            // Метод build() возвращает готовый объект House
            public House build() {
                return new House(this);
            }
        }
    }

    // Тестирование работы паттерна Строитель
    public static class Main {
        public static void main(String[] args) {
            // Создание дома с 3 комнатами, 2 этажами, с бассейном, но без гаража
            House house1 = new House.HouseBuilder()
                    .setNumRooms(3)
                    .setNumFloors(2)
                    .setHasPool(true)
                    .setHasGarage(false)
                    .build();

            // Вывод информации о доме
            System.out.println(house1);

            // Создание дома с 5 комнатами, 1 этажом, без бассейна, но с гаражом
            House house2 = new House.HouseBuilder()
                    .setNumRooms(5)
                    .setNumFloors(1)
                    .setHasPool(false)
                    .setHasGarage(true)
                    .build();

            // Вывод информации о втором доме
            System.out.println(house2);
        }
    }

}
