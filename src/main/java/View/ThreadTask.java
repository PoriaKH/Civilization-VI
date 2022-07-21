package View;

import javafx.concurrent.Task;

public class ThreadTask extends Task<String> {
    public ClientThread clientThread;

    @Override
    protected String call() throws Exception {
        while (true) {
            Thread.sleep(500);
            if (clientThread.isNewResultAvailable) {
                updateValue(clientThread.result);
                clientThread.isNewResultAvailable = false;
            }
        }
    }
}
