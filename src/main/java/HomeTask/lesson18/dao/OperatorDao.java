/*b) 	OperatorDao
        методы:
        - boolean save(Operator operator);
        - boolean remove(Operator operator);
        - List<Operator> getAll();
        - Operator findById(long id);*/
package HomeTask.lesson18.dao;

import HomeTask.lesson18.Operator;

import java.util.List;

public interface OperatorDao {
    boolean save(Operator operator);

    boolean remove(Operator operator);

    List<Operator> getAll();

    Operator findById(long id);
}
