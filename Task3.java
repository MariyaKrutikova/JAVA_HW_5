/*Реализовать алгоритм пирамидальной сортировки (HeapSort).*/

public class Task3 {
    // Управляющая программа
    public static void main(String args[]) {
        int arr[] = {15, 26, 11, 13, 6, 8, 7, 37};
        printArray(arr);

        sort(arr);
        printArray(arr);
    }
        
    // Метод, сортирующий массив
    private static void sort(int arr[]) {
        int n = arr.length;

        // Создание кучи
        for (int i = n / 2 - 1; i >= 0; i--)
            doHeap(arr, n, i);

        // Начиная с последнего элемента кучи меняем его с верхним элементом кучи.  
        for (int i=n-1; i>=0; i--) {
           
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Уменьшаем кучу
            doHeap(arr, i, 0);
        }
    }

    // Метод создания кучи из массива. Аргументы - массив, длина массива, индекс элемента.
     private static void doHeap(int arr[], int n, int i) {
        int maxElement = i; 
        int left = 2*i + 1; 
        int right = 2*i + 2; 
                   
        if (left < n && arr[left] > arr[maxElement])
            maxElement = left;

        if (right < n && arr[right] > arr[maxElement])
            maxElement = right;

        if (maxElement != i) {
            int bascket = arr[i];
            arr[i] = arr[maxElement];
            arr[maxElement] = bascket;
            doHeap(arr, n, maxElement);
        }
    }

    private static void printArray(int arr[]) {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
   
}