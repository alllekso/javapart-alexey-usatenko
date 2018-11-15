/*1)  Реализовать класс Subscriber (Абонент), который хранит информацию об абоненте:
        поля:
        - private Long id; 				// уникальный идентификатор
        - private String firstName; 	// имя
        - private String lastName;  	// фамилия
        - private int age; 				// возраст
        - private String phoneNumber; 	// телефонный номер (12 цифр: 380509373356)

        методы (перегруженные):
        - public toString (); 	// возвращает строку об абоненте
        - public equals();  	// использовать автогенерацию (по всем полям)
        - public hashCode(); 	// использовать автогенерацию

        методы для каждого поля (Использовать автогенерацию)
        - public get...
        - public set...

        реализует интерфейс:
        - Comparable // сравнивает двух абонентов по полю id (нужно для сортировки)*/
package HomeTask.lesson15;

import java.util.Objects;

public class Subscriber implements Comparable<Subscriber> {
    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    private String phoneNumber;

    public Subscriber(Long id, String firstName, String lastName, int age, String phoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public int compareTo(Subscriber otherSubscriber) {
//        if (this.id <otherSubscriber.id) {
//            return -1;}
//        else
//        if (this.id>otherSubscriber.id){
//            return 1;  }
//
//        return 0;
        return Long.compare(this.id, otherSubscriber.id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subscriber that = (Subscriber) o;
        return age == that.age &&
                Objects.equals(id, that.id) &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(phoneNumber, that.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, age, phoneNumber);
    }

    @Override
    public String toString() {
        return "Subscriber{" +
                "id: " + id +
                ", Name: '" + firstName + '\'' +
                ", Last Name: '" + lastName + '\'' +
                ", Age: " + age +
                ", Phone Number: '" + phoneNumber + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}