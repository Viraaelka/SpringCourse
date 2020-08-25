package ru.course.spring.manual_creation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        // 1st lesson:
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );
        TestBean testBean = context.getBean("testBean", TestBean.class);
        System.out.println(testBean.getName());
        System.out.println("----------------------------------------------------");

        // 4th lesson:
        Music music = context.getBean("musicBean", Music.class);
        // внедряем зависимости вручную:
//        MusicPlayer musicPlayer = new MusicPlayer(music);
//        musicPlayer.playMusic();

        Music music1 = context.getBean("rockBean", Music.class);
//        MusicPlayer musicPlayer1 = new MusicPlayer(music1);
//        musicPlayer1.playMusic();
        System.out.println("----------------------------------------------------");

        // 5th lesson:
        // попробуем убрать зависимость MusicPlayer musicPlayer = new MusicPlayer(music)
        // из кода и обернуть его в бин
//        MusicPlayer musicPlayer2 = context.getBean("musicPlayer", MusicPlayer.class);
//        musicPlayer2.playMusic();
        System.out.println("----------------------------------------------------");

        // 6th lesson:
        // внедряем зависимости через сеттер
        MusicPlayer musicPlayer3 = context.getBean("musicPlayerSetter", MusicPlayer.class);
        System.out.println(musicPlayer3.getName());
        System.out.println(musicPlayer3.getVolume());
        System.out.println("----------------------------------------------------");

        //7th lesson:
        MusicPlayer firstMusicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
        MusicPlayer secondMusicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
        // Singleton: оба объекта firstMusicPlayer и secondMusicPlayer указывают на один и тот же объект,
        // на один и тот же кусочек памяти
        // в этом случае при изменении переменной volume, то громкость изменится у обоих плееров
        // Prototype: если у нас будет такой скоуп, то firstMusicPlayer и secondMusicPlayer будут указывать
        // на разные ссылки и вообще будут созданы два разных и несвязанных объекта, у каждой переменной свой объект
        // в этом случае при изменении переменной volume громкость плеера изменится, не испротив громкости другого плеера

        // Проверим работу Singleton
        boolean comparison = firstMusicPlayer == secondMusicPlayer; // указывают ли две переменные на один и тот же объект (кусочек памяти)
        System.out.println(comparison + " : " + firstMusicPlayer + " : " + secondMusicPlayer);
        // меняем volume у одного и проверяем, что и у второго поменяется громкость, т.к. объекты одинаковые
        firstMusicPlayer.setVolume(10);
        System.out.println(firstMusicPlayer.getVolume() + " : " + secondMusicPlayer.getVolume());
        // Проверим работу Prototype - добавим scope="prototype" -> прогоним код чуть выше еще раз и увидим, что comparison = false
        System.out.println("----------------------------------------------------");

        //8th lesson:
        ClassicalMusic newInitBeanMusic = context.getBean("musicInitBean", ClassicalMusic.class);
        System.out.println(newInitBeanMusic.getSong());

        context.close();

        // applicationContextViaAnnotation.xml
    }
}
