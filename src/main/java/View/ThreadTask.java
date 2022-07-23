package View;

import javafx.concurrent.Task;

public class ThreadTask extends Task<String> {
    public ClientThread clientThread;
    public String value = "";

    @Override
    protected String call() throws Exception {
        while (true) {
            Thread.sleep(500);
            if (clientThread.isNewResultAvailable) {
                System.out.println(clientThread.result);
                updateValue(clientThread.result);
                if (!clientThread.result.contains("nextTurn")) {
                    clientThread.isNewResultAvailable = false;
                    clientThread.result = "";
                }
                if (clientThread.result.startsWith("end ")) break;
            }
        }
        return value;
    }
}
