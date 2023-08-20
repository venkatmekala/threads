https://jenkov.com/tutorials/java-concurrency/volatile.html

 Threads visibility problem is solved only when a single thread is writing and multple threads are reading the shared value. This can be solved using volatile. 

 **If two or more threads are  reading and writing** to a shared variable, then using the volatile keyword for that is not enough, volatile can't block the other threads reading/writing from/to the shared variable. Synchronizatoin can only block the other threads if a thread is already working. This problem can also be solved by using Atomic types defined under **java.util.concurrent.atomic** package. For instance AutomaticInteger, AutomaticReference

 
