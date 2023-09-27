package ua.com.alevel.matList;

public class MatList {
    int[] array;

    public MatList(int[] array){
        this.array = array;
    }

    public void intersection(MatList matList) {
            int arrayLength = array.length < matList.array.length ? array.length : matList.array.length;
            int[] newArray = new int[arrayLength];

            int newArrayIndex = 0;

            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < matList.array.length; j++) {
                    if(matList.array[j] == array[i]){

                        if(newArrayIndex == 0){
                            newArray[newArrayIndex] = array[i];
                            newArrayIndex++;
                        }
                        else {
                            boolean isExist = false;
                            for (int k = 0; k < newArrayIndex; k++) {
                                if(newArray[k] == array[i]){
                                    isExist = true;
                                }
                            }
                            if(!isExist){
                                newArray[newArrayIndex] = array[i];
                                newArrayIndex++;
                            }
                        }
                    }
                }
            }

        int[] resultArray = new int[newArrayIndex];
        for (int i = 0; i < resultArray.length; i++) {
            resultArray[i] = newArray[i];
        }
        this.array = resultArray;
    }

    public void join(MatList matList) {
        add(matList.array);
    }
    public void print() {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

    }

    public void add(int newNum) {
        int[] newArray = copyArray(1);
        newArray[newArray.length - 1] = newNum;
        this.array = newArray;
    }

    public void add(int ...nums) {
        int[] newArray = copyArray(nums.length);
        for (int i = array.length, j = 0; i < newArray.length; i++, j++) {
            newArray[i] = nums[j];
        }
        this.array = newArray;
    }

    private int[] copyArray(int size){
        int[] newArray = new int[array.length + size];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        return newArray;
    }

}
