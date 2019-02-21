package util;

import db.entity.Department;
import util.validator.FieldValidatorUtil;

public class DepartmentValidator {

    private static final String MESSAGE_VALID = "";

    public static String validate(int code, String name){
        String codeErrorMessage = FieldValidatorUtil.validateDepCode(code);
        if (!FieldValidatorUtil.MESSAGE_VALID.equals(codeErrorMessage)) {
            return codeErrorMessage;
        }
        String nameErrorMessage = FieldValidatorUtil.validateDepName(name);
        if (!FieldValidatorUtil.MESSAGE_VALID.equals(nameErrorMessage)) {
            return nameErrorMessage;
        }
        return MESSAGE_VALID;
    }
}
