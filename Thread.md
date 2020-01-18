## 线程状态
1. New
1. Runnable
3. Blocked
4. Waiting
5. Timed Watting
### 线程状态切换
![img](https://img-blog.csdnimg.cn/20181120173640764.jpeg?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3BhbmdlMTk5MQ==,size_16,color_FFFFFF,t_70)

### 线程終止
- 不正確的線程終止-Stop  
Stop: 終止線程，並且清除監控器鎖的信息，但是可能導致線程安全問題。

interrupt ：正確的終止方式。

### 线程通信
涉及到线程之间相互通信，主要分为4类
- 文件共享
- 网络共享
- 共享变量
- Jdk提供的线程协调API

### JDK API
- suspend（挂起）和resume（唤醒）：被弃用（容易写出死锁代码）  
    - 一定要在同步代码块中的使用
    - suspend比resume后执行
- wait/notify:
    - 同一对象所的持有者线程调用。
    - 虽然wait自动解锁（可以在同步代码块中使用），但是对顺序有要求。
- park/unpark机制
    - 不要求放的调用顺序
    - 多次调用unpark之后，在调用park，线程会直接运行。（但不会叠加）
    - 指定线程（参数传入指定线程）
    - 同步代码块中使用不会释放锁

- 伪唤醒  
  不可以用if来进行线程状态判断，应用while来判断。


### 线程封闭
#### 线程封闭的概念
数据被封闭在各自的线程之中，不需要同步，这种通过将数据封闭在线程中而避免使用同步的技术成为线程封闭。（体现： ThreadLocal, 局部变量）

#### ThreadLocal
ThreadLocal是Java里一种特殊的变量。
他是一个线程级别变量，每个线程都有一个ThreadLocal就是每个线程都拥有了独立的一个变量，竞争条件被彻底消除，在并发模式下是绝对安全的变量。

### 栈封闭
局部变量的固有属性之一就是封闭在线程中。
他们位于执行线程的栈中，其他线程无法访问这个栈。


