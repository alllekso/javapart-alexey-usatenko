/*2) Создать пакет dao, в котором описать интерфейсы:
        a) SubscriberDao
        методы:
        - boolean save(Subscriber subscriber);
        - boolean remove(Subscriber subscriber);
        - List<Subscriber> getAll();
        - Subscriber findById(long id);*/
package HomeTask.lesson18.dao;

import HomeTask.lesson18.Subscriber;

import java.util.List;

public interface SubscriberDao {
    boolean save(Subscriber subscriber);

    boolean remove(Subscriber subscriber);

    List<Subscriber> getAll();

    Subscriber findById(long id);
}
