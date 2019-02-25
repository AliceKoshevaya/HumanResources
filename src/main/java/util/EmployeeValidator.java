package util;

import db.entity.Department;
import db.entity.Employee;
import service.EmployeeService;
import service.impl.EmployeeServiceImpl;
import util.validator.FieldValidatorUtil;

import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class EmployeeValidator {

    private static EmployeeService employeeService = new EmployeeServiceImpl();
    private static final String MESSAGE_VALID = "";

    public static String validate(String name, String lastName, String thirdName, String exp, String address,
                                  String telephone, String email, java.sql.Date date){
        List<Employee> employees = employeeService.getAllEmployees();
        for (Employee employee : employees) {
            if(employee.getEmail().equals(email)){
                return "This email already exist";
            }
        }
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
        int experience;
        try {
            experience = Integer.parseInt(exp);
        }catch (NumberFormatException ex){
            return "Field experience contains only numbers";
        }
        String expErrorMessage = FieldValidatorUtil.validateExp(experience);
        if (!FieldValidatorUtil.MESSAGE_VALID.equals(expErrorMessage)) {
            return expErrorMessage;
        }
        java.util.Date dateCompare = new GregorianCalendar(2001, Calendar.JANUARY, 25).getTime();
        if(date.after(new Date(dateCompare.getTime()))){
            return "The employee must be 18 years old";
        }
        String addressErrorMessage = FieldValidatorUtil.validateAddress(address);
        if (!FieldValidatorUtil.MESSAGE_VALID.equals(addressErrorMessage)) {
            return addressErrorMessage;
        }
        Long telephon;
        try {
            telephon = Long.parseLong(telephone);
        }catch (NumberFormatException ex){
            return "Field experience contains only numbers";
        }
        String telephoneErrorMessage = FieldValidatorUtil.validateTelephone(telephon);
        if (!FieldValidatorUtil.MESSAGE_VALID.equals(telephoneErrorMessage)) {
            return telephoneErrorMessage;
        }
        String emailErrorMessage = FieldValidatorUtil.validateEmail(email);
        if (!FieldValidatorUtil.MESSAGE_VALID.equals(emailErrorMessage)) {
            return emailErrorMessage;
        }
        return MESSAGE_VALID;
    }
    public static String validateEdit(String name, String lastName, String exp, String address,
                                  String telephone,String email){
        String nameErrorMessage = FieldValidatorUtil.validateName(name);
        if (!FieldValidatorUtil.MESSAGE_VALID.equals(nameErrorMessage)) {
            return nameErrorMessage;
        }
        String lastNameErrorMessage = FieldValidatorUtil.validateLastName(lastName);
        if (!FieldValidatorUtil.MESSAGE_VALID.equals(lastNameErrorMessage)) {
            return lastNameErrorMessage;
        }
        int experience;
        try {
            experience = Integer.parseInt(exp);
        }catch (NumberFormatException ex){
            return "Field experience contains only numbers";
        }
        String expErrorMessage = FieldValidatorUtil.validateExp(experience);
        if (!FieldValidatorUtil.MESSAGE_VALID.equals(expErrorMessage)) {
            return expErrorMessage;
        }
        String addressErrorMessage = FieldValidatorUtil.validateAddress(address);
        if (!FieldValidatorUtil.MESSAGE_VALID.equals(addressErrorMessage)) {
            return addressErrorMessage;
        }
        Long telephon;
        try {
            telephon = Long.parseLong(telephone);
        }catch (NumberFormatException ex){
            return "Field experience contains only numbers";
        }
        String telephoneErrorMessage = FieldValidatorUtil.validateTelephone(telephon);
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
