package com.thread.chapter4.chpater4_3;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * @author gzd
 * @date create in 2019/1/8 16:38
 **/
public class Pipe {


    public static void main(String[] args) throws IOException {

        PipedWriter pw = new PipedWriter();
        PipedReader pr = new PipedReader();

        pw.connect(pr);
        Thread thread = new Thread(new Print(pr),"PipeThread");
        thread.start();
        int receive = 0;
        while((receive = System.in.read()) != -1){
            pw.write(receive);
        }
        pw.close();

    }

    static class Print implements Runnable{
        private PipedReader pr;
        public Print(PipedReader pr){
            this.pr = pr;
        }
        public void run(){
            int recive = 0;
            try {
                while ((recive = pr.read()) != -1) {
                    System.out.print((char) recive);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
