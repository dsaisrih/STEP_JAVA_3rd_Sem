public class PlayerTest {
    public static void main(String[] args) {
        Playable ref;

        ref = new MusicPlayer();
        ref.play();
        ref.pause();

        ref = new VideoPlayer();
        ref.play();
        ref.pause();
    }
}
