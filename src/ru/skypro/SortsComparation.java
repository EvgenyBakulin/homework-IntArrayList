package ru.skypro;

public class SortsComparation {
    public int[] array;

    public SortsComparation() {
        this.array = generateRandomArray();
    }
    private void sortBubble(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swapElements(arr, j, j + 1);
                }
            }
        }
    }

    private void selectSort(int[]arr) {
        for (int i = 0; i < arr.length-1; i++) {
            int minIndex = i;
            for (int j=i+1;j<arr.length;j++) {
                if(arr[j]<arr[minIndex]) {
                    minIndex = j;
                }
            }
            swapElements(arr,i,minIndex);
        }
    }

    private void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }

    public void mostQuickSort(){
        int [] arrCopy1 = new int[array.length];
        System.arraycopy(array, 0, arrCopy1, 0, array.length);
        long start1 = System.currentTimeMillis();
        sortBubble(arrCopy1);
        System.out.println("Пузырьковая сортировка:");
        System.out.println(System.currentTimeMillis() - start1);
        int [] arrCopy2 = new int[array.length];
        System.arraycopy(array, 0, arrCopy2, 0, array.length);
        long start2 = System.currentTimeMillis();
        selectSort(arrCopy2);
        System.out.println("Сортировка выбором:");
        System.out.println(System.currentTimeMillis() - start2);
        int [] arrCopy3 = new int[array.length];
        System.arraycopy(array, 0, arrCopy3, 0, array.length);
        long start3 = System.currentTimeMillis();
        insertSort(arrCopy3);
        System.out.println("Сортировка вставками: ");
        System.out.println(System.currentTimeMillis() - start3);
    }
    private void swapElements(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public static int[] generateRandomArray() {
        java.util.Random random = new java.util.Random();
        int [] arr = new int[100000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100_000) + 300_000;
        }
        return arr;
    }
}
