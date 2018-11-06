//
//=====================================================
//Шилдт "Руководство для начинающих" 6 изд.
//стр. 465-503 - "Обобщения"
//=====================================================
//
//
//1) Создать обобщенный класс GenArray, который:
//	a) хранит элементы массива параметризированного типа.
//		Размер массива постоянен во все время существования экземпляра класса
// и инициализируется во время создания
//		(в конструктор передается конкретный массив: public GenArray(Integer[] array) {...}
//
//	b)	Реализовать методы:
//			T get(int index) - который вернет элемент массива
//			void set(int index, T element), который установит элемент массива
//			перегрузить методы toString() и equals();
//
//	c)	Бросать исключения, если index выходит за пределы допустимого диапазона
package HomeTask.lesson12;

public class GenArray<T> implements Containment<T> {
    T[] array;
    public GenArray(T[] array) {
        this.array = array;
    }
    @Override
    public boolean contains(T obj) {
        for (T item : array)
            if(item.equals(obj))
                return true;
        return false;
    }
}

