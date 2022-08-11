package by.seledtsovaos.departure.service.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import by.seledtsovaos.departure.service.dto.PassengerDto;

/**
 * Passenger's form validator.
 */
@Component
public class PassengerFormValidator implements Validator {


    /**
     * Regular expressions for input validation to firstname, lastname, patronymic on employee update page.
     */
    public static final String PATTERN_TO_UPDATE_EMPLOYEE_PAGE = "[A-Za-zА-Яа-яЁё\\s-]{1,30}";

    @Override
    public boolean supports(Class<?> clazz) {
        return PassengerDto.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        PassengerDto passengerDto = (PassengerDto) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastname", "lastname.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstname", "firstname.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "patronymic", "patronymic.required");

//        if (GenericConverter.isInvalidString(passengerDto.getLastname(), PATTERN_TO_UPDATE_EMPLOYEE_PAGE)) {
//            passengerDto.getLastname();
//            errors.reject("lastname", "lastname.pattern");
//        }
//        if (passengerDto.getLastname().length() > 30) {
//            errors.reject("lastname.pattern");
//        }
    }
}
