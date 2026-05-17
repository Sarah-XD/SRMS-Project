package threads;

import file.FileManagement;

public class AutoSaveThread extends Thread {

    private FileManagement fileManagement;

    public AutoSaveThread(FileManagement fileManagement) {
        this.fileManagement = fileManagement;
    }

    @Override
    public void run() {

        try {

            System.out.println("\n[Thread] Auto Saving...");

            Thread.sleep(3000);

        } catch (InterruptedException e) {

            System.out.println(e.getMessage());
        }
    }
}
