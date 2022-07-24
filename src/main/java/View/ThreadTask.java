package View;

import javafx.concurrent.Task;

public class ThreadTask extends Task<String> {
    public ClientThread clientThread;

    @Override
    protected String call() throws Exception {
        while (true) {
                Thread.sleep(500);
                updateValue(clientThread.result);
                /*if (!clientThread.result.contains("nextTurn")) {
                    clientThread.isNewResultAvailable = false;
                    clientThread.result = "";
                }*/
        }
    }
}
