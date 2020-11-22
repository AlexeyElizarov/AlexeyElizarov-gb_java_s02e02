public class MyArraySizeException  extends RuntimeException {

    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    public MyArraySizeException() {
    }

    public MyArraySizeException(String message) {
        super(message);
    }

    public MyArraySizeException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyArraySizeException(int length) {
        super();
        this.message = String.format("Array is not %dx%d. Check input array.", length, length);
    }

}
