import java.util.Random;

public class ENCDEC {
//Функція для зашифрування вхідного повіжомлення
    public static String getCodeString(String text, char firs, char last) {
        char [] alfabet = new char[last - firs + 1];
        int ind = 0;
        for (char i = firs; i <= last; i++) {
            alfabet[ind++] = i;
        }
        Random rndGen = new Random(System.currentTimeMillis());
        ind = 1;
        StringBuilder newStr = new StringBuilder();
        for (char chrStr : text.toLowerCase().toCharArray()){
            if (ind % 2 == 0)
                newStr.append(alfabet[rndGen.nextInt(last - firs + 1)]).append(chrStr).append(alfabet[rndGen.nextInt(last - firs + 1)]);
            else newStr.append(chrStr);
            ind++;
        }
        return newStr.toString();
    }
//Функція для розшифрування вхідного повідомлення
    public static String getModiffString(String sourceStr) {
        StringBuilder charBox = new StringBuilder();
        int counter = 0;
        while (counter < sourceStr.length()) {
            charBox.append(sourceStr.charAt(counter));
            counter += 2;
        }
        return charBox.toString();
    }
}