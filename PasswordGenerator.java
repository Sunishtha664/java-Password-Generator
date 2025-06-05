import java.util.Random;

public class PasswordGenerator {
    public static final String LOWERCASE_CHARACTERS= "abcdefghijklmnopqrstuvwxyz";
    public static final String UPPERCASE_CHARACTERS= "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String NUMBERS = "0123456789";
    public static final String SPECIAL_CHARACTERS= "!@#$%^&*()_-+=[]{};:',./<>?|";

    public static Random random = null;
    public PasswordGenerator() {random = new Random();}

    public static String generatePassword(int length, boolean includeUppercase, boolean includeLowercase
            , boolean includeNumbers, boolean includeSpecialSymbols) {
        StringBuilder passwordBuilder = new StringBuilder();

        //store valid characters
        String validCharacters="";
        if (includeUppercase) validCharacters+=UPPERCASE_CHARACTERS;
        if (includeLowercase) validCharacters+=LOWERCASE_CHARACTERS;
        if (includeNumbers) validCharacters+=NUMBERS;
        if (includeSpecialSymbols) validCharacters+=SPECIAL_CHARACTERS;

        //build password
        for (int i = 0; i < length; i++) {
            //generate a random index
            int randomIndex = random.nextInt(validCharacters.length());

            //get character based on random index
            char randomChar = validCharacters.charAt(randomIndex);
            passwordBuilder.append(randomChar);
    // do this until we have reached the length user has provided to us
        }

    return passwordBuilder.toString();
    }
}
