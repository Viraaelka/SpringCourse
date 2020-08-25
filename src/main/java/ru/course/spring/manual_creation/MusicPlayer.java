package ru.course.spring.manual_creation;

public class MusicPlayer {
    private Music music;

    // IoC - 1st option to implement dependency - Constructor
//    public MusicPlayer(Music music) {
//        this.music = music;
//    }

    // IoC - 2nd option to implement dependency - Setter
    public void setMusic(Music music) {
        this.music = music;
    }

    // в случае с сеттером нам обязатьльно нужен дефолтный конструктор, потому что именно через него будет задаваться объект, на котором будет вызван сеттер
    public MusicPlayer() {
    }

    private String name;
    private int volume;

    public void setName(String name) {
        this.name = name;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public String getName() {
        return name;
    }

    public int getVolume() {
        return volume;
    }

    public void playMusic() {
        System.out.println("Playing: " + music.getSong());
    }
}
