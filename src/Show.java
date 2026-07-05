import java.util.ArrayList;
import java.util.List;

public class Show {
    private String title;
    private int duration;
    private Director director;
    private List<Actor> listOfActors;

    public Show(String title, int duration, Director director) {
        this.title = title;
        this.duration = duration;
        this.director = director;
        this.listOfActors = new ArrayList<>();
    }


    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }

    public Director getDirector() {
        return director;
    }

    public List<Actor> getListOfActors() {
        // Возвращаем копию, чтобы нельзя было изменить список снаружи
        return new ArrayList<>(listOfActors);
    }

    // Распечатать список всех актёров
    public void printActors() {
        System.out.println("Актёры в спектакле \"" + title + "\":");
        if (listOfActors.isEmpty()) {
            System.out.println("  (нет актёров)");
            return;
        }
        for (Actor i : listOfActors) {
            // Выводим имя, фамилию и рост в скобках
            System.out.println("- " + i.getName() + " " + i.getSurname()
                    + " (рост " + i.getHeight() + " см)");
        }
    }

    // Добавить нового актёра с проверкой на дубликат
    public void addActor(Actor actor) {
        if (listOfActors.contains(actor)) {
            System.out.println("Предупреждение: актёр " + actor.getName() + " "
                    + actor.getSurname() + " (рост " + actor.getHeight() + ") уже участвует в спектакле.");
            return;
        }
        listOfActors.add(actor);
    }

    // Заменить актёра по фамилии на нового
    public void replaceActorBySurname(Actor newActor, String oldSurname) {
        // Сначала проверяем, есть ли уже такой актёр в списке
        if (listOfActors.contains(newActor)) {
            System.out.println("Предупреждение: актёр " + newActor.getName() + " "
                    + newActor.getSurname() + " (рост " + newActor.getHeight()
                    + ") уже участвует в спектакле \"" + title + "\". Замена не выполнена.");
            return;
        }

        // Ищем актёра для замены по фамилии
        int index = -1;
        for (int i = 0; i < listOfActors.size(); i++) {
            if (listOfActors.get(i).getSurname().equals(oldSurname)) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Предупреждение: актёра с фамилией \"" + oldSurname
                    + "\" не найдено в спектакле \"" + title + "\". Замена не выполнена.");
            return;
        }

        listOfActors.set(index, newActor);
        System.out.println("Актёр с фамилией \"" + oldSurname + "\" заменён на "
                + newActor.getName() + " " + newActor.getSurname());
    }

    @Override
    public String toString() {
        return "Show{" +
                "title='" + title + '\'' +
                ", duration=" + duration +
                ", director=" + director +
                ", listOfActors=" + listOfActors +
                '}';
    }
}
