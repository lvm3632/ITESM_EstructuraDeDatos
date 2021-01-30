
import java.util.Arrays;

public class AscendingHeap {
	private Integer[] heapData;
	private int currentPosition = -1;
	
	public AscendingHeap(int size) {
		this.heapData = new Integer[size];
	}
	
	public void insert(int item) {
		if (isFull()) 
			throw new RuntimeException("Heap is full");
		this.heapData[++currentPosition] = item;
		fixUp(currentPosition);
	}
	
	public int deleteRoot() {
		int result = heapData[0];
		heapData[0] = heapData[currentPosition--];
		heapData[currentPosition+1] = null;
		fixDown(0);
		return result;
	}
	
	private void fixDown(int index) {
		while (index <= currentPosition) {
			int leftChild = 2 * index + 1;
			int rightChild = 2 * index + 2;
			if (leftChild <= currentPosition) {
				int childToSwap;
				if (rightChild > currentPosition)
					childToSwap = leftChild;
				else
					childToSwap = (heapData[leftChild] < heapData[rightChild]) ? leftChild : rightChild;
				
				if (heapData[index] > heapData[childToSwap]) {
					int tmp = heapData[index];
					heapData[index] = heapData[childToSwap];
					heapData[childToSwap] = tmp;
				} else {
					break;
				}
				index = childToSwap;
			} else {
				break;
			}
			
		}
	}
	
	private void fixUp(int index) {
		int i = (index-1)/2; //parent index
		while (i >= 0 && heapData[i] > heapData[index]) {
			int tmp = heapData[i];
			heapData[i] = heapData[index];
			heapData[index] = tmp;
			index = i;
			i = (index-1)/2;
		}
	}
	
	private boolean isFull() {
		return currentPosition == heapData.length-1;
	}
	
	public static void main(String[] args) {
		AscendingHeap heap = new AscendingHeap(11);
		heap.insert(15);
		heap.insert(60);
		heap.insert(72);
		heap.insert(70);
		heap.insert(56);
		heap.insert(32);
		heap.insert(62);
		heap.insert(92);
		heap.insert(45);
		heap.insert(30);
		heap.insert(65);
		heap.fixDown(3);
		System.out.println(Arrays.deepToString(heap.heapData));
	}

}
