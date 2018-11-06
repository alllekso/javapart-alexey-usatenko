package com.telesens.academy.tests.loginform;

import com.academy.fx.model.RegistrationForm;
import com.academy.fx.validator.RegistrationValidator;
import org.testng.annotations.Test;

public class RegistrationFromTests {

    @Test
    public void testInputName() {
        RegistrationForm registrationForm = new RegistrationForm()
                .withFirstName("FirstName", "")
                .withLastName("", "test")
                .withMail("", "test@mail.ru")
                .withPassword("", "1qweEtyuiq")
                .withConfirmPassword("q", "1qweEtyuiq");

        RegistrationValidator validator = new RegistrationValidator();
        boolean isValid = validator.validate(registrationForm);
        String msgError = validator.getMsgError();
        System.out.println(msgError);
    }
}
