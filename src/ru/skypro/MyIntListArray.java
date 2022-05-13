package ru.skypro;

import ru.skypro.exeptions.NullListExeptionInt;
import ru.skypro.exeptions.WrongIndexExeptionInt;
import ru.skypro.exeptions.WrongItemExeptionInt;

public class MyIntListArray implements MyIntList {
    private Integer[] array;
    private int currenSize = 0;

    public MyIntListArray() {
        this.array = new Integer[16];
    }

    public int add(int item) {
        if (currenSize == array.length - 1) {
            double temp = array.length * 1.5;
            int newLength = (int) temp;
            grow(newLength);
        }
        array[currenSize] = item;
        currenSize++;
        return item;
    }

    public int add(int index, int item) {
        if (index < 0 || index >= currenSize) {
            throw new WrongIndexExeptionInt();
        } else {
            if (currenSize == array.length - 1) {
                double temp = array.length * 1.5;
                int newLength = (int) temp;
                grow(newLength);
            }
            for (int i = currenSize; i > index; i--) {
                array[i] = array[i - 1];
            }
            array[index] = item;
            currenSize++;
            return item;
        }
    }

    public int set(int index, int item) {
        if (index < 0 || index >= currenSize) {
            throw new WrongIndexExeptionInt();
        } else {
            array[index] = item;
            return item;
        }
    }

    public int remove(int item) {
        if (!this.contains(item)) {
            throw new WrongItemExeptionInt();
        } else {
            for (int i = this.indexOf(item); i < currenSize - 1; i++) {
                array[i] = array[i + 1];
            }
            currenSize--;
            return item;
        }
    }

    public int removeToIndex(int index) {
        if (index < 0 || index >= currenSize) {
            throw new WrongIndexExeptionInt();
        } else {
            int temp = array[index];
            for (int i = index; i < currenSize - 1; i++) {
                array[i] = array[i + 1];
            }
            currenSize--;
            return temp;
        }
    }

    public int get(int index) {
        if (index < 0 || index >= currenSize) {
            throw new WrongIndexExeptionInt();
        } else {
            return array[index];
        }
    }

    public boolean equals(MyIntList otherList) {
        if (otherList == null) {
            throw new NullListExeptionInt();
        } else {
            if (this.size() != otherList.size()) {
                return false;
            } else {
                int count = 0;
                for (int i = 0; i < this.size(); i++) {
                    if (this.get(i) != (otherList.get(i))) {
                        count++;
                    }
                }
                if (count == 0) {
                    return true;
                } else {
                    return false;
                }
            }
        }
    }

    public int size() {
        return currenSize;
    }

    public boolean contains(int item) {
        Integer[] tempArr = sort();
        int minIndex = 0;
        int maxIndex = tempArr.length - 1;
        while (minIndex <= maxIndex) {
            int midIndex = (minIndex + maxIndex) / 2;
            if (tempArr[midIndex] == item) {
                return true;
            }
            if (item > tempArr[midIndex]) {
                minIndex = midIndex + 1;
            } else if (item < tempArr[midIndex]) {
                maxIndex = midIndex - 1;
            }
        }

        return false;
    }


    public int indexOf(int item) {
        int index = -1;
        for (int i = 0; i < currenSize; i++) {
            if (array[i] == item) {
                index = i;
            }
        }
        return index;
    }

    public int lastIndexOf(int item) {
        int index = -1;
        for (int i = currenSize - 1; i >= 0; i--) {
            if (array[i] == item) {
                index = i;
            }
        }
        return index;
    }

    public boolean isEmpty() {
        if (currenSize == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void clear() {
        for (int i = currenSize - 1; i >= 0; i--) {
            array[i] = null;
            currenSize--;
        }
    }


    private void grow(int newlength) {
        Integer[] newArr = new Integer[newlength];
        System.arraycopy(array, 0, newArr, 0, array.length);
        array = newArr;
    }

    /*Сортировка и методы, нужные для сортировки - собствено рекурсивный(он принимает всё время массив,
     * должен быть отдельно, и два вспомогательных к нему*/
    private Integer[] sort() {
        Integer[] newArr = new Integer[currenSize];
        System.arraycopy(array, 0, newArr, 0, currenSize);
        quickSort(newArr, 0, newArr.length - 1);
        return newArr;
    }

    private void quickSort(Integer[] arr, int begin, int end) {
        if (begin < end) {
            int partsIndex = parts(arr, begin, end);

            quickSort(arr, begin, partsIndex - 1);
            quickSort(arr, partsIndex + 1, end);
        }
    }

    public int parts(Integer[] arr, int begin, int end) {
        int reper = arr[end];
        int i = begin - 1;
        for (int j = begin; j < end; j++) {
            if (arr[j] <= reper) {
                i++;
            }
        }
        swapElements(arr, i + 1, end);
        return i + 1;
    }

    private void swapElements(Integer[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i <= currenSize - 1; i++) {
            s = s + array[i].toString() + " ";
        }
        return s;
    }
}
