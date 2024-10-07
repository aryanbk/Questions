class ZeroEvenOdd {
    private int n;
    volatile int i = 1;
    Semaphore zeroSmph;
    Semaphore oddSmph;
    Semaphore evenSmph;
    
    public ZeroEvenOdd(int n) {
        this.n = n;
        zeroSmph = new Semaphore(1);
        oddSmph = new Semaphore(0);
        evenSmph = new Semaphore(0);
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for(int x=0; x<n; ++x){
            zeroSmph.acquire();
            printNumber.accept(0);
            if(i%2==0) evenSmph.release();
            else oddSmph.release();
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for(int x=2; x<=n; x+=2){
            evenSmph.acquire();
            printNumber.accept(i++);
            zeroSmph.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for(int x=1; x<=n; x+=2){
            oddSmph.acquire();
            printNumber.accept(i++);
            zeroSmph.release();
        }
    }
}