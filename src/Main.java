import java.util.*;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> carNumbers = new ArrayList<>();
        HashSet<String> hashSet = new HashSet<>();
        TreeSet<String> treeSet = new TreeSet<>();
        Scanner scanner = new Scanner(System.in);
        String[] letters = {"А", "В", "Е", "К", "М", "Н", "О", "Р", "С", "Т", "У", "Х"};
        String[] numbers = {"000", "111", "222", "333", "444", "555", "666", "777", "888", "999"};
        String[] regions = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12",
                "13", "14", "15", "16", "17", "18", "19", "21", "22", "23", "24", "25", "26", "27",
                "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41",
                "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55",
                "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69",
                "70", "71", "72", "73", "74", "75", "76", "77", "80", "81", "82", "84", "88", "90",
                "91", "93", "96", "97", "113", "116", "121", "122", "123", "124", "125", "126", "127",
                "134", "136", "138", "142", "147", "150", "152", "154", "155", "156", "159", "161",
                "163", "164", "169", "173", "174", "190", "193", "196", "197", "199", "716", "750", "761",
                "763", "774", "777", "790"};
        int counter = 0;

        for (int letter = 0; letter < letters.length; letter++) {
            String lettersFirst = letters[letter];
            for (int number = 0; number < numbers.length; number++) {
                String threeNums = numbers[number];
                for (int letterCode = 0; letterCode < letters.length; letterCode++) {
                    String threeLetters = letters[letterCode] + letters[letterCode] + letters[letterCode];
                    for (int region = 0; region < regions.length; region++) {
                        String regionAdd = regions[region];
                        StringBuilder beautyNumber = new StringBuilder();
                        beautyNumber.append(lettersFirst);
                        beautyNumber.append(threeNums);
                        beautyNumber.append(threeLetters);
                        beautyNumber.append(regionAdd);
                        carNumbers.add(String.valueOf(beautyNumber));
                        counter++;
                    }
                }
            }
        }

        hashSet.addAll(carNumbers);
        treeSet.addAll(carNumbers);

        for (int i = 0; i < carNumbers.size(); i++) {
            System.out.println(carNumbers.get(i));
        }
        System.out.println(counter);

        String searchNumber;

        do {
            System.out.println("Введите искомый номер: ");
            searchNumber = scanner.nextLine();
            long start = System.currentTimeMillis();
            if (carNumbers.contains(searchNumber)) {
                long end = System.currentTimeMillis() - start;
                System.out.println("Номер найден методом list.contains за " + end);
            } else {
                System.out.println("Номер не был найден методом list.contains");
            }
            long start2 = System.currentTimeMillis();
            Collections.sort(carNumbers);
            if (Collections.binarySearch(carNumbers, searchNumber) >= 0) {
                long end2 = System.currentTimeMillis() - start2;
                System.out.println("Номер найден бинарным методом за : " + end2);
            } else {
                System.out.println("Номер не был найден бинарным методом");
            }
            long start3 = System.currentTimeMillis();
            if (treeSet.contains(searchNumber)) {
                long end3 = System.currentTimeMillis() - start3;
                System.out.println("Номер найден в TreeSet методом contains за : " + end3);
            } else {
                System.out.println("Номер не был найден методом TreeSet");

            }
            long start4 = System.currentTimeMillis();
            if (hashSet.contains(searchNumber)) {
                long end4 = System.currentTimeMillis() - start4;
                System.out.println("Номер найден в HashSet методом contains за : " + end4);
            } else {
                System.out.println("Номер не был найден методом HashSet");
            }

        } while (!Objects.equals(searchNumber, "Стоп"));
    }
}