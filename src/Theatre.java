public class Theatre {

    public static void main(String[] args) {
        System.out.println("=== НАЧИНАЕМ ПРЕДСТАВЛЕНИЕ! ===\n");

        // 1. Создаём трёх актёров и двух режиссёров
        Actor actor1 = new Actor("Иван", "Анисимов", Gender.MALE, 180);
        Actor actor2 = new Actor("Анна", "Петрова", Gender.FEMALE, 168);
        Actor actor3 = new Actor("Сергей", "Сидоров", Gender.MALE, 175);

        Director director1 = new Director("Алексей", "Петров", Gender.MALE, 7);
        Director director2 = new Director("Елена", "Васильева", Gender.FEMALE, 5);

        /* Создаём одного автора музыки и одного хореографа
         Автор музыки и хореограф хранятся просто как строки (по даному ТЗ),
         так как отдельных классов для них не требовалось.*/
        String musicAuthor = "Пётр Чайковский";
        String choreographer = "Мариус Петипа";

        System.out.println("--- Создание спектаклей ---");

        // 2. Создаём три спектакля: обычный, оперный и балет

        // Обычный спектакль (Show)
        Show regularShow = new Show("Гамлет", 120, director1);

        // Оперный спектакль (Opera)
        Opera operaShow = new Opera(
                "Травиата",
                150,
                director2,
                musicAuthor,
                "Либретто оперы Травиата: история любви Виолетты и Альфреда...",
                40 // choirSize
        );

        // Балетный спектакль (Ballet)
        Ballet balletShow = new Ballet(
                "Лебединое озеро",
                140,
                director1,
                musicAuthor,
                "Либретто балета Лебединое озеро: заколдованная Одетта...",
                choreographer
        );

        System.out.println();

        // 3. Распределяем актёров по спектаклям
        // Один актёр может участвовать в нескольких спектаклях

        regularShow.addActor(actor1);
        regularShow.addActor(actor2);
        // actor3 пока не участвует в обычном спектакле

        operaShow.addActor(actor1); // Иван Анисимов играет и в опере
        operaShow.addActor(actor3);

        balletShow.addActor(actor2); // Анна Петрова танцует в балете
        balletShow.addActor(actor3); // Сергей Сидоров тоже в балете

        System.out.println("--- Список актёров в спектаклях (ПЕРВЫЙ ВЫВОД) ---");

        System.out.println("Спектакль \"Гамлет\":");
        regularShow.printActors();
        System.out.println();

        System.out.println("Опера \"Травиата\":");
        operaShow.printActors();
        System.out.println();

        System.out.println("Балет \"Лебединое озеро\":");
        balletShow.printActors();
        System.out.println();

        // 4. Заменяем актёра в одном из спектаклей на актёра из другого спектакля
        System.out.println("--- Замена актёра ---");
        // В опере заменим актёра с фамилией "Сидоров" (это actor3) на actor2 (Анну Петрову)
        operaShow.replaceActorBySurname(actor2, "Сидоров");

        System.out.println("\nСписок актёров в опере \"Травиата\" ПОСЛЕ замены:");
        operaShow.printActors();
        System.out.println();

        // 5. Пытаемся заменить в другом спектакле несуществующего актёра
        System.out.println("--- Попытка замены несуществующего актёра ---");
        // В балете попробуем заменить актёра с фамилией "Кузнецов" (такого нет)
        Actor dummyActor = new Actor("Новый", "Актёр", Gender.MALE, 178);
        balletShow.replaceActorBySurname(dummyActor, "Кузнецов");
        System.out.println();

        // 6. Для оперного и балетного спектакля выводим текст либретто
        System.out.println("--- Тексты либретто ---");

        System.out.println("Либретто оперы \"Травиата\":");
        operaShow.printLibretto();
        System.out.println();

        System.out.println("Либретто балета \"Лебединое озеро\":");
        balletShow.printLibretto();

        System.out.println("\n=== ТЕАТР ЗАВЕРШИЛ РАБОТУ НА СЕГОДНЯ ===\n");
    }
}
