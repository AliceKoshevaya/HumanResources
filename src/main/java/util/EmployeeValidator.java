package util;

import util.validator.FieldValidatorUtil;

public class EmployeeValidator {

    private static final String MESSAGE_VALID = "";

    public static String validate(String name, String lastName, String thirdName, int exp, String address,
                                  Long telephone,String email){
        String nameErrorMessage = FieldValidatorUtil.validateName(name);
        if (!FieldValidatorUtil.MESSAGE_VALID.equals(nameErrorMessage)) {
            return nameErrorMessage;
        }
        String lastNameErrorMessage = FieldValidatorUtil.validateLastName(lastName);
        if (!FieldValidatorUtil.MESSAGE_VALID.equals(lastNameErrorMessage)) {
            return lastNameErrorMessage;
        }
        String thirdNameErrorMessage = FieldValidatorUtil.validateThirdName(thirdName);
        if (!FieldValidatorUtil.MESSAGE_VALID.equals(thirdNameErrorMessage)) {
            return thirdNameErrorMessage;
        }
        String expErrorMessage = FieldValidatorUtil.validateExp(exp);
        if (!FieldValidatorUtil.MESSAGE_VALID.equals(expErrorMessage)) {
            return expErrorMessage;
        }
        String addressErrorMessage = FieldValidatorUtil.validateAddress(address);
        if (!FieldValidatorUtil.MESSAGE_VALID.equals(addressErrorMessage)) {
            return addressErrorMessage;
        }
        String telephoneErrorMessage = FieldValidatorUtil.validateTelephone(telephone);
        if (!FieldValidatorUtil.MESSAGE_VALID.equals(telephoneErrorMessage)) {
            return telephoneErrorMessage;
        }
        String emailErrorMessage = FieldValidatorUtil.validateEmail(email);
        if (!FieldValidatorUtil.MESSAGE_VALID.equals(emailErrorMessage)) {
            return emailErrorMessage;
        }
        return MESSAGE_VALID;
    }
}
