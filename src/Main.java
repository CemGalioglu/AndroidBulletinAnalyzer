import analyzer.AndroidCVEAnalyzer;
import util.FileUtil;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        AndroidCVEAnalyzer.INSTANCE.findEffectedVersions();

    }
}
