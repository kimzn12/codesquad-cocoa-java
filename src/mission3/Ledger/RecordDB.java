package mission3.Ledger;

import java.util.LinkedList;
import java.util.Scanner;

public class RecordDB {
    public static LinkedList<Record> recordDatabase = new LinkedList<>();

    public RecordDB(){
    }

    public static void init() {
        Record initRecord = new Record();
        recordDatabase.clear();
        recordDatabase.add(0,initRecord);
    }
}
