public class stack<E> {


    private Array<E> array;
    //有参构造函数
    public stack(int capacity){
        array = new Array(capacity);
    }
    //无参构造函数
    public stack(){
        array = new Array();
    }

    //入栈
    public void push(E e){
        array.add(array.getSize(),e);
    }

    //出栈
    public E pop(){
        return array.removeLast();
    }

    //获得末尾的数据
    public E peek(){
        return array.getLastData();
    }

    //获得当前的数据长度
    public int getDataLength(){
        return array.getSize();
    }

    //获得对应的容量大小
    public int getCapacity(){
        return array.getCapacity();
    }

    //获得当前的数据长度

    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Stack: bottom ");
        res.append('[');
        for(int i = 0 ; i < array.getSize() ; i ++){
            res.append(array.findIndex(i));
            if(i != array.getSize() - 1)
                res.append(", ");
        }
        res.append("] top");
        return res.toString();
    }

    public static void main(String[] args) {

        stack<Integer> stack = new stack<>();
        stack.push(1);
        System.out.println(stack);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack);
        stack.push(5);
        System.out.println(stack);
        stack.push(6);
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
    }
}


