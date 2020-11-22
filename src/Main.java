public class Main {

    // check

    public static void main(String[] args) {

        // MyArrayDataException
        String[][] arr1 = {{"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4w"},
                {"1", "2", "3", "4"}};

        // MyArraySizeException 1
        String[][] arr2 = {{"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"}};

        // MyArraySizeException 2
        String[][] arr3 = {{"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4", "5"},
                {"1", "2", "3", "4"}};

        // Valid
        String[][] arr4 = {{"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"}};

        // MyArraySizeException and MyArrayDataException
        String[][] arr5 = {{"1", "2", "3", "4"},
                {"1", "2", "3", "123.4"},
                {"1", "2", "3", "4"}};

        try {
            System.out.println(sumArray(arr1));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e);
        }

    }

    public static int sumArray(String[][] array) {

        int arrayLen = 4;
        int sum = 0;

        if (array.length != arrayLen) {
            throw new MyArraySizeException(arrayLen);
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i].length != arrayLen) {
                throw new MyArraySizeException(arrayLen);
            }
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(
                            String.format("Cannot parse string value \"%s\" to integer at (%d, %d). " +
                                    "Check input array.", array[i][j], i, j));
                    }
                }
        }
        return sum;
    }
}

