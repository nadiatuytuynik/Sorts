package com.netcracker.start;
import java.util.ArrayList;
import static com.netcracker.analytics.Analytics.reflection;
import static com.netcracker.excel.WriteToExcel.excelFile;

/** The class is used to start the program
 * @author Tiutiunyk
 * @version 1.0
 * use methods
 * @see com.netcracker.analytics.Analytics#reflection(int, int, int)
 * @see com.netcracker.excel.WriteToExcel#excelFile(String, int, ArrayList)
 */
public class Main {
    public static void main(String args[]) throws Exception {
        int numberOfValues = 1000;
        ArrayList<Long> timeResult = reflection(numberOfValues,100,1);
        excelFile("L1.xls", numberOfValues, timeResult);
    }
}
