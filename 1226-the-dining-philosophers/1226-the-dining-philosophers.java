// import java.util.concurrent.Semaphore;

// class DiningPhilosophers {
//     private final Semaphore[] forks;
//     private final Semaphore maxDiners;

//     public DiningPhilosophers() {
//         forks = new Semaphore[5];
//         for (int i = 0; i < 5; i++) {
//             forks[i] = new Semaphore(1);
//         }
//         // Allow at most 4 philosophers to try to eat simultaneously
//         maxDiners = new Semaphore(4);
//     }

//     public void wantsToEat(int philosopher,
//                            Runnable pickLeftFork,
//                            Runnable pickRightFork,
//                            Runnable eat,
//                            Runnable putLeftFork,
//                            Runnable putRightFork) throws InterruptedException {
        
//         int leftFork = philosopher;
//         int rightFork = (philosopher + 1) % 5;

//         maxDiners.acquire(); // Limit the number of philosophers trying to eat

//         try {
//             // Always acquire the lower-numbered fork first
//             if (leftFork < rightFork) {
//                 forks[leftFork].acquire();
//                 forks[rightFork].acquire();
//             } else {
//                 forks[rightFork].acquire();
//                 forks[leftFork].acquire();
//             }

//             pickLeftFork.run();
//             pickRightFork.run();
//             eat.run();
//             putLeftFork.run();
//             putRightFork.run();
//         } finally {
//             // Always release the forks
//             forks[leftFork].release();
//             forks[rightFork].release();
//             maxDiners.release(); // Allow another philosopher to try eating
//         }
//     }
// }





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
        
        try{
        forks[philosopher].acquire();
        forks[(philosopher+1)%5].acquire();
        
        pickRightFork.run();
        pickLeftFork.run();
        
        eat.run();
        
        putRightFork.run();
        putLeftFork.run();
        }
        finally{
        forks[philosopher].release();
        forks[(philosopher+1)%5].release();
        
        eating.release();
        }
    }
}