package ru.course.spring.annotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        // 9th lesson:
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                // "applicationContext.xml" - ранее инициализировали бины руками и использовали этот файлик
                // а теперь сделаем это через аннотации и другой файлик, в котором описан метод "context:component-scan",
                // позволяющий спрингу сканировать все наши классы
                "applicationContextViaAnnotation.xml"
        );

//        Music music = context.getBean("someRockMusic", Music.class);
//        MusicPlayer musicPlayer = new MusicPlayer(music);
//        musicPlayer.playMusic();
//        // если не указывать id в @Component, то спринг сам назначает id как название класса,
//        // но первая буква будет маленькой
//        Music music2 = context.getBean("classicalMusic", Music.class);
//        MusicPlayer musicPlayer2 = new MusicPlayer(music2);
//        musicPlayer2.playMusic();
//        MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
//        musicPlayer.playMusic();

        Computer computer = context.getBean("computer", Computer.class);
        System.out.println(computer);

        context.close();

    }
}
