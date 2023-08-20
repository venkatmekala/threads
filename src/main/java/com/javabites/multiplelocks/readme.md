==> In worker2 example, the program takes more time due to the fact that we are applying th synchronization or intrinsic or monitor lock on the whole object. It's going to hit the performance badly. Which means that if a thread acquires the lock on method stageOne, any other threads try to execute method stageTwo won't be allowed since the lock in this example applied at object level. Though the methods are independent, the lock is applied on the object.


