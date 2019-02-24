package util;

import db.entity.Department;
import service.DepartmentService;
import service.impl.DepartmentServiceImpl;
import util.validator.FieldValidatorUtil;
import java.util.*;

import java.util.ArrayList;

public class DepartmentValidator {

    private static DepartmentService departmentService = new DepartmentServiceImpl();
    private static final String MESSAGE_VALID = "";

    public static String validate(String code, String name){
        int cod;
        try {
            cod = Integer.parseInt(code);
        }catch (NumberFormatException ex){
            return "Department code contains only numbers";
        }
        List<Department> departments = departmentService.getAllDepartment();
        for (Department department : departments) {
            if(department.getDepartmentCode() == cod){
                return "This department code already exist";
            }else if(department.getDepartmentName().equals(name)){
                return "This department name already exist";
            }
        }
        String codeErrorMessage = FieldValidatorUtil.validateDepCode(cod);
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
