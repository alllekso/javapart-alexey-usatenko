package automationPractce.address;

import automationPractce.model.MyAddressData;
import com.telesens.automationpractice.appmanager.model.AddressData;

public class ParseAddressDemo {
    public static void main(String[] args) {
        String rawLine = "Kolya,Ivanov,Petrovskogo st. 35,Kharkov,Alaska,61033,United States,+3809353613437,093234567,addressAddedRef";

        AddressData address = parseAddress(rawLine);
        System.out.println(address);

    }

    private static AddressData parseAddress(String rawLine) {
        String[] splitStrung = rawLine.split(",");
        AddressData address = new MyAddressData()

                .withAddress(splitStrung[2])
                .withFirstName(splitStrung[0])
                .withLastName(splitStrung[1])
                .withCountry(splitStrung[4])
                .withZipCode(splitStrung[5])
                .withState(splitStrung[6])
                .withCity(splitStrung[3])
                .withMobilePhone(splitStrung[7])
                .withHomePhone(splitStrung[8])
                .withAddressAlias(splitStrung[9]);

        return address;
    }


}
