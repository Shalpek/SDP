public class States {
    public interface State {
        void pressPlay(MediaPlayer player);
        void pressPause(MediaPlayer player);
        void pressStop(MediaPlayer player);
    }

    // Конкретное состояние: Состояние воспроизведения
    public static class PlayingState implements State {
        @Override
        public void pressPlay(MediaPlayer player) {
            System.out.println("Уже воспроизводится!");
        }

        @Override
        public void pressPause(MediaPlayer player) {
            System.out.println("Приостановка плеера.");
            player.setState(new PausedState());
        }

        @Override
        public void pressStop(MediaPlayer player) {
            System.out.println("Остановка плеера.");
            player.setState(new StoppedState());
        }
    }

    // Конкретное состояние: Состояние паузы
    static class PausedState implements State {
        @Override
        public void pressPlay(MediaPlayer player) {
            System.out.println("Возобновление плеера.");
            player.setState(new PlayingState());
        }

        @Override
        public void pressPause(MediaPlayer player) {
            System.out.println("Уже приостановлено!");
        }

        @Override
        public void pressStop(MediaPlayer player) {
            System.out.println("Остановка плеера.");
            player.setState(new StoppedState());
        }
    }

    // Конкретное состояние: Состояние остановки
    static class StoppedState implements State {
        @Override
        public void pressPlay(MediaPlayer player) {
            System.out.println("Запуск плеера.");
            player.setState(new PlayingState());
        }

        @Override
        public void pressPause(MediaPlayer player) {
            System.out.println("Нельзя приостановить. Плеер остановлен.");
        }

        @Override
        public void pressStop(MediaPlayer player) {
            System.out.println("Уже остановлен!");
        }
    }

    // Контекст: MediaPlayer
    public static class MediaPlayer {
        private State currentState;

        public MediaPlayer() {
            this.currentState = new StoppedState(); // Начальное состояние
        }

        public void setState(State state) {
            this.currentState = state;
        }

        public void pressPlay() {
            currentState.pressPlay(this);
        }

        public void pressPause() {
            currentState.pressPause(this);
        }

        public void pressStop() {
            currentState.pressStop(this);
        }
    }

    // Главный класс для тестирования шаблона состояния
    public static class Main {
        public static void main(String[] args) {
            MediaPlayer player = new MediaPlayer();

            player.pressPlay();  // "Запуск плеера."
            player.pressPause(); // "Приостановка плеера."
            player.pressPlay();  // "Возобновление плеера."
            player.pressStop();  // "Остановка плеера."
        }
    }

}
