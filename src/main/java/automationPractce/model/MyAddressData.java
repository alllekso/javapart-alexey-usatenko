package automationPractce.model;

import com.telesens.automationpractice.appmanager.model.AddressData;

public class MyAddressData extends AddressData {

    @Override
    public String toString() {
        return "MyAddressData{addressAlias=" + getAlias() +
                "\n" + getAddress() +
                "My city\n" + getCity() + "\n" + getCountry() +

        "}";
    }
}


//                .withAddress(splitStrung[2])
//                        .withFirstName(splitStrung[0])
//                        .withLastName(splitStrung[1])
//                        .withCountry(splitStrung[4])
//                        .withZipCode(splitStrung[5])
//                        .withState(splitStrung[6])
//                        .withCity(splitStrung[3])
//                        .withMobilePhone(splitStrung[7])
//                        .withHomePhone(splitStrung[8])
//                        .withAddressAlias(splitStrung[9]);
//                        Kolya,Ivanov,Petrovskogo st. 35,Kharkov,Alaska,61033,United States,+3809353613437,093234567,addressAddedRef"