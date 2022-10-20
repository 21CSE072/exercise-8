public class multithreading {
    public static void main(String[] args) {
        A obj = new A(); 
        Thread1 t1 = new Thread1(obj);
        Thread2 t2 = new Thread2(obj);
        t1.start();
        t2.start();
    }
 }
 class A
{
 int i;	
 boolean flag = false; 
synchronized void deliver(int i)
{
 if(flag)
 try
 {
  wait();	 
 }
 catch(InterruptedException e)
 {
  System.out.println(e);	 
 }
   this.i = i;	
   flag = true; 
   System.out.println("Data Delivered: " +i);
   notify(); 
 }
synchronized int receive()
{
if(!flag)
try {
 wait(); 	
}
catch(InterruptedException e){
 System.out.println(e);	
}
 System.out.println("Data Received: " + i); 
  flag = false; 
  notify(); 
  return 
 }
 }
class Thread1 extends Thread
{
 A obj;
 Thread1(A obj)
 {
  this.obj = obj;
 }
public void run()
{
for(int j = 1; j <= 5; j++)
{
 obj.deliver(j); 	
  }
}
}
class Thread2 extends Thread 
{
A obj;
Thread2(A obj)
{
 this.obj = obj;
}
public void run()
{
for(int k = 0; k <= 5; k++){
 obj.receive();	
}
 }
}
 
