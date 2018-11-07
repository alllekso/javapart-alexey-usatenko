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

import java.util.Arrays;

public class GenArray<T> {
    private T[] array;



    public GenArray(T[] array) {
        this.array = array;

    }

    public T get(int index){
        return array[index];
    }

    public void set(int index, T element){
        array[index] = element;
    }

    @Override
    public String toString() {
        return "GenArray{" +
                "array=" + Arrays.toString(array) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GenArray<?> genArray = (GenArray<?>) o;
        return Arrays.equals(array, genArray.array);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(array);
    }
}

