package leetcood.run;

public class Run3 {

    // jdk1.8.0_181\bin\jmc.exe
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            new Thread() {
                public void run() {
                    try {
                        Thread.sleep(500000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }
    }

}
