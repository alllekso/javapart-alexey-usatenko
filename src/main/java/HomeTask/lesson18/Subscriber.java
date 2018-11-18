/*a)	Subscriber, который хранит информацию об абоненте:
        поля:
        - private long subscriberId; 		// уникальный идентификатор
        - private String firstName; 	// имя
        - private String lastName;  	// фамилия
        - private int age; 				// возраст
        - private Enum gender;
        методы:
        - set, get // для каждого поля
        - toString();
        - equals();

        реализует интерфейс:
        - Comparable // сравнивает двух абонентов по полю subscriber_id нужно для сортировки)*/
package HomeTask.lesson18;

import java.util.Objects;

public class Subscriber implements Comparable<Subscriber> {
    private long subscriberId;
    private String firstName;
    private String lastName;
    private int age;
    private Enum gender;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subscriber that = (Subscriber) o;
        return subscriberId == that.subscriberId &&
                age == that.age &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(gender, that.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subscriberId, firstName, lastName, age, gender);
    }

    @Override
    public String toString() {
        return "Subscriber{" +
                "S ubscriber id=" + subscriberId +
                ", First Name: '" + firstName + '\'' +
                ", Last Name: '" + lastName + '\'' +
                ", Age: " + age +
                ", Gender: " + gender +
                '}';
    }

    public long getSubscriberId() {
        return subscriberId;
    }

    public void setSubscriberId(long subscriberId) {
        this.subscriberId = subscriberId;
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

    public Enum getGender() {
        return gender;
    }

    public void setGender(Enum gender) {
        this.gender = gender;
    }

    @Override
    public int compareTo(Subscriber otherSubscriber) {
        return Long.compare(this.subscriberId, otherSubscriber.subscriberId);
    }
}
