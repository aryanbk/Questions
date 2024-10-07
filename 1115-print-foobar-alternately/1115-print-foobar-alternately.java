class FooBar {
    private int n;
    Semaphore fooSema;
    Semaphore barSema;
    
    public FooBar(int n) {
        this.n = n;
        fooSema = new Semaphore(1);
        barSema = new Semaphore(0);
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            
        	// printFoo.run() outputs "foo". Do not change or remove this line.
            fooSema.acquire();
        	printFoo.run();
            barSema.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            
            // printBar.run() outputs "bar". Do not change or remove this line.
            barSema.acquire();
        	printBar.run();
            fooSema.release();
        }
    }
}