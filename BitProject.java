package bitproject;


public class BitProject {  
    
    public static void main(String[] args) throws Exception {
        //Set JSON source to BitBay...        
        JsonDecode.getBitBay("BitBay");
        
        MainWindow MW = new MainWindow();
        MW.setVisible(true);
        MW.setLocationRelativeTo(null);
        
        
        /*
        * VERY IMPORTANTES...
       *
        // Periodic task...
//        Runnable helloRunnable = new Runnable() {
//            public void run() {
//                System.out.println("Hello world");
//            }
//        };
//        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
//        executor.scheduleAtFixedRate(helloRunnable, 0, 3, TimeUnit.SECONDS);
    */
        
    }
  
   
}
