package util;

import db.entity.Department;
import service.DepartmentService;
import service.impl.DepartmentServiceImpl;
import util.validator.FieldValidatorUtil;

import java.util.List;
import java.util.Objects;

public class DepartmentValidator {

    private static final String MESSAGE_THIS_DEPARTMENT_CODE_ALREADY_EXIST = "This department code already exist";
    private static final String MESSAGE_THIS_DEPARTMENT_NAME_ALREADY_EXIST = "This department name already exist";
    private static final String MESSAGE_VALID = "";
    private static DepartmentService departmentService = new DepartmentServiceImpl();

    public static String validate(String id, String code, String name) {
        String nameErrorMessage = FieldValidatorUtil.validateDepName(name);
        String codeErrorMessage = FieldValidatorUtil.validateDepCode(code);
        if(!nameErrorMessage.isEmpty() || !codeErrorMessage.isEmpty()){
            return  nameErrorMessage + " " + codeErrorMessage;
        }
        int cod = Integer.parseInt(code);
        List<Department> departments = departmentService.getAllDepartment();
        for (Department department : departments) {
            if (department.getDepartmentCode() == cod && Objects.nonNull(id) && !(department.getId()==Long.parseLong(id))) {
                codeErrorMessage = MESSAGE_THIS_DEPARTMENT_CODE_ALREADY_EXIST;
            } else if (Objects.equals(department.getDepartmentName(), (name)) && Objects.nonNull(id) && !(department.getId()==Long.parseLong(id))) {
                return MESSAGE_THIS_DEPARTMENT_NAME_ALREADY_EXIST;
            }
        }
        return MESSAGE_VALID + nameErrorMessage + "\n" + codeErrorMessage;
    }
}
