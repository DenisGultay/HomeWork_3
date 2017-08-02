package Utils;

/**
 * Created by Користувач on 03.08.2017.
 */
public class DatabaseException extends RuntimeException {

    public DatabaseException(Exception cause) {
        super(cause);
    }

    public DatabaseException(String message, Exception cause) {
        super(message, cause);
    }
}
