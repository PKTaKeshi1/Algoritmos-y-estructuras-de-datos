package exceptions;

public class ItemDuplicated extends RuntimeException {
    public ItemDuplicated(String message) {
        super(message);
    }
}
