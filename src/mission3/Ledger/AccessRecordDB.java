package mission3.Ledger;

public class AccessRecordDB {

    //레코드 생성
    public static void createRecord(String username, String date, String context,int income, int spending) {
        Record record = new Record();
        record.setUsername(username);
        record.setContext(context);
        record.setDate(date);
        record.setIncome(income);
        record.setSpending(spending);
        RecordDB.recordDatabase.add(record);

        System.out.println(RecordDB.recordDatabase.get(1).getUsername() + RecordDB.recordDatabase.get(1).getContext() ); // 잘 들어갔는지 확인
    }

    //레코드 읽기

    public static void getRecord(User user) {
        for (Record i : RecordDB.recordDatabase) {
            if(user.getName().equals(i.getUsername())){
                System.out.printf("%10s|%13s|%15s|%10d|%10d",i.getUsername(),i.getDate(),i.getContext(),i.getIncome(),i.getSpending());
            }
        }
    }
}
