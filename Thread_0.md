## Thread_0

1. #### Thread의 구현과 실행

   - ```java
     //	Thread 클래스를 상속
     class MyThread extends Thread{
         public void run(){/* 작업내용 */}	//	Thread 클래스의 run()을 오버라이딩
     }
     ```

   - ```java
     //	Runnable 인터페이스를 구현
     class MyThread implements Runnable{
         public void run(){/* 작업내용 */}	//	Runnable 인터페이스의 run()을 구현
     }
     ```

   - Runnable 인터페이스를 구현하는 방법이 reusability가 높고 코드의 consistency를 유지할 수 있기 때문에 객체지향적인 방법이라 할 수 있음

   - ```java
     //	Thread를 상속받은 class에서는 간단히 getName()이 가능하지만
     //	Runnable을 구현한 class에서는 Thread.currentThread().getName()을 해야함
     System.out.println(Thread.currentThread().getName());
     ```

   - ##### Thread의 실행 - start()

     ```java
     Thread t1 = new Thread();
     t1.start();
     t1.start(); // 예외발생
     
     // 올바른 코드
     Thread t1 = new Thread();
     t1.start();
     t1 = new Thread(); // Thread를 다시 생성
     t1.start();
     ```

2. #### start()와 run()

   