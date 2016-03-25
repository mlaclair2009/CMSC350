package wk2discussion;

public class ArrayStack <T> {
	
    T[] a;
    T[] b;
    int n;
    int size() {
       return n;}
        
    ArrayStack(int size) {	  
		a = (T[]) new Object[size]; 
    }

	T get(int i) {
        if (i < 0 || i > n - 1) throw new IndexOutOfBoundsException();
        return a[i];
    }
    
    T set(int i, T x) {
        if (i < 0 || i > n - 1) throw new IndexOutOfBoundsException();
        T y = a[i];
        a[i] = x;
        return y;
    }

    void add(int i, T x) {
        if (i < 0 || i > n) throw new IndexOutOfBoundsException();
        if (n + 1 > a.length) resize();
        for (int j = n; j > i; j--) 
            a[j] = a[j-1];
        a[i] = x;
        n++;
    }
    
    T remove(int i) {
        if (i < 0 || i > n - 1) throw new IndexOutOfBoundsException();
        T x = a[i];
        for (int j = i; j < n-1; j++) 
            a[j] = a[j+1];
        n--;
        if (a.length >= 3*n) resize();
        return x;
    }
    
    void resize() {
        b = (T[]) new Object[Math.max(n*2,1)];
        for (int i = 0; i < n; i++) {
            b[i] = a[i];
        }
        a = b;
    }
    
    void display(){
    for (int i = 0; i < a.length; i++)
    	if (a[i] == null){
    		System.out.print(" ");
    	} else{
        System.out.print(a[i] + " ");
    	}
     System.out.println();
 }
}


