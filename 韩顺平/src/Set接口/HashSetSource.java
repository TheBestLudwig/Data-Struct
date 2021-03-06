

/**
 * 1.HashSet底层是HashMap
 * 2.添加一个元素时，先得到hash值，会转换成索引值
 * 3.找到存储数据表table,看这个索引位置是否已经存放元素
 * 4.如无，直接加入
 * 5.如有，调用equals（重写过的）比较，相同则放弃添加，否则
 * 就添加到最后。
 * 6.是Java8中，如果一条链表的元素个数超过
 * TREEIFY_THRESHOLD(默认为8)，并且table的大小大于等于
 * MIN_TREEIFY_CAPACITY(默认64),就会进行树化（红黑树）
 *
 *
 *
 *
 * */