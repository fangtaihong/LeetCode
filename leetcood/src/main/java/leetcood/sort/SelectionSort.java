package leetcood.sort;

import java.util.Arrays;

/**
 * @description: ѡ������
 * @author st14762
 *
 */
public class SelectionSort implements IArraySort {

	public int[] sort(int[] sourceArray) throws Exception {
		int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

		// �ܹ�Ҫ���� N-1 �ֱȽ�
		for (int i = 0; i < arr.length - 1; i++) {
			int min = i;

			// ÿ����Ҫ�ȽϵĴ��� N-i
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[min]) {
					// ��¼Ŀǰ���ҵ�����СֵԪ�ص��±�
					min = j;
				}
			}

			// ���ҵ�����Сֵ��iλ�����ڵ�ֵ���н���
			if (i != min) {
				int tmp = arr[i];
				arr[i] = arr[min];
				arr[min] = tmp;
			}

		}
		return arr;
	}
}
