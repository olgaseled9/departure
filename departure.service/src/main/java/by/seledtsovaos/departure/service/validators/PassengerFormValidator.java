package by.seledtsovaos.departure.service.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import by.seledtsovaos.departure.service.dto.PassengerDto;

import static by.seledtsovaos.departure.service.validators.ErrorMessagesConstant.ERROR_MESSAGE_PASSENGER_LENGTH;
import static by.seledtsovaos.departure.service.validators.ErrorMessagesConstant.ERROR_MESSAGE_PASSENGER_PATTERN;
import static by.seledtsovaos.departure.service.validators.FieldConstant.FIRSTNAME_FIELD;
import static by.seledtsovaos.departure.service.validators.FieldConstant.FLIGHT_ID;
import static by.seledtsovaos.departure.service.validators.FieldConstant.LASTNAME_FIELD;
import static by.seledtsovaos.departure.service.validators.FieldConstant.PATRONYMIC_FIELD;

/**
 * Passenger's form validator.
 */
@Component
public class PassengerFormValidator implements Validator {

    /**
     * Regular expressions for input validation to firstname, lastname, patronymic on employee update page.
     */
    public static final String PATTERN_TO_UPDATE_PASSENGER_PAGE = "[A-Za-zА-Яа-яЁё\\s-]*";

    @Override
    public boolean supports(Class<?> clazz) {
        return PassengerDto.class.equals(clazz);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        PassengerDto passengerDto = (PassengerDto) obj;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, LASTNAME_FIELD, "lastname.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, FIRSTNAME_FIELD, "firstname.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, PATRONYMIC_FIELD, "patronymic.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, FLIGHT_ID, "flightId.required");


        if (isInvalidString(passengerDto.getLastname())) {
            errors.rejectValue(LASTNAME_FIELD, "lastname.pattern", new Object[] {"'lastname'"},
                ERROR_MESSAGE_PASSENGER_PATTERN);
        }
        if (isInvalidString(passengerDto.getFirstname())) {
            errors.rejectValue(FIRSTNAME_FIELD, "firstname.pattern", new Object[] {"'firstname'"},
                ERROR_MESSAGE_PASSENGER_PATTERN);
        }
        if (isInvalidString(passengerDto.getPatronymic())) {
            errors.rejectValue(PATRONYMIC_FIELD, "patronymic.pattern", new Object[] {"'patronymic'"},
                ERROR_MESSAGE_PASSENGER_PATTERN);
        }
        if (passengerDto.getLastname().length() > 30) {
            errors.rejectValue(LASTNAME_FIELD, "lastname.length", new Object[] {"'lastname'"},
                ERROR_MESSAGE_PASSENGER_LENGTH);
        }
        if (passengerDto.getFirstname().length() > 30) {
            errors.rejectValue(FIRSTNAME_FIELD, "firstname.length", new Object[] {"'firstname'"},
                ERROR_MESSAGE_PASSENGER_LENGTH);
        }
        if (passengerDto.getPatronymic().length() > 30) {
            errors.rejectValue(PATRONYMIC_FIELD, "patronymic.length", new Object[] {"'patronymic'"},
                ERROR_MESSAGE_PASSENGER_LENGTH);
        }
    }

    /**
     * Check whether the input parameter into the field name matches the regex condition.
     * @param someParameter which has entered into the field name on the update task page
     * @return true, if the string is non-empty and matches the regex condition
     */
    private boolean isInvalidString(String someParameter) {
        return !someParameter.matches(PATTERN_TO_UPDATE_PASSENGER_PAGE);
    }
}
