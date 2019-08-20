import com.sun.xml.internal.bind.v2.TODO;

public class Array<E>{

    //定义对应的游标位置
    private int size;
    //定义对应的数据容量
    private E[] data;

    //构造函数
    public Array(int capacity){

        data = (E[])new Object[capacity];
        size = 0;
    }

    //无参构造函数
    public Array(){
        this(10);
    }

    //获得对应的容量
    public int getCapacity(){ return data.length; }

    //获得对应的元素个数
    public int getSize(){
        return size;
    }

    //获得末尾的数据
    public E getLastData(){
        return  data[size -1];
    }

    //查找指定数据的索引位置
    public int findAppointData(E e){

        for (int i= 0; i < data.length; i++){
            if (data[i] == e){
                return i;
            }
        }
        return -1;
    }

    //查找指定索引的数据
    public E findIndex(int index){
        if (size < 1 || index > size){
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");
        }
        return data[index];
    }

    //指定的索引位置,写入指定的数据
    public void add(int index, E e){

        //如果空间已经用尽的话,则需要申请更大的空间
        if (size == data.length){
            resize(data.length * 2);
        }

        //如果需要写入的数据,小于0或是超过当前的size则抛出异常
        if (index < 0 || index >= data.length){
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index < capacity.");
        }

        //如果刚好为size指向的数据,则可以直接写入
        if (index != size){
            //写入到对应的数组中
            for (int i = size -1; i <= index; i--){
                //数组从插入位置整体向后移位
                data[i+1] = data[i];
            }
        }
        //写入对应的需要插入的数据
        data[index] = e;
        //指向下一位
        size++;
    }

    //在数组初始位置写入数据
    public void addFirst(E e){
        add(0,e);
    }

    //在数组的末尾写入数据
    public void addLast(E e){
        add(size,e);
    }

    //删除指定索引的数据
    public E remove(int index){
        //删除小于0的索引,删除超过当前实际大小的数据,皆需要抛出异常
        if (index < 0 || index > data.length){
            throw new IllegalArgumentException("remove failed. Require index >= 0 and index < datalength.");
        }
        //当前需要删除的数据存入到变量中来
        E ret = data[index];

        //删除即为数据搬移的操作
        for (int i = index +1; i <= size;i++){
            data[i-1] = data[i];
        }
        size--;
        //重置最后一位的数据
//        data[size] = null;
        return ret;
    }

    //删除指定的数据
    public void removeData(E e){
        //查出对应的数据索引
        int index = findAppointData(e);
        if (index == -1){
            throw new IllegalArgumentException("Dont have this data");
        }
        remove(index);
    }

    //删除最后一个数据
    public E removeLast(){
        return remove(size -1);
    }

    //修改指定索引的数据
    public void set(int index, E e){
        //修改小于0的索引,修改超过当前实际大小的数据,皆需要抛出异常
        if (index < 0 || index > data.length){
            throw new IllegalArgumentException("set failed. Require index >= 0 and index < datalength.");
        }
        data[index] = e;
    }

    //申请更大的容量空间
    public void resize(int capacity){
        E[] newData = (E[])new Object[capacity];;
        //数据复制
        for (int i = 0; i < size; i++){
            newData[i] = data[i];
        }
        data = newData;
    }


    public String toString(){

        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d\n", size, data.length));
        res.append('[');
        for(int i = 0 ; i < size ; i ++){
            res.append(data[i]);
            if(i != size - 1)
                res.append(", ");
        }
        res.append(']');
        return res.toString();
    }

    public static void main(String[] args) {

        Array<Integer> arr = new Array<>();
        for(int i = 0 ; i < 10 ; i ++)
            arr.addLast(i);
        System.out.println(arr);


    }
}

