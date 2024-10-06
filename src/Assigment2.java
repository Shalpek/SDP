public class Assigment2 {
    // Интерфейс для музыкальной композиции
    public interface Melody {
        String play();
    }

    // Базовая мелодия (например, пианино)
    public static class PianoMelody implements Melody {
        @Override
        public String play() {
            return "Playing main piano melody";
        }
    }

    // Декоратор для добавления баса
    public static class BassDecorator implements Melody {
        protected Melody decoratedMelody;

        public BassDecorator(Melody melody) {
            this.decoratedMelody = melody;
        }

        @Override
        public String play() {
            return decoratedMelody.play() + " + with bass";
        }
    }

    // Декоратор для добавления ударных
    public static class DrumsDecorator implements Melody {
        protected Melody decoratedMelody;

        public DrumsDecorator(Melody melody) {
            this.decoratedMelody = melody;
        }

        @Override
        public String play() {
            return decoratedMelody.play() + " + with drums";
        }
    }

    // Декоратор для добавления эффекта реверберации
    public static class ReverbDecorator implements Melody {
        protected Melody decoratedMelody;

        public ReverbDecorator(Melody melody) {
            this.decoratedMelody = melody;
        }

        @Override
        public String play() {
            return decoratedMelody.play() + " + with reverb effect";
        }
    }

    // Пример использования
    public static void main(String[] args) {
        // Базовая мелодия на пианино
        Melody pianoMelody = new PianoMelody();
        System.out.println(pianoMelody.play());

        // Добавляем бас к мелодии
        Melody melodyWithBass = new BassDecorator(pianoMelody);
        System.out.println(melodyWithBass.play());

        // Добавляем ударные
        Melody melodyWithBassAndDrums = new DrumsDecorator(melodyWithBass);
        System.out.println(melodyWithBassAndDrums.play());

        // Добавляем эффект реверберации
        Melody fullMelody = new ReverbDecorator(melodyWithBassAndDrums);
        System.out.println(fullMelody.play());
    }
}
