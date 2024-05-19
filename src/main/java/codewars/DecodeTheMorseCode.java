package codewars;


public class DecodeTheMorseCode {


    //TODO: переписать на стримы
    public static String decode(String morseCode) {
        StringBuilder builder = new StringBuilder();

        for (String word : morseCode.split(" {3}")) {
            for (String letter : word.split(" ")) {
                if (!letter.trim().isEmpty()) {
                    builder.append(MorseCode.get(letter));
                }
            }
            builder.append(" ");
        }
        return builder.toString().trim();
    }

    //Mock class and method
    private static class MorseCode {
        public static String get(String letter) {
            return null;
        }
    }

}
