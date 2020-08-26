package ru.course.spring.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MusicPlayer {
    // @Autowired // 3rd option
    private Music music;
    private Music music2;

    // Аннотация @Qualifier позволяет решить проблему:
    //    NoUniqueBeanDefinitionException: No qualifying bean of type 'ru.course.spring.annotation.Music' available:
    //    expected single matching bean but found 2: classicalMusic,someRockMusic
    @Autowired
    public MusicPlayer(@Qualifier("someRockMusic") Music music,
                       @Qualifier("classicalMusic") Music music2) {
        this.music = music;
        this.music2 = music2;
    }

    // 12th lesson:
    @Value("${musicPlayer.name}")
    private String name;
    @Value("${musicPlayer.volume}")
    private int volume;

    public int getVolume() {
        return volume;
    }

    public String getName() {
        return name;
    }

    // let's try to embed two dependencies and create a constructor for this case that takes two parameters
    private ClassicalMusic classicalMusic;
    private RockMusic rockMusic;

    // @Autowired
    public MusicPlayer(ClassicalMusic classicalMusic, RockMusic rockMusic) {
        this.classicalMusic = classicalMusic;
        this.rockMusic = rockMusic;
    }

    // @Autowired // 1st option
    public MusicPlayer(Music music) {
        this.music = music;
    }

    // @Autowired // 2nd option
    public void setMusic(Music music) {
        this.music = music;
    }

    public void playMusic() {
        System.out.println("Playing: " + classicalMusic.getSong());
        System.out.println("Playing: " + rockMusic.getSong());
    }

    public String getStringMusic() {
        return "Playing: " + rockMusic.getSong();
    }

    // 11th lesson
    public String playWithQualifier() {
        return "Playing: " + music.getSong() + " " + music2.getSong();
    }
}