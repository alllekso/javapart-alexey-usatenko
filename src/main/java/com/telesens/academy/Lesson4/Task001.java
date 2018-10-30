package com.telesens.academy.Lesson4;

public class Task001 {
    public static void main(String[] args) {
        String testData = "petrov,Ivanov ,KiRill,    Helen    ";
        String[] rawNames = splitDataToArray(testData);
        printArray(rawNames);
        String[] formattedNames = formatNames(rawNames);
        printArray(formattedNames);
        String filteredData = filterByFirstSymbol(formattedNames, 'k');
        System.out.println(filteredData);

    }

    private static String filterByFirstSymbol(String[] formattedNames, char symb) {
        StringBuilder sb = new StringBuilder();
        for (String name : formattedNames) {
            if (name.charAt(0) != symb)
                sb.append(name + " ");
        }return sb.toString();
    }

    private static String[] formatNames(String[] rawNames) {
        String[] formattedNames = new String[rawNames.length];
        for (int i = 0; i < rawNames.length; i++){
            formattedNames[i] = formatName(rawNames[i]);
        }
        return formattedNames;
    }

    private static String formatName(String rawName) {
        String noSpaces = rawName.trim();
        String apperFirst = noSpaces.substring(0,1);
        String lowerWord = noSpaces.substring(0,1);
        return apperFirst + lowerWord;

    }

    private static void printArray(String[] rawNames) {
        //1
      //  System.out.println(rawNames);
        //2
        for (int i = 0; i < rawNames.length; i++){
            System.out.println(rawNames[i]);
        }
        //3
   //     for (String element : rawNames) {
    //        System.out.println(element);
      //  }
        //4
    //    System.out.println(Arrays.toString(rawNames));

   }

    private static String[] splitDataToArray(String testData) {
        String[] words = testData.split(",");
        return words;
    }

}






