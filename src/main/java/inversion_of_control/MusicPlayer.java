package inversion_of_control;

// здесь сильная зависимость
public class MusicPlayer {
    private ClassicalMusic classicalMusic;
    public void playMusic(){
        classicalMusic = new ClassicalMusic();
    }
}
//SOLUTION:
//interface Music{
//    // code to access to any music
//}
//class ClassicalMusic implements Music{
//    // code to access to classical music
//}
//class RockMusic implements Music{
//    // code to access to rock music
//}
//
//// а здесь слабая зависимость
//class MusicPlayer{
//    private Music music;
//    public void playMusic(){
//        // Используем полиморфизм:
//        music = new ClassicalMusic();
//        // OR
//        music = new RockMusic();
//    }
//}
//// Inversion of Control (IoC) - этой сущности зависимости подставляются из вне
//
//class MusicPlayer{
//    private Music music;
//    public MusicPlayer(Music music){
//        this.music = music;
//    }
//    public void playMusic(){
//        // no need to create objects!
//        // code to play music
//    }
//}
//class UseNusicPlayer{
//    public static void main(String[] args) {
//        // и еще проблема в том, что все равно класс нам придется где-то создавать:
//        MusicPlayer musicPlayer = new MusicPlayer(new ClassicalMusic());
//    }
//}