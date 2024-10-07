class H2O {
    
    Semaphore smpH;
    Semaphore smpO;
    
    public H2O() {
        smpH = new Semaphore(2);
        smpO = new Semaphore(0);
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
		
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        smpH.acquire();
        releaseHydrogen.run();
        smpO.release(1);
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        smpO.acquire(2);
		releaseOxygen.run();
        smpH.release(2);
    }
}








// class H2O {
    
//     Semaphore smpH;
//     Semaphore smpO;
    
//     public H2O() {
//         smpH = new Semaphore(2);
//         smpO = new Semaphore(0);
//     }

//     public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
		
//         // releaseHydrogen.run() outputs "H". Do not change or remove this line.
//         smpH.acquire();
//         releaseHydrogen.run();
//         if(smpH.availablePermits()==0) smpO.release();
//     }

//     public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        
//         // releaseOxygen.run() outputs "O". Do not change or remove this line.
//         smpO.acquire();
// 		releaseOxygen.run();
//         smpH.release(2);
//     }
// }