package leetcood.sort;

import java.util.Arrays;

import org.junit.Test;

public class SortTest {

	int[] arr = { 5, 6, 3, 1, 8, 7, 2, 4 };

	@Test
	public void bubbleSort() throws Exception {
		BubbleSort sort = new BubbleSort();
		int[] newArr = sort.sort(arr);
		System.out.println(Arrays.toString(newArr));
	}

	@Test
	public void selectionSort() throws Exception {
		SelectionSort sort = new SelectionSort();
		int[] newArr = sort.sort(arr);
		System.out.println(Arrays.toString(newArr));
	}

	@Test
	public void insertSort() throws Exception {
		InsertSort sort = new InsertSort();
		int[] newArr = sort.sort(arr);
		System.out.println(Arrays.toString(newArr));
	}

	@Test
	public void shellSort() throws Exception {
		ShellSort sort = new ShellSort();
		int[] newArr = sort.sort(arr);
		System.out.println(Arrays.toString(newArr));
	}

	@Test
	public void mergeSort() throws Exception {
		MergeSort sort = new MergeSort();
		int[] newArr = sort.sort(arr);
		System.out.println(Arrays.toString(newArr));
	}

	@Test
	public void quickSort() throws Exception {
		QuickSort sort = new QuickSort();
		int[] newArr = sort.sort(arr);
		System.out.println(Arrays.toString(newArr));
	}

	@Test
	public void heapSort() throws Exception {
		HeapSort sort = new HeapSort();
		int[] newArr = sort.sort(arr);
		System.out.println(Arrays.toString(newArr));
	}

	@Test
	public void countingSort() throws Exception {
		CountingSort sort = new CountingSort();
		int[] newArr = sort.sort(arr);
		System.out.println(Arrays.toString(newArr));
	}

	@Test
	public void BucketSort() throws Exception {
		BucketSort sort = new BucketSort();
		int[] newArr = sort.sort(arr);
		System.out.println(Arrays.toString(newArr));
	}

	@Test
	public void radixSort() throws Exception {
		RadixSort sort = new RadixSort();
		int[] newArr = sort.sort(arr);
		System.out.println(Arrays.toString(newArr));
	}

}
