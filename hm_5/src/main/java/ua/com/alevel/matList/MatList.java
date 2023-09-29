package ua.com.alevel.matList;

import java.lang.reflect.Array;

public class MatList<E extends Number> {

    public MatList(){}
    public MatList(MatList<E> matList){
        this.array = matList.array;
    }

    E[] array;

    public MatList(E[] array){
        this.array = array;
    }

    public E[] sortAsc(){
        E x;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if(array[j].doubleValue() < array[i].doubleValue()){
                    x = array[i];
                    array[i] = array[j];
                    array[j] = x;
                }
            }
        }
        return array;
    }

    public void getMax(){
        E max = array[0];

        for (int i = 0; i < array.length; i++) {
            if(array[i].doubleValue() > max.doubleValue()){
                max = array[i];
            }
        }
        System.out.print(max);
    }

    public E getMin(){
        E min = array[0];

        for (int i = 0; i < array.length; i++) {
            if(min.doubleValue() > array[i].doubleValue()){
                min = array[i];
            }
        }
        return min;
    }

    public E get(int index) {
        for (int i = 0; i < array.length; i++) {
            if (i == index) {
                return array[i];
            }
        }
        throw new RuntimeException("Error");
    }


    public double getMedian(){
        int n = array.length;
        if(n % 2 != 0) {
            return (double)array[n / 2];
        }
        E x = array[(n - 1) / 2];
        E y = array[n / 2];
        return (double) ( x.doubleValue() + y.doubleValue()) / 2.0;
    }

    public E[] sortDesc() {
        E x;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if(array[i].doubleValue() < array[j].doubleValue()) {
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

    public E[] sortDesc(int firstIndex, int lastIndex){
        lastIndex += 1;
        E[] slice = (E[]) new Object[lastIndex - firstIndex];

        for (int i = 0; i < slice.length; i++) {
            slice[i] = array[firstIndex + i];
        }

        this.array = slice;

        return array;
    }

    public void intersection(MatList matList) {
            int arrayLength = array.length < matList.array.length ? array.length : matList.array.length;
            E[] newArray = (E[]) new Object[arrayLength];

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

        E[] resultArray = (E[]) new Object[newArrayIndex];
        for (int i = 0; i < resultArray.length; i++) {
            resultArray[i] = newArray[i];
        }
        this.array = resultArray;
    }

    public double getAverage(){
        if (array == null || array.length == 0) {
            return 0.0;
        }

        double sum = 0.0;
        for (E num : array) {
            sum += num.doubleValue();
        }

        return sum / array.length;
    }

    public void join(MatList<E> matList) {
        add(matList.array);
    }
    public void print() {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

    }

    public void add(E newNum) {
        E[] newArray = copyArray(1);
        newArray[newArray.length - 1] = newNum;
        this.array = newArray;
    }


    public void add(E ...nums) {
        E[] newArray = copyArray(nums.length);
        for (int i = array.length, j = 0; i < newArray.length; i++, j++) {
            newArray[i] = nums[j];
        }
        this.array = newArray;
    }

    private E[] copyArray(int size){
        E[] newArray = (E[]) new Object[array.length + size];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        return newArray;
    }

}
