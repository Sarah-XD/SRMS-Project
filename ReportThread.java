public class ReportThread extends Thread {

    private ReportManager reportManager;

    public ReportThread(ReportManager reportManager) {
        this.reportManager = reportManager;
    }

    @Override
    public void run() {

        System.out.println("\n[Thread] Generating Reports...");

        reportManager.generateGPAReport();
    }
}
