import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        group g1 = new group();
        group g2 = new group();
        group g3 = new group();
        group g4 = new group();

        User user1 = new User("Первый пользователь");
        User user2 = new User("Второй пользователь");
        g1.regObserver(user1);
        g1.regObserver(user2);
        g2.regObserver(user1);
        g2.regObserver(user2);
        g3.regObserver(user1);
        g3.regObserver(user2);
        g4.regObserver(user2);

        g1.setNews("Оповещение 1");
        g2.setNews("Оповещение 2");
        g3.setNews("Оповещение 3");
        g4.setNews("Оповещение 4");
    }
}
interface Observable {
    void notifyObservers();
    void regObserver(Observer o);
}
interface Observer{
    void update(String news);
}
class group implements Observable{
    List<Observer> list = new ArrayList<>();
    String news = "Оповещение 1";
    void setNews(String news){
        this.news = news;
        notifyObservers();
    }

    @Override
    public void notifyObservers() {
        for(Observer o: list){
            o.update(news);
        }
    }

    @Override
    public void regObserver(Observer o) {
        list.add(o);
    }
}
class User implements Observer{
    String name;
    public User(String name){
        this.name = name;
    }

    @Override
    public void update(String news) {
        System.out.println(name + " получил "+ news);
    }
}