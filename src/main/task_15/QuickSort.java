package main.task_15;

public class QuickSort {

    // Предусловие P: arr.length > 0, то есть массив не пуст && low >= 0 && high < arr.length.
    // Постусловие Q: массив arr[low; high] отсортирован в неубывающем порядке.
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    // Предусловие P: arr.length > 0, то есть массив не пуст && low >= 0 && high < arr.length.
    // Постусловие Q: все элементы слева от pivot меньше или равны arr[pivot]
    //                  && все элементы справа больше или равны arr[pivot].
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            // после итерации все элементы <= pivot будут слева от i
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

}
