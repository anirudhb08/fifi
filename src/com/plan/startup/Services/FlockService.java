package com.plan.startup.Services;

import com.plan.startup.HttpRequest.InBoundRequest;
import com.plan.startup.HttpRequest.Response;
import com.plan.startup.Utils.UtilityMethods;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by anirudh.b on 17/04/17.
 */
@Service
public class FlockService {
    public void checkLog(){
        File file = new File("/Users/anirudh.b/Desktop/fifi");
        try {
            while(true) {
                Process p = Runtime.getRuntime().exec(new String[]{"python", "checkLog.py", "pallavi.v"}, null, file);
                BufferedReader stdInput = new BufferedReader(new
                        InputStreamReader(p.getInputStream()));
                String s;
                String lastLine = null;
                while ((s = stdInput.readLine()) != null) {
                    System.out.println(s);
                    lastLine = s;
                }
                if(lastLine!=null&&!lastLine.equals("- -")){
                    break;
                }
                Thread.sleep(60000);
            }
            Map<String,String> headers = new HashMap<>();
            headers.put("Content-type", "application/json");
            InBoundRequest inBoundRequest = new InBoundRequest("api.flock.co/hooks/sendMessage/fcbc2e46-13dd-45dc-a256-dda193c1f826","POST",null,headers);
            inBoundRequest.setHttps(true);
            inBoundRequest.setPostData("{\"text\":\"Run for your lives !!\"}");
            UtilityMethods.getResponseOKClient(inBoundRequest,5000,5000);

        } catch (Exception e){
            System.out.println("Unable to play Song");
        }
    }
}
