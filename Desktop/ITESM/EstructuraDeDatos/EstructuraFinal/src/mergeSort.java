
public class mergeSort {
	
	public static void main(String[] args) {
		int[] a = {4,2,3};
		
		mergeSort(a);
		
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+",");
		}
		
	}
	
	public static void mergeSort(int[] a) {
		
		if(a.length > 1) {
			int n = a.length;
			int mid=a.length/2;
			int[] left=new int[mid];
			
			for (int i = 0; i < mid; i++) {
				left[i]=a[i];
			}
			mergeSort(left);
			
			int[] right=new int[n-mid];
	
			for (int i = mid; i < n; i++) {
				right[i-mid]=a[i];
			}
			mergeSort(right);
			mezcla(left,right,a);
		}
		
	}
	
	
	public static void mezcla(int[] l, int[] r, int[] a) {
		int i=0,j=0,k=0;
		//i -> left // j -> right // k -> a
		while(i<l.length && j < r.length) {
			if(l[i]<r[j]) {
				a[k++]=l[i++];
			}else {
				a[k++]=r[j++];
			}
			
		}
		while(i<l.length) {
			a[k++]=l[i++];
		}
		
		while(j<r.length) {
			a[k++]=r[j++];
		}
		
	}

}
