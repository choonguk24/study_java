## 线程状态
1. New
1. Runnable
3. Blocked
4. Waiting
5. Timed Watting
### 线程状态切换
![img](https://img-blog.csdnimg.cn/20181120173640764.jpeg?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3BhbmdlMTk5MQ==,size_16,color_FFFFFF,t_70)

### 線程終止
- 不正確的線程終止-Stop  
Stop: 終止線程，並且清除監控器鎖的信息，但是可能導致線程安全問題。

interrupt ：正確的終止方式。
