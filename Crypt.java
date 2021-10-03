package Crypt;

import java.util.Scanner;

public class Crypt {
    char[] upperSymbols = new char[]{
            'А', 'Б', 'В', 'Г', 'Ґ', 'Д', 'Е', 'Є', 'Ж',
            'З', 'И', 'І', 'Ї', 'Й', 'К', 'Л', 'М', 'Н',
            'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц',
            'Ч', 'Ш', 'Щ', 'Ь', 'Ю', 'Я'
    };
    char[] lowerSymbols = new char[]{
            'а', 'б', 'в', 'г', 'ґ', 'д', 'е',
            'є', 'ж', 'з', 'и', 'і', 'ї', 'й',
            'к', 'л', 'м', 'н', 'о', 'п', 'р',
            'с', 'т', 'у', 'ф', 'х', 'ц', 'ч',
            'ш', 'щ', 'ь', 'ю', 'я'
    };
    int key;
    String text;

    // новая строка
    StringBuilder newString = new StringBuilder();
    char c;
    char y;

    public StringBuilder cryptCaesar(int key, String text) {

        // перебираем строку
        for (int i = 0; i < text.length(); i++) {
            c = (text.charAt(i));
            if (Character.isUpperCase(c)) {
                for (int j = 0; j < upperSymbols.length; j++) {

                    // если j+key В сумме меньше кол-ва букв в нашем алфавите
                    if (j + key <= 32) {
                        if (upperSymbols[j] == c) {
                            y = upperSymbols[j + key];
                            newString.append(y);
                        }
                    }

                    // если j+key В сумме больше кол-ва букв в нашем алфавите
                    if (j + key > 32) {
                        if (upperSymbols[j] == c) {
                            y = upperSymbols[j + key - 33];
                            newString.append(y);
                        }
                    }
                }
            } else if (Character.isLowerCase(c)) {
                for (int k = 0; k < lowerSymbols.length; k++) {
                    if (k + key <= 32) {
                        if (lowerSymbols[k] == c) {
                            y = lowerSymbols[k + key];
                            newString.append(y);
                        }
                    }
                    if (k + key > 32) {
                        if (lowerSymbols[k] == c) {
                            y = lowerSymbols[k + key - 33];
                            newString.append(y);
                        }
                    }
                }
            }


        }
        return newString;
    }

    public StringBuilder decrypt(int key, String cryptText) {
        for (int i = 0; i < cryptText.length(); i++) {
            c = (cryptText.charAt(i));
            if (Character.isUpperCase(c)) {
                for (int j = 0; j < upperSymbols.length; j++) {

                    // если j+key В сумме меньше кол-ва букв в нашем алфавите
                    if (j - key < 0) {
                        if (upperSymbols[j] == c) {
                            y = upperSymbols[j - key + 33];
                            newString.append(y);
                        }
                    } else {
                        if (upperSymbols[j] == c) {
                            y = upperSymbols[j - key];
                            newString.append(y);
                        }
                    }


                }
            } else if (Character.isLowerCase(c)) {
                for (int k = 0; k < lowerSymbols.length; k++) {
                    if (k - key < 0) {
                        if (lowerSymbols[k] == c) {
                            y = lowerSymbols[k - key + 33];
                            newString.append(y);
                        }
                    } else {
                        if (lowerSymbols[k] == c) {
                            y = lowerSymbols[k - key];
                            newString.append(y);
                        }
                    }
                }
            }


        }
        return newString;
    }

    public static void main(String[] args) {
        Crypt crypt = new Crypt();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ключ: ");
        crypt.key = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Введите текст: ");
        crypt.text = scanner.nextLine();
        System.out.println("Результат = " + crypt.decrypt(crypt.key, crypt.text));
    }
}


