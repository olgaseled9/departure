package by.seledtsovaos.departure.service.converter;

/**
 * Converts a container of entity data object into a container of represented data object and back.
 * @param <I> represented data object
 * @param <O> display data object
 */
public interface GenericConverter<I, O> {

    /**
     * Converts from entity data object to represented data object.
     * @param entity  entity data
     * @return page's represented data object
     */
    I convertToDto(O entity);

    /**
     * Converts from display data object to represented data object.
     * @param entity represented data
     * @return entity data object
     */
    O convertBack(I entity);

    /**
     * Check whether the input parameter into the field name matches the regex condition.
     * @param someParameter which has entered into the field name on the update task page
     * @return true, if the string is non-empty and matches the regex condition
     */
    static boolean isInvalidString(String someParameter, String regex) {
        return someParameter.isEmpty() && someParameter.matches(regex);
    }
}

