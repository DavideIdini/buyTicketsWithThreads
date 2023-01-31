import static java.lang.Thread.sleep;

public class Main {
    static Biglietti sting = new Biglietti();
    public static void main(String[] args) {

        MyThread[] threads = new MyThread[200];
        for (int i = 0; i < threads.length ; i++){
                threads[i]= new MyThread();
                threads[i].start();
        }

        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);

            }
        }
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


        System.out.println("ticket venduti "+sting.getTicketVenduti());
    }
    static class MyThread extends Thread{

        @Override
        public void run() {
            super.run();
            sting.entraalbotteghino();

        }
    }
    }


