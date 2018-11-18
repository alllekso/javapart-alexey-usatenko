/*c) PhoneBookDao
        методы:
        - boolean save(PhoneBookRecord record);
        - boolean remove(PhoneBookRecord record);
        - List<PhoneBookRecord> getAll();
        - PhoneBookRecord findByKeys(String phoneNumber, Long operatorId);*/
package HomeTask.lesson18.dao;

import HomeTask.lesson18.PhoneBookRecord;

import java.util.List;

public interface PhoneBookDao {
    boolean save(PhoneBookRecord record);

    boolean remove(PhoneBookRecord record);

    List<PhoneBookRecord> getAll();

    PhoneBookRecord findByKeys(String phoneNumber, Long operatorId);
}
