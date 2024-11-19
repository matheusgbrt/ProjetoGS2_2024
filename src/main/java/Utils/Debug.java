package Utils;

import Utils.Evaluator.ScannerUtil;

import java.io.ByteArrayInputStream;

public class Debug
{
    public static void debug(){
        String simulatedInput = "1\nmatheusgbrt\nmatheusgbrt\n3\n0\n2\n2\n5\n0\n0\n";

        ByteArrayInputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);
        ScannerUtil.resetScanner();
    }
}

