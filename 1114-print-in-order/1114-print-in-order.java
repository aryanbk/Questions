// using Semaphores

class Foo {
    
    Semaphore do2nd;
    Semaphore do3rd;
    public Foo() {
        do2nd = new Semaphore(0);
        do3rd = new Semaphore(0);
    }

    public void first(Runnable printFirst) throws InterruptedException {
        
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        do2nd.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        
        // printSecond.run() outputs "second". Do not change or remove this line.
        do2nd.acquire();
        printSecond.run();
        do3rd.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        
        // printThird.run() outputs "third". Do not change or remove this line.
        do3rd.acquire();
        printThird.run();
    }
}





// // super naive

// class Foo {
    
//     boolean[] done;
//     public Foo() {
//         done = new boolean[3];
//     }

//     public void first(Runnable printFirst) throws InterruptedException {
        
//         // printFirst.run() outputs "first". Do not change or remove this line.
//         printFirst.run();
//         done[0] = true;
//     }

//     public void second(Runnable printSecond) throws InterruptedException {
        
//         // printSecond.run() outputs "second". Do not change or remove this line.
//         while(!done[0]){
//             if(done[0]){
//                 printSecond.run();
//                 done[1] = true;
//                 break;
//             }
//         }
//         if(done[0] && !done[1]){
//             printSecond.run();
//             done[1] = true;
//         }
//     }

//     public void third(Runnable printThird) throws InterruptedException {
        
//         // printThird.run() outputs "third". Do not change or remove this line.
//         while(!done[1]){        
//             if(done[1]){
//                 printThird.run();
//                 done[2] = true;
//                 break;
//             }
//         }
        
//         if(done[1] && !done[2]){
//             printThird.run();
//             done[2] = true;
//         }
//     }
// }