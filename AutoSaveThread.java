public class AutoSaveThread extends Thread {

    private FileManager fileManager;

    public AutoSaveThread(FileManager fileManager) {
        this.fileManager = fileManager;
    }

    @Override
    public void run() {

        while (true) {

            try {

                System.out.println("\n[AutoSave] Saving data...");

                fileManager.saveStudents();

                Thread.sleep(10000);

            } catch (Exception e) {

                System.out.println("AutoSave Error: " + e.getMessage());
            }
        }
    }
}
