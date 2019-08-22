队列是一种受到限制的线性数据结构，从一个方向进行出出队输出数据的操作，从另外一个方向进行入队写入的操作。是一种先进先出(FIFO)的模式。

还是先用个现实的例子做类比，类比一种模型在大脑里面，才能更好的理解。其实，很多的知识点就是朴素的东西经过不同的组合和变化而来。

我们现在假设，现在有一个放平的管道，其中一侧靠近仓库，可以往管道里放不同颜色的颜料，另外一测，靠近输送放，负责从管道里面拿颜料  
![](https://upload-images.jianshu.io/upload_images/1993766-7e8fc5aa6a906c57.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)  

我们先理解最为直观和简单的模型，有个大概的概念，队列类的使用很多种，比如消息队列，阻塞队列，循环队列，以及在tcp中的应用等等。我们先把基本的概念理解清楚，实现方式做好理解，然后再后续慢慢讲不同的队列的形式，以及如何在基本的结构上做很多的变化和应用。   

  首先我们先初始化一组数据结构  
![](https://upload-images.jianshu.io/upload_images/1993766-2a473dd384889868.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)  

如上图所示，我们申请一个存放4个数据的空间，其中size为当前存的数据量，即为3，也是没有存放数据的单元的索引。
下面说下，队列的2大操作，其实就是出队和入队  

1.出队(下图为展示逻辑，其中想数组一样，重点理清数据搬移的工作)  
![](https://upload-images.jianshu.io/upload_images/1993766-e53254329f62dfef.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

①出队会出队首的元素，也就是索引为0的数据。即为A。
②出队后，后面的数据会做对应的搬移工作，时间复杂度为O(n)。
③伪代码实现(具体的最下面有git的地址)
```
//出队
func E dequeue(){
    //拿出队首元素并做后续的搬移
    // return array.remove(0);
   //当前需要删除的数据存入到变量中来
   E ret = data[index];
   //删除即为数据搬移的操作
   for (int i = index +1; i <= size;i++){
      data[i-1] = data[i];
  }
  size--;
  reutrn ret;

}

```  

2.入队(把H写入到数据)  
![](https://upload-images.jianshu.io/upload_images/1993766-c34b22570be4c2c1.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)  
①入队即为把数据写入当前指针执行的数据，也就是size所指向的
②在数据容量足够的情况下，时间复杂度为O(1)
③伪代码展示(具体例子,底部有git地址)
```
//写入队列
public void enqueue(E e){
    //写入指针指向的数据
    array.addLast(e);
}
```

