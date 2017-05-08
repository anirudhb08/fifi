package com.plan.startup.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Queue;

/**
 * Created by anirudh.b on 06/05/17.
 */
@Service
public class SaavnService {
    @Autowired
    List<String> songList;
    int count;
    String currentSong;
    int currentCount;

    public void addSong(String str){
        songList.add(str);
    }

    public SaavnService(){
        count = 0;
        currentCount = 0;
    }

    public String getSong(){
        if(songList.size()==0){
            return "";
        }
        String s = songList.get(0);
        songList.remove(0);
        return s;
    }

    public int subscribe(){
        count++;
        return count;
    }

    public String getCurrentSong(){
        if(currentCount == 0 || currentSong.equals("")){
            currentCount = Math.max(0,count - 1);
            currentSong = getSong();
        } else {
            currentCount--;
        }
        return currentSong;
    }
}


