数组结构后的下一个结构就是栈结构，也就是我们常说的堆栈。这种数据结构的特点就是，只会从栈顶(top)进行数据的写入和输出。

如果对应数组结构比较了解的话，这个数据结构也会很容易一点点弄明白。  

首先，我们还是以现实场景作为类比，假设现在我们有个桶装的容器，后续我们需要把不同的颜料块放入桶中，恰好每个颜料块，都能放置一层。那我们用下面的图看下对应的逻辑。  
![](https://upload-images.jianshu.io/upload_images/1993766-a0331ce6c61a7378.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

通过上图我们很好明白这种栈结构所谓的从栈顶进行写入和输出，类似的结构还有，厨房放在桌上的一层层的盘子，放置在桌上的一层层的书。

那我们把刚才的放置颜料的桶装结构，换个方式去思考，把这个颜料容器向右放倒。先来示例。
![](https://upload-images.jianshu.io/upload_images/1993766-aa26ff6e25bfc0b6.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)  
这种操作的方式，就是让大家可以更多维的思考，不管什么样的现实的放置方式，只有抓住栈顶才能做写入和输出，并且按顺序的写入和输出，就能很好的理解这种结构。

我们现在对栈结构进行对应的分析。其实也就是2个操作，就是入栈(push)和出栈(pop)。先给出对应的初始数值，我们可以理解为用数组的方式实现栈结构
![](https://upload-images.jianshu.io/upload_images/1993766-7d3e0dfd9117f248.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

1.出栈(pop)  
![](https://upload-images.jianshu.io/upload_images/1993766-6163ec62b827b60a.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)  
①伪代码
```
//出栈
func E pop(){
    //取出对应的最后一个数据
    //删除最后一个数据
    return array.removeLast();
}
//详细可以看git中的代码
```

②出栈因为只操作最后一个数据，所以算法时间复杂度为O(1)。  
2.入栈(push)  
![](https://upload-images.jianshu.io/upload_images/1993766-cd1ecd5bd486f00f.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)  
①伪代码
```  
//入栈
func void push(E e){
    //在数据的最后写入数据
    array.add(array.getSize(),e);
}

```
②入栈也只对最后的数据做操作，所以，在容量足够的情况下，时间复杂度为O(1)



