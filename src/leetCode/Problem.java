package leetCode;

import java.util.*;

public class Problem {

    public static int hammingWeight(int n) {

        int result = 0;
        String number = Integer.toBinaryString(n);
        for (int i = 0; i < number.length(); i++) {
            System.out.println(number.charAt(i));
            if ( number.charAt(i) == '1' ) {
                result = result + 1;
            }
        }
        return result;
    }

    public static double myPow(double x, int n) {
        double result = 1;
        if ( x == 0 ) {
            return 0;
        }
        if ( x == 1 ) {
            return 1;
        }
        if ( n > 0 ) {
            for (int i = 0; i < n; i++) {
                result = result * x;
            }
        } else {
            for (int i = 0; i > n; i--) {
                result = result / x;
            }
        }
        return result;
    }

    public static double myPow1(double x, int n) {
        double result = Math.pow(x, n);
        return result;
    }

    //    public int myAtoi(String s) {
//        String converter = s.replace(" ","");
//        converter.c
//    }
    public static int findDuplicate(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if ( !( list.contains(nums[i]) ) ) {
                list.add(nums[i]);
            } else {
                result = nums[i];
                break;
            }
        }
        return result;
    }

    public static int findDuplicate1(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if ( nums[i] == nums[j] && ( i != j ) ) {
                    result = nums[i];
                }
            }
        }
        return result;
    }


    public static boolean isHappy(int n) {
        List<Integer> integerList = new ArrayList<>();
        do {
            n = n / 10;
            integerList.add(n % 10);
        }
        while (n % 10 == 1);
        System.out.println(integerList);
        return true;
    }

    public static int numberOfSteps(int num) {
        int count = 0;
        while (num != 0) {
            if ( !( isOdd(num) ) ) {
                num = num - 1;
                count++;
            } else {
                num = num / 2;
                count++;
            }
        }
        return count;
    }

    public static int minMoves(int target, int maxDoubles) {
        int count = 0;
        if ( target == 1 ){
            return count;
        }
        if ( maxDoubles == 0 ){
            return count = target - 1;
        }
        do {
            if ( maxDoubles != 0 ) {
                if ( isOdd(target) ) {
                    target = target / 2;
                    maxDoubles--;
                } else {
                    target = target - 1;
                }
            } else {
                target = target - 1;
            }
            count++;
        } while (target != 1);
        return count;
    }

    public static boolean isOdd(int num) {
        if ( num % 2 == 0 ) {
            return true;
        } else return false;
    }
        public int maxLength(List<String> arr) {
            int highest = arr.get(0).length();
            for (int i = 0; i < arr.size()-1; i++){
                for (int j = i + 1;j < arr.size(); j++){
                   if ( highest < arr.get(i).length() + arr.get(j).length()){
                       highest = arr.get(i).length() + arr.get(j).length();
                   }
                }
            }
            return highest;
        }
    public static int romanToInt(String s) {
        Map<Character, Integer> characterToInt = new HashMap<>();
        characterToInt.put('I', 1);
        characterToInt.put('V', 5);
        characterToInt.put('X', 10);
        characterToInt.put('L', 50);
        characterToInt.put('C', 100);
        characterToInt.put('D', 500);
        characterToInt.put('M', 1000);

        String input = s.toUpperCase();
        int number = 0;
        for (int i = 0; i < input.length(); i++) {
            if (characterToInt.containsKey(input.charAt(i))) {
                int s1 = characterToInt.get(input.charAt(i));
                if (i + 1 < input.length()) {
                    int s2 = characterToInt.get(input.charAt(i + 1));
                    if (s1 >= s2) {
                        number = number + s1;
                    } else {
                        number = number - s1;
                    }
                } else {
                    number = number + s1;
                }
            }
        }
        if (number < 1 || number > 3999) {
            System.out.println("invalid Number: " + s);
        } else {
            return number;
        }
        return 0;
    }

    public static String intToRoman(int num) {
        List<String> romanNumber = new ArrayList<>();
        List<Integer> value = Arrays.asList(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1);
        List<String> character = Arrays.asList("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I");
        if (num >= 1 && num <= 3999) {
            for (int i = 0; i < value.size(); i++) {
                while (num >= value.get(i)) {
                    num = num - value.get(i);
                    romanNumber.add(character.get(i));
                }
            }
        }
        return String.join("", romanNumber);
    }

    public static int findMaxK(int[] nums) {
        int[] sortedNums = Arrays.stream(nums).sorted().toArray();
        int number = -1;
        for (int i = sortedNums.length - 1; i >= 0; i--) {
            for (int j = 0; j < sortedNums.length; j++) {
                if (-(sortedNums[i]) == sortedNums[j]) {
                    number = sortedNums[i];
                    return number;
                }
            }
        }
        return number;
    }
