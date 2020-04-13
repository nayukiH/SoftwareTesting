import org.junit.Assert;
import org.junit.Test;

public class BubbleSortTest {
	@Test
	public void test() {
		BubbleSort bub = new BubbleSort();
		int arr[] = new int[] {1,6,2,2,5};
		int a[] = new int[] {1,2,2,5,6};
		Assert.assertArrayEquals(a, bub.BubbleSort(arr));
	}

}
