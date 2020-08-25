package ru.course.spring.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MusicPlayer {
    // @Autowired // 3rd option
    private Music music;

    // let's try to embed two dependencies and create a constructor for this case that takes two parameters
    private ClassicalMusic classicalMusic;
    private RockMusic rockMusic;

    @Autowired
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
}