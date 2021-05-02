package lesson2;


public class ExceptionApp {

    public static void main(String[] args) {
        String[][] array = new String[][]{{"1","2","3","4"}, {"5","6","7","8"}, {"9","10","11","12"}, {"13","14","15","16"}};
        String[][] array2 = new String[][]{{"1","2","3"}, {"5","6","7"}, {"9","10","11"}, {"9","10","11"}};


        try {
            System.out.println("Sum = " + transformAndSumArray(array2));
        }
        catch (MyArraySizeException e) {
            e.printStackTrace(System.out);
        }
        catch (NumberFormatException e) {
            try {
                throw new MyArrayDataException("Invalid value is in the array cell!");
            }
            catch (MyArrayDataException ex) {
                ex.printStackTrace(System.out);
                e.printStackTrace(System.out);
            }
        }
    }


    static int transformAndSumArray(String[][] array) throws MyArraySizeException, NumberFormatException {
        if(!isArraySizeValid(array)){
            throw new MyArraySizeException("Array size is not 4x4!");
        }

        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                    sum += Integer.parseInt(array[i][j]);
            }
        }
        return sum;
    }

    /**
     * Проверка размера массива
     * @param array
     * @return true
     */
    static boolean isArraySizeValid(String[][] array){
        if(array.length == 4){
            for (int i = 0; i < array.length; i++) {
                if(array[i].length != 4){
                    return false;
                }
            } return true;
        }
        return false;
    }
}