//1748. Sum of Unique Elements

//    public static int sumOfUnique(int[] nums) {
//
//        int[] sortedNums = Arrays.stream(nums).sorted().toArray();
//        int number = 0;
//        Arrays.stream(sortedNums).
//                map()
//        return number;
//    }

//    public static int[] findErrorNums(int[] nums) {
//            List<Integer> errorList = new ArrayList<>();
//            int[] sortedNums = Arrays.stream(nums).sorted().toArray();
//            for (int i = 0; i < nums.length; i++) {
//                if (sortedNums[i] == sortedNums[nums.length - i - 1]) {
//                    if (nums.length - i - 1 == nums.length -1 && sortedNums[i] - 1 > 0) {
//                        errorList.add(sortedNums[i]);
//                        errorList.add(sortedNums[i] - 1);
//                        sortedNums[i] = -1;
//                    } else {
//                        errorList.add(sortedNums[i]);
//                        errorList.add(sortedNums[i] + 1);
//                        sortedNums[i] = -1;
//                    }
//                }
//
//            }
//            return errorList.stream().mapToInt(i -> i).toArray();
//    }

    public int[] twoSum(int[] nums, int target) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++){
            for (int j = i +1; j < nums.length; j++){
                if (nums[i] + nums [j] == target ){
                    result.add(i);
                    result.add(j);
                    nums[i]= -1;
                    nums[j]= -1;
                }
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

    public int[] kWeakestRows(int[][] mat, int k) {
        List<Integer> result = new ArrayList<>();
        int sum = 0;
        List<Integer> soliderNumber = new ArrayList<>();
        for (int row = 0; row < mat.length; row++){
            for (int col = 0; col <mat[row].length; col ++){
                if (mat[row][col] == 1){
                    sum = sum + 1 ;
                }
            }
            soliderNumber.add(sum);
        }
        for (int i = 1; i < soliderNumber.size(); i ++){
            if (soliderNumber.get(i) > soliderNumber.get(i-1));
            result.add(soliderNumber.get(i -1));
        }
        return result.stream().mapToInt(i -> i).toArray();
    }


//    public static String generatePlate(){
//        List<Integer>plateNumberIndex = Arrays.asList(0,1,3,5,6,7,9,10);
//        ArrayList<String> plate = new ArrayList<>();
//        for (int i = 0;i < 11; i++ ){
//            if ( plateNumberIndex.contains(i)){
//                plate.add(generateNumber());
//            }
//            else if ( i == 2 ){
//                plate.add(i,generateString());
//            }
//            else if ( i == 4 ){
//                plate.add("-");
//            }
//            else if ( i == 8 ){
//                plate.add(".");
//            }
//        }
//        return String.join(" ", plate);
//
//    }
//    public static String generateNumber(){
//        return RandomStringUtils.randomNumeric(1);
//    }
//    public static String generateString(){
//        return RandomStringUtils.randomAlphanumeric(1).toUpperCase();
//
//    }
    public static void main(String[] args) {
        int[] a = new int[5];
        a[0] = 3;
        a[1] = 1;
        a[2] = 3;
        a[3] = 4;
        a[4] = 2;

        System.out.println(minMoves(0, 0));

    }
}
