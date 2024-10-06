class DiningPhilosophers {
    
    Semaphore[] forks;
    Semaphore eating;
    
    public DiningPhilosophers() {
        eating = new Semaphore(1);
        forks = new Semaphore[5];
        for(int i=0; i<5; ++i) forks[i] = new Semaphore(1);
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        
        eating.acquire();
        
        forks[philosopher].acquire();
        forks[(philosopher+1)%5].acquire();
        
        pickRightFork.run();
        pickLeftFork.run();
        
        eat.run();
        
        putRightFork.run();
        putLeftFork.run();

        forks[philosopher].release();
        forks[(philosopher+1)%5].release();
        
        eating.release();
        
    }
}