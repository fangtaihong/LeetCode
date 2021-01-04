package leetcood.sort;

import java.util.Arrays;

/**
 * @description: ��������
 * @author st14762
 *
 */
public class InsertSort implements IArraySort {

	public int[] sort(int[] sourceArray) throws Exception {
		// �� arr ���п��������ı��������
		int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

		// ���±�Ϊ1��Ԫ�ؿ�ʼѡ����ʵ�λ�ò��룬��Ϊ�±�Ϊ0��ֻ��һ��Ԫ�أ�Ĭ���������
		for (int i = 1; i < arr.length; i++) {

			// ��¼Ҫ���������
			int tmp = arr[i];

			// ���Ѿ�������������ұߵĿ�ʼ�Ƚϣ��ҵ�����С����
			int j = i;
			while (j > 0 && tmp < arr[j - 1]) {
				arr[j] = arr[j - 1];
				j--;
			}

			// ���ڱ���С����������
			if (j != i) {
				arr[j] = tmp;
			}

		}
		return arr;
	}
}