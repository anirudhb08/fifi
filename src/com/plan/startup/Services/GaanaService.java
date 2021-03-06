package com.plan.startup.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.AbstractQueue;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import javax.annotation.Resource;

/**
 * Created by anirudh.b on 11/02/17.
 */
@Service
public class GaanaService implements  Runnable{
    @Autowired LinkedBlockingQueue<String> queue;
    public int playSong(String songName){
        System.out.println(songName);
        //File file = new File("");
        try {
            Process p = Runtime.getRuntime().exec(new String[]{"python", "getSongUrl.py", songName});
            BufferedReader stdInput = new BufferedReader(new
                    InputStreamReader(p.getInputStream()));

            BufferedReader stdError = new BufferedReader(new
                    InputStreamReader(p.getErrorStream()));

            // read the output from the command
            System.out.println("Here is the standard output of the command:\n");
            String s;
            int songDuration ;
            while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
                songDuration = Integer.parseInt(s);
                return songDuration;
            }
        } catch (Exception e){
            System.out.println("Unable to play Song");
        }
        return 0;
    }

    public void run(){
        while(true){
            /*if(queue.size()==0){
                try {
                    wait();
                } catch (InterruptedException e){
                    System.out.println(queue.size());
                }
            }*/
        	String currentSong = null;
        	try {
				currentSong = queue.take();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        	
            //String currentSong = queue.peek();
        	if(currentSong == null){
        		continue;
        	}
            int songDuration = playSong(currentSong);
            try {
                Thread.sleep(songDuration*1000+2000);
                //queue.remove();
            } catch (InterruptedException e){
                System.out.println("Interrupted");
            }
        }
    }
}
