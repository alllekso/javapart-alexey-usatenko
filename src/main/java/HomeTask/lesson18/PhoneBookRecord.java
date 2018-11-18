/*с) PhoneBookRecord (запись в телефонной книге):

        поля:
        - private String phoneNumber;
        - private Long subscriberId;
        - private Date registeredDate;

        методы:
        - set, get // для каждого поля
        - toString();
        - equals(); // сравнивает по operator_id*/
package HomeTask.lesson18;

import java.util.Date;
import java.util.Objects;

public class PhoneBookRecord {
    private String phoneNumber;
    private Long subscriberId;
    private Date registeredDate;

    public PhoneBookRecord(String phoneNumber, Long subscriberId, Date registeredDate) {
        this.phoneNumber = phoneNumber;
        this.subscriberId = subscriberId;
        this.registeredDate = registeredDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneBookRecord that = (PhoneBookRecord) o;
        return Objects.equals(subscriberId, that.subscriberId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subscriberId);
    }

    @Override
    public String toString() {
        return "PhoneBookRecord{" +
                " Phone Number: '" + phoneNumber + '\'' +
                ", Subscriber id: " + subscriberId +
                ", Registered Date: " + registeredDate +
                '}';
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Long getSubscriberId() {
        return subscriberId;
    }

    public void setSubscriberId(Long subscriberId) {
        this.subscriberId = subscriberId;
    }

    public Date getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(Date registeredDate) {
        this.registeredDate = registeredDate;
    }
}
