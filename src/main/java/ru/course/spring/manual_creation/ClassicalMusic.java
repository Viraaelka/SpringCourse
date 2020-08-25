package ru.course.spring.manual_creation;

public class ClassicalMusic implements Music {
    // специально создаем приватный конструктор, чтобы не иметь возможности создавать новый класс через new
    // при вот такой записи будет ошибка: ClassicalMusic cm = new ClassicalMusic();
    // нам это необходимо для задания фабричного метода (в этом суть паттерна фабричный метод)
    private ClassicalMusic() {
    }

    // создаем фабричный метод, который обязательно должен быть статичным (иначе получится замкнутый круг: не будет объекта,
    // на котрром мы можем вызвать фабричный метод, а единственный способ получить объект - вызвать фабричный метод -> он статик
    public static ClassicalMusic getClassicalMusic() {
        return new ClassicalMusic();

    }

    // Rules for doMyInit and doMyDestroy:
    // не должно быть аргументов, всегда void, для prototype не вызывается destroy, названия методов могут быть любые
    public void doMyInit() {
        System.out.println("Doing my initialization");
    }

    public void doMyDestroy() {
        System.out.println("Doing my destruction");
    }

    @Override
    public String getSong() {
        return "Hungarian Rhapsody";
    }
}
