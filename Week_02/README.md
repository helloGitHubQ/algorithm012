# 第二周学习笔记

## HashMap

HashMap 首先是实现了 Map 接口的。然后它是一种 key-value 形式的集合，也是目前工作中用到最多的集合之一。

当然实现 Map 接口的还有 HashTable,TreeMap,ConcurrentHashMap 等.


### Java8 版本的 HashMap 分析

Java8 之前的是 数组+链表 实现.Java 8 以及之后是 数组+链表+红黑树 实现

特性：

- 无序
- key 不允许重复,value 可以.如果 key 重复后放入的 map 中的会覆盖之前的.
- key 可以为 null

常用方法：

- put

put 方法里面其实调用的 putVal 方法.

分两种情况链表和红黑树.

1.链表
> 链表的话就在链表最后的一个节点插入元素.如果链表的节点数量到达阈值的话就会转红黑树.
>
> 判断链表中的节点中的 key 是否和插入元素的 key 是否相等.相等时新值替换旧值。

2.红黑树
> 调用 putTreeVal 方法

- get

也是分两种情况链表和红黑树.

1.链表
> 挨个遍历遍历链表获取值

2.红黑树
> 调用 getTreeNode 方法


- containsKey 是否包含对应key
- size 大小
- keySet 遍历时用到

实现原理：

JDK8 中计算放入值的位置时,如果是同一个 hash 值的时候,就会在会变成链表。如果链表的节点数大于8的时候就会转成红黑树。

如果红黑树的节点数小于8的时候就又变成链表。

## HeapSort

是基于二叉堆进行排序的一种数据结构.类似于选择排序.


### HeapSort 规则

- 构建最大堆
- 最大的数值存储在堆根上,将其交换;最后堆化这个树
- 堆大于1的时候重复上述步骤

### HeapSort 生成

例如:Input data: 4, 10, 3, 5, 1

二叉堆的左节点是 2*i+1,二叉堆的有节点是2*i+2.就变成这样了


```
         4(0)
        /   \
     10(1)   3(2)
    /   \
 5(3)    1(4)
```

按照规则生成,结果为

```
        10(0)
        /  \
     5(1)  3(2)
    /   \
 4(3)    1(4)
```


### 时间复杂度：

堆化的时间复杂度是 O(logN),createAndBuildHeap() 时是 O(n),总的来说是 O(nLogN)

### Java实现代码

[HeapSort](https://github.com/helloGitHubQ/algorithm012/blob/master/Week_02/HeapSort.java)

[参考文档](https://www.geeksforgeeks.org/heap-sort/)

## 需要多加练习的算法题目

- 丑数
- N叉树的层序遍历
- TopK