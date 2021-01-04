package leetcood.sort;

import java.util.Arrays;

/**
 * @description: 计数排序
 * @author st14762
 *
 */
public class CountingSort implements IArraySort {

	public int[] sort(int[] sourceArray) throws Exception {
		// 对 arr 进行拷贝，不改变参数内容
		int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

		int maxValue = getMaxValue(arr);

		return countingSort(arr, maxValue);
	}

	private int[] countingSort(int[] arr, int maxValue) {
		int bucketLen = maxValue + 1;
		int[] bucket = new int[bucketLen];

		for (int value : arr) {
			bucket[value]++;
		}

		int sortedIndex = 0;
		for (int j = 0; j < bucketLen; j++) {
			while (bucket[j] > 0) {
				arr[sortedIndex++] = j;
				bucket[j]--;
			}
		}
		return arr;
	}

	private int getMaxValue(int[] arr) {
		int maxValue = arr[0];
		for (int value : arr) {
			if (maxValue < value) {
				maxValue = value;
			}
		}
		return maxValue;
	}

}