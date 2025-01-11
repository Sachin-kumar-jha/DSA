package ARRAY.Sorting;

class Heapsort {
    // Heap sort contains two step
    // first-Create Max heap
    // second-Delete From max heap
    // Creating Max heap

    public static void maxHeap(int arr[], int n, int i) {
        int largest = i;
        int l = 2 * i + 1; // Left child index
        int r = 2 * i + 2; // Right child index
        if (l < n && arr[l] > arr[largest]) {
            largest = l;
        }
        if (r < n && arr[r] > arr[largest]) {
            largest = r;
        }

        if (largest != i) {
            int temp = arr[largest];
            arr[largest] = arr[i];
            arr[i] = temp;

            maxHeap(arr, n, largest);
        }
    }

    public static void heapSort(int arr[], int n) {
        for (int i = n / 2 - 1; i >= 0; i--) {
            maxHeap(arr, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            maxHeap(arr, i, 0);
        }
    }

    public static void main(String args[]) {
        int[] arr = { 15, 5, 20, 1, 17, 10, 30 };
        int n = arr.length;
        heapSort(arr, n);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
