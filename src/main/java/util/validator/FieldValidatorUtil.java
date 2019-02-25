package util.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class validating entered fields
 */
public class FieldValidatorUtil {

    public static final String MESSAGE_VALID = "";

    private static final String MESSAGE_EMPTY_DEP_CODE = "Department code must be not empty";
    private static final String MESSAGE_EMPTY_DEP_NAME = "Department name must be not empty";
    private static final String MESSAGE_EMPTY_NAME = "Field name must be not empty";
    private static final String MESSAGE_EMPTY_LAST_NAME = "Field lastName must be not empty";
    private static final String MESSAGE_EMPTY_THIRD_NAME = "Third name must be not empty";
    private static final String MESSAGE_EMPTY_EXP = "Field experience must be not empty";
    private static final String MESSAGE_EMPTY_ADDRESS = "Field address must be not empty";
    private static final String MESSAGE_EMPTY_TELEPHONE = "Field telephone must be not empty";
    private static final String MESSAGE_EMPTY_EMAIL = "Field email must be not empty";
    private static final String MESSAGE_EMPTY_JOB_CODE = "Field job code must be not empty";

    private static final String MESSAGE_NOT_VALID_DEP_CODE = "Department code contains invalid characters";
    private static final String MESSAGE_NOT_VALID_DEP_NAME = "Department name contains invalid characters";
    private static final String MESSAGE_NOT_VALID_NAME = "Field name contains invalid characters";
    private static final String MESSAGE_NOT_VALID_LAST_NAME = "Field Last Name contains invalid characters";
    private static final String MESSAGE_NOT_VALID_THIRD_NAME = "Field third name contains invalid characters";
    private static final String MESSAGE_NOT_VALID_EXP = "Field experience contains invalid characters";
    private static final String MESSAGE_NOT_VALID_ADDRESS = "Field address contains invalid characters";
    private static final String MESSAGE_NOT_VALID_TELEPHONE = "Field telephone contains invalid characters";
    private static final String MESSAGE_NOT_VALID_EMAIL = "Field email contains invalid characters";
    private static final String MESSAGE_NOT_VALID_JOB_CODE = "Field job code contains invalid characters";

    private static final String REGEXP_NAMES = "^[A-ZА-Я][a-zа-я]+";
    private static final String REGEXP_CODE = "\\d{2}";
    private static final String REGEXP_EXP = "\\d{1,2}";
    private static final String REGEXP_EMAIL = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$";
    private static final String REGEXP_TELEPHONE = "^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$";
    public static final String MESSAGE_DEPARTMENT_CODE_CONTAINS_ONLY_NUMBERS = "Department code contains only numbers";


    public static String validateName(String name) {
        return validateField(name, MESSAGE_EMPTY_NAME, REGEXP_NAMES, MESSAGE_NOT_VALID_NAME);
    }

    public static String validateDepCode(String code) {
        int cod;
        try {
            cod = Integer.parseInt(code);
        } catch (NumberFormatException ex) {
            return MESSAGE_DEPARTMENT_CODE_CONTAINS_ONLY_NUMBERS;
        }
        return validateField(code, MESSAGE_EMPTY_DEP_CODE, REGEXP_CODE, MESSAGE_NOT_VALID_DEP_CODE);
    }

    public static String validateDepName(String depName) {
        return validateField(depName, MESSAGE_EMPTY_DEP_NAME, REGEXP_NAMES, MESSAGE_NOT_VALID_DEP_NAME);
    }

    public static String validateLastName(String lastName) {
        return validateField(lastName, MESSAGE_EMPTY_LAST_NAME, REGEXP_NAMES, MESSAGE_NOT_VALID_LAST_NAME);
    }

    public static String validateThirdName(String thirdName) {
        return validateField(thirdName, MESSAGE_EMPTY_THIRD_NAME, REGEXP_NAMES, MESSAGE_NOT_VALID_THIRD_NAME);
    }

    public static String validateExp(int exp) {
        String experience = String.valueOf(exp);
        return validateField(experience, MESSAGE_EMPTY_EXP, REGEXP_EXP, MESSAGE_NOT_VALID_EXP);
    }

    public static String validateAddress(String address) {
        return validateField(address, MESSAGE_EMPTY_ADDRESS, REGEXP_NAMES, MESSAGE_NOT_VALID_ADDRESS);
    }

    public static String validateTelephone(Long tel) {
        String telephone = String.valueOf(tel);
        return validateField(telephone, MESSAGE_EMPTY_TELEPHONE, REGEXP_TELEPHONE, MESSAGE_NOT_VALID_TELEPHONE);
    }

    public static String validateEmail(String email) {
        return validateField(email, MESSAGE_EMPTY_EMAIL, REGEXP_EMAIL, MESSAGE_NOT_VALID_EMAIL);
    }

    public static String validateJobCode(int code) {
        String jobCode = String.valueOf(code);
        return validateField(jobCode, MESSAGE_EMPTY_JOB_CODE, REGEXP_CODE, MESSAGE_NOT_VALID_JOB_CODE);
    }

    private static String validateField(String field,
                                        String errorMessageEmpty,
                                        String regexp,
                                        String errorMessageInvalidChars) {
        if (field == null || field.isEmpty()) {
            return errorMessageEmpty;
        }
        Pattern pattern = Pattern.compile(regexp);
        Matcher matcher = pattern.matcher(field);
        boolean regexpResult = matcher.matches();
        if (!regexpResult) {
            return errorMessageInvalidChars;
        }
        return MESSAGE_VALID;
    }
}
