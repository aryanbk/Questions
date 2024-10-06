import java.util.concurrent.*;
import java.util.function.IntConsumer;

class FizzBuzz {
    private int n;
    private volatile int currentNumber;
    private Semaphore semaphore;

    public FizzBuzz(int n) {
        this.n = n;
        this.currentNumber = 1;
        this.semaphore = new Semaphore(1);
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while (true) {
            semaphore.acquire();
            try {
                if (currentNumber > n) break;
                if (currentNumber % 3 == 0 && currentNumber % 5 != 0) {
                    printFizz.run();
                    currentNumber++;
                }
            } finally {
                semaphore.release();
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (true) {
            semaphore.acquire();
            try {
                if (currentNumber > n) break;
                if (currentNumber % 3 != 0 && currentNumber % 5 == 0) {
                    printBuzz.run();
                    currentNumber++;
                }
            } finally {
                semaphore.release();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (true) {
            semaphore.acquire();
            try {
                if (currentNumber > n) break;
                if (currentNumber % 3 == 0 && currentNumber % 5 == 0) {
                    printFizzBuzz.run();
                    currentNumber++;
                }
            } finally {
                semaphore.release();
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while (true) {
            semaphore.acquire();
            try {
                if (currentNumber > n) break;
                if (currentNumber % 3 != 0 && currentNumber % 5 != 0) {
                    printNumber.accept(currentNumber);
                    currentNumber++;
                }
            } finally {
                semaphore.release();
            }
        }
    }
}





// class FizzBuzz {
//     private int n;
//     int i;
//     Semaphore s;

//     public FizzBuzz(int n) {
//         this.n = n;
//         i = 1;
//         s = new Semaphore(1);
//     }

//     // printFizz.run() outputs "fizz".
//     public void fizz(Runnable printFizz) throws InterruptedException {
//         while(i<=n){
//             if(i%3==0 && i%5!=0){
//                 s.acquire();
//                 if(i>n) return;
//                 printFizz.run();
//                 ++i;
//                 s.release();
//             }
//         }
//     }

//     // printBuzz.run() outputs "buzz".
//     public void buzz(Runnable printBuzz) throws InterruptedException {
//         while(i<=n){
//             if(i%3!=0 && i%5==0){
//                 s.acquire();
//                 if(i>n) return;
//                 printBuzz.run();
//                 ++i;
//                 s.release();
//             }
//         }
//     }

//     // printFizzBuzz.run() outputs "fizzbuzz".
//     public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
//         while(i<=n){
//             if(i%3==0 && i%5==0){
//                 s.acquire();
//                 if(i>n) return;
//                 printFizzBuzz.run();
//                 ++i;
//                 s.release();
//             }
//         }
//     }

//     // printNumber.accept(x) outputs "x", where x is an integer.
//     public void number(IntConsumer printNumber) throws InterruptedException {
//         while(i<=n){
//             if(i%3!=0 && i%5!=0){
//                 s.acquire();
//                 if(i>n) return;
//                 printNumber.accept(i);
//                 ++i;
//                 s.release();
//             }
//         }
//     }
// }