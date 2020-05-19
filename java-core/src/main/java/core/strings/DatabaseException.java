package main.java.core.strings;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-15 23:47:47
 * @Modified By:
 */
public class DatabaseException  extends Exception{
    public DatabaseException(int transactionId, int queryId, String message){
        super(String.format("t%d q%d %s", transactionId, queryId, message));
    }

    public static void main(String[] args) {
        try {
            throw new DatabaseException(3, 7, "write failed!");
        } catch (Exception e){
            System.out.println(e);
        }
    }
}
