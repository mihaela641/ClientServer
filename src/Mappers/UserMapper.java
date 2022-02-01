package Mappers;
import java.sql.*;
import java.util.Scanner;

public class UserMapper {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        //String input = console.nextLine();
        int[] trueArray = {6,4,3,2,6};
        int[] falseArray = {5,3,2,1,6};

        //firstLast6(falseArray);
        // countYZ(input);
        countEvens(falseArray);


    }

    public static boolean firstLast6(int[] nums) {

        int firstElement = nums[0];
        int lastElement = nums[nums.length - 1];
        if (firstElement == 6 && lastElement == 6) {
            System.out.println("True");
            return true;
        }
        return false;
    }

    public static int countYZ(String str) {
        int counter = 0;
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(str.length() - 1) == 'y' || str.charAt(str.length() - 1) == 'z'){
                counter++;
            }
        }
        System.out.println(counter);
        return counter;
    }

    public static int countEvens(int[] nums) {
        int counter = 0;
        for (int i = 0; i <= nums.length - 1; i++) {
            if(nums[i] % 2 == 0) {
                counter++;
            }

        }
        System.out.println(counter);
        return counter;
    }

}
