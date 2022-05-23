## Java 虚拟机

`Java` 使用虚拟机自动管理内存，不需要像 `C/C++` 为 `new` 操作去写对应的 `delete/free`。不容易出现内存泄漏和内存溢出问题。但是一旦出现内存泄漏和溢出方面的问题，如果不了解虚拟机是怎样使用内存的，排查错误非常困难。

### 内存区域/运行时数据区域？

Java 虚拟机在执行 Java 程序的过程中会把它管理的内存划分成若干个不同的数据区域。