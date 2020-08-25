package ru.course.spring.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Computer {
    private int id;
    private MusicPlayer musicPlayer;

    // у класса Computer есть зависимость musicPlayer, которая внедряется через @Autowired
    // и идет в MusicPlayer, где есть конструктор с такой же аннотацией
            // @Autowired
            // public MusicPlayer(ClassicalMusic classicalMusic, RockMusic rockMusic) {
    // а MusicPlayer, в свою очередь тоже бин, у которого есть 2 зависимости,
    // а уже далее цепляется метод getStringMusic
    @Autowired
    public Computer(MusicPlayer musicPlayer) {
        this.id = 1;
        this.musicPlayer = musicPlayer;
    }

    @Override
    public String toString() {
        return "Computer " + id + " " + musicPlayer.getStringMusic();
    }
}
