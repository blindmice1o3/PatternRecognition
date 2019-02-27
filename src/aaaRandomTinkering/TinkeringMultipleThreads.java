package aaaRandomTinkering;

public class TinkeringMultipleThreads {

    public static void main(String[] args) {
        ExtendThread extendThread = new ExtendThread();
        extendThread.start();

        Thread runnableInterface = new Thread(new RunnableInterface());
        runnableInterface.start();

        Thread anonymousRunnableInterface = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(i + ": anonymousRunnableInterface");

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        anonymousRunnableInterface.start();
    }

}

class ExtendThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i + ": aaaRandomTinkering.ExtendThread");

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class RunnableInterface implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i + ": aaaRandomTinkering.RunnableInterface");

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}