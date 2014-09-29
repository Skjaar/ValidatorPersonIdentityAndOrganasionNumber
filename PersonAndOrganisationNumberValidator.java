

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class PersonAndOrganisationNumberValidator {

    public boolean isPersonlIdentityNumberValid(String number) {
        if (number == null)
            return false;
        if (isCheckNumberLength(number))
            return false;
        if (isCheckDigits(number))
            return false;
        if (isValidDate(number))
            return false;
        if (isCheckControlDigit(number))
            return false;

        return true;
    }

    public boolean isOrganisationNumberValid(String number) {

        if (number == null)
            return false;
        if (isCheckNumberLength(number))
            return false;
        if (isCheckDigits(number))
            return false;
        if (isOrganisationNumberMonthCorrect(number))
            return false;
        if (isCheckControlDigit(number))
            return false;

        return true;
    }

    private boolean isOrganisationNumberMonthCorrect(String number) {
        int month = Integer.parseInt(number.substring(4, 6));
        return month > 0 && month < 13;
    }

    private boolean isValidDate(String number) {
        DateFormat formatter = new SimpleDateFormat("yyMMdd");
        formatter.setLenient(false);
        try {
            formatter.parse(number.substring(2, 8));
        } catch (ParseException e) {
            return true;
        }
        return false;
    }

    private boolean isCheckControlDigit(String number) {
        int multiply = 2;
        int sum = 0;
        for (int i = 2; i < 11; ++i) {
            int numberAtWork = Character.digit(number.charAt(i), 10) * multiply;
            multiply = multiply == 1 ? 2 : 1;
            if (numberAtWork > 9) {
                numberAtWork -= 9;
            }
            sum += numberAtWork;
        }
        return (1000 - sum) % 10 != Character.digit(number.charAt(11), 10);
    }

    private boolean isCheckDigits(String number) {
        for (int i = 0; i < 12; ++i) {
            if (!Character.isDigit(number.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private boolean isCheckNumberLength(String number) {
        return number.length() != 12;
    }
}