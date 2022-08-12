package by.seledtsovaos.departure.service.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import by.seledtsovaos.departure.service.dto.AirportDto;

import static by.seledtsovaos.departure.service.validators.ErrorMessagesConstant.ERROR_MESSAGE_LENGTH;
import static by.seledtsovaos.departure.service.validators.FieldConstant.AIRPORT_NAME_FIELD;
import static by.seledtsovaos.departure.service.validators.FieldConstant.COUNTRY_FIELD;

/**
 * Airport's form validator.
 */
@Component
public class AirportFormValidator implements Validator {


    @Override
    public boolean supports(Class<?> clazz) {
        return AirportDto.class.equals(clazz);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        AirportDto airportDto = (AirportDto) obj;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, AIRPORT_NAME_FIELD, "airportName.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, COUNTRY_FIELD, "country.required");

        if (airportDto.getAirportName().length() > 100) {
            errors.rejectValue(AIRPORT_NAME_FIELD, "airport.length", new Object[] {"'airportName'"},
                ERROR_MESSAGE_LENGTH);
        }
    }
}
