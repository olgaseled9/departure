package by.seledtsovaos.departure.service.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import by.seledtsovaos.departure.service.dto.FlightDto;

import static by.seledtsovaos.departure.service.validators.ErrorMessagesConstant.ERROR_MESSAGE_LENGTH;
import static by.seledtsovaos.departure.service.validators.FieldConstant.AIRPORT_NAME_FIELD;
import static by.seledtsovaos.departure.service.validators.FieldConstant.COUNTRY_FIELD;
import static by.seledtsovaos.departure.service.validators.FieldConstant.FLIGHT_NUMBER_FIELD;

/**
 * Airport's form validator.
 */
@Component
public class FlightFormValidator implements Validator {


    @Override
    public boolean supports(Class<?> clazz) {
        return FlightDto.class.equals(clazz);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        FlightDto flightDto = (FlightDto) obj;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, FLIGHT_NUMBER_FIELD, "flightNumber.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, COUNTRY_FIELD, "country.required");

        if (flightDto.getFlightNumber().length() > 100) {
            errors.rejectValue(AIRPORT_NAME_FIELD, "flightNumber.length", new Object[] {"'flightNumber'"},
                ERROR_MESSAGE_LENGTH);
        }
    }
}
