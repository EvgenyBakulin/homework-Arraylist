package ru.skypro;

import ru.skypro.exeptions.NullListEхeption;
import ru.skypro.exeptions.WrongIndexExeption;
import ru.skypro.exeptions.WrongItemExeption;

public class MyStringArrayList implements MyStringList {
    private String[] array;
    //Сначала хотел везде вызывать метод size(), но понял, что код будет быстрее, если завести отдельную
    // переменную для фактического размера списка
    private int currenSize = 0;

    public MyStringArrayList() {
        this.array = new String[16];
    }

    public String add(String item) {
        if (currenSize == array.length - 1) {
            resize(array.length * 2);
        }
        array[currenSize] = item;
        currenSize++;
        return item;
    }

    public String add(int index, String item) {
        if (index < 0 || index >= currenSize) {
            throw new WrongIndexExeption();
        } else {
            if (currenSize == array.length - 1) {
                resize(array.length * 2);
            }
            for (int i = currenSize; i > index; i--) {
                array[i] = array[i - 1];
            }
            array[index] = item;
            currenSize++;
            return item;
        }
    }

    public String set(int index, String item) {
        if (index < 0 || index >= currenSize) {
            throw new WrongIndexExeption();
        } else {
            array[index] = item;
            return item;
        }
    }

    public String remove(String item) {
        if (!this.contains(item)) {
            throw new WrongItemExeption();
        } else {
            for (int i = this.indexOf(item); i < currenSize - 1; i++) {
                array[i] = array[i + 1];
            }
            currenSize--;
            return item;
        }
    }

    public String remove(int index) {
        if (index < 0 || index >= currenSize) {
            throw new WrongIndexExeption();
        } else {
            String s = array[index];
            for (int i = index; i < currenSize - 1; i++) {
                array[i] = array[i + 1];
            }
            currenSize--;
            return s;
        }
    }

    public String get(int index) {
        if (index<0||index>=currenSize) {
            throw new WrongIndexExeption();
        }
        else {
            return array[index];
        }
    }

    public boolean equals(MyStringList otherList) {
        if (otherList==null){
            throw new NullListEхeption();
        }
        else {
            if (this.size() != otherList.size()) {
                return false;
            } else {
                int count = 0;
                for (int i = 0; i < this.size(); i++) {
                    if (!this.get(i).equals(otherList.get(i))) {
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

    public boolean contains(String item) {
        int count = 0;
        for (int i = 0; i < currenSize; i++) {
            if (array[i].equals(item)) {
                count++;
                break;
            }
        }
        if (count > 0) {
            return true;
        } else {
            return false;
        }
    }


    public int indexOf(String item) {
        int index = -1;
        for (int i = 0; i < currenSize; i++) {
            if (array[i].equals(item)) {
                index = i;
            }
        }
        return index;
    }

    public int lastIndexOf(String item) {
        int index = -1;
        for (int i = currenSize - 1; i >= 0; i--) {
            if (array[i].equals(item)) {
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


    public String[] toArray() {
        String[] newArray = new String[currenSize];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = this.get(i);
        }
        return newArray;
    }

    private void resize(int newlength) {
        String[] newArr = new String[newlength];
        System.arraycopy(array, 0, newArr, 0, array.length);
        array = newArr;
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i <= currenSize - 1; i++) {
            s = s + array[i] + " ";
        }
        return s;
    }

}
