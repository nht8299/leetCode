package leetCode;

import java.util.ArrayList;
import java.util.List;

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
