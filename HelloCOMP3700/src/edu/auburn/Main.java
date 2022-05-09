package edu.auburn;


public class Main {

    public boolean binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length-1;

        while (start <= end) {
            int mid = start + (end-start)/2;

                if (arr[mid] == target) return true;
                else if (arr[mid] > target) end = mid-1;
                else start = mid+1;
        }
        return false;
    }

    public static void main(String[] args) {
    Main m = new Main();
    System.out.println((m.binarySearch(new int[] {1,2,3,4,5}, 2)));
    }
}
