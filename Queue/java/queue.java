public class queue<E> {

    private Array<E> array;

    //构造
    public queue(int capacity){
        array = new Array(capacity);
    }
    //无参构造
    public queue(){
        array = new Array();
    }

    //写入队列
    public void enqueue(E e){
        array.addLast(e);
    }

    //出队
    public E dequeue(){
        return array.remove(0);
    }

    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Queue: ");
        res.append("front [");
        for(int i = 0 ; i < array.getSize() ; i ++){
            res.append(array.findIndex(i));
            if(i != array.getSize() - 1)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args) {

        queue<Integer> queue = new queue<>();
        for(int i = 0 ; i < 10 ; i ++){
            queue.enqueue(i);
            System.out.println(queue);
        }

        queue.enqueue(1);
        System.out.println(queue);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println(queue);
        queue.dequeue();
        System.out.println(queue);
    }

}

