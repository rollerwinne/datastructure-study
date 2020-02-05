# 排序算法 Sort Algorithm

分类: 内部排序 外部排序

## 八种排序算法

$$
排序\left\{
\begin{aligned}
&内部排序\left\{\begin{aligned}
            插入排序&\left\{\begin{aligned}
                        &直接插入排序\\
                        &希尔排序
                    \end{aligned}\right.\\
            选择排序&\left\{\begin{aligned}
                        &简单选择排序\\
                        &堆排序
                    \end{aligned}\right.\\
            交换排序&\left\{\begin{aligned}
                        &冒泡排序\\
                        &快速排序
                    \end{aligned}\right.\\
            归并排序&\\
            基数排序&(特殊的桶排序)
       \end{aligned}\right. \\
\\&外部排序
\end{aligned}\right.
$$

时间频度/语句频度 $T(n)$:算法中语句的执行次数

忽略常数项

忽略低次项

忽略系数(三次也可以忽略,韩老师把自己绕进去了,因为相对于四次或更高次,三次也是逼近的)

$f(n)$是$T(n)$的同数量级函数

$T(n)=O(f(n))$为算法的渐进时间复杂度,简称时间复杂度

## 算法的平均时间复杂度与最坏时间复杂度

| 排序算法 |  平均时间   |    最差清形     | 稳定度 |  额外空间  | 备注                         |
| :------: | :---------: | :-------------: | :----: | :--------: | ---------------------------- |
|   冒泡   |  $O(n^2)$   |    $O(n^2)$     |  稳定   |   $O(1)$   | n小时较好                    |
|   交换   |  $O(n^2)$   |    $O(n^2)$     |  不稳定   |   $O(1)$   | n小时较好                    |
|   选择   |  $O(n^2)$   |    $O(n^2)$     | 不稳定 |   $O(1)$   | n小时较好                    |
|   插入   |  $O(n^2)$   |    $O(n^2)$     |  稳定  |   $O(1)$   | 大部分已排序时较好           |
|   基数   | $O(log_RB)$ |   $O(log_RB)$   |  稳定  |   $O(n)$   | B是真数(0-9),R是基数(个十百) |
|  Shell   | $O(nlogn)$  | $O(n^s)\,1<s<2$ | 不稳定 |   $O(1)$   | s是所选分组                  |
|   快速   | $O(nlogn)$  |    $O(n^2)$     | 不稳定 | $O(nlogn)$ | n大时较好                    |
|   归并   | $O(nlogn)$  |   $O(nlogn)$    |  稳定  |   $O(1)$   | n大时较好                    |
|    堆    | $O(nlogn)$  |   $O(nlogn)$    | 不稳定 |   $O(1)$   | n大时较好                    |

## 该包下的文件

AlgorithmTimeComplexity.java 时间复杂度示例
BubbleSort.java 冒泡排序
SelectSort.java 选择排序
InsertSort.java 插入排序
ShellSort.java 希尔排序
QuickSort.java 快速排序
MergeSort.java 归并排序
RadixSort.java 基数排序
CountSort.java 计数排序(extra)
BucketSort.java 桶排序(extra)
HeapSort.java 堆排序(later)
SortTimeCompare.java 所有排序方法的时间比较
Sort.java 排序方法汇总
