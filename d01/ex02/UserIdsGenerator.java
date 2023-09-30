package ex02;

public class UserIdsGenerator {
    private static final UserIdsGenerator instanse = new UserIdsGenerator();
    private static int idCount = 0;
    private UserIdsGenerator(){}
    public static int getId() {
        generateId();
        return idCount;
    }
    public static void generateId() {
        idCount++;
    }

    public static UserIdsGenerator getInstance() {
        return instanse;
    }
}
