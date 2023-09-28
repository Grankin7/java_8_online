package ua.com.alevel.matList;

public class MatList {
    int[] array;

    public MatList(int[] array){
        this.array = array;
    }

    public int[] sortAsc(){
        int x;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if(array[i] > array[j]){
                    x = array[i];
                    array[i] = array[j];
                    array[j] = x;
                }
            }
        }
        return array;
    }

    public void getMax(){
        int max = array[0];

        for (int i = 0; i < array.length; i++) {
            if(array[i] > max){
                max = array[i];
            }
        }
        System.out.print(max);
    }

    public void getMin(){
        int min = array[0];

        for (int i = 0; i < array.length; i++) {
            if(min > array[i]){
                min = array[i];
            }
        }
        System.out.print(min);
    }

    public void get(int index){
        for(int i = 0; i < array.length; i++){
            if(i == index){
                System.out.println(array[i]);
            }
        }
    }

    public void getMedian(){}

    public int[] sortDesc() {
        int x;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if(array[i] < array[j]) {
                    x = array[i];
                    array[i] = array[j];
                    array[j] = x;
                }
            }
        }
        return array;
    }

    public void sortDesc(int value){

    }

    public int[] sortDesc(int firstIndex, int lastIndex){
        lastIndex += 1;
        int[] slice = new int[lastIndex - firstIndex];
        for (int i = 0; i < slice.length; i++) {
            slice[i] = array[firstIndex + i];
        }
        this.array = slice;
        return array;
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

    public void getAverage(){
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        double average = sum / array.length;
        System.out.println(average);
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
