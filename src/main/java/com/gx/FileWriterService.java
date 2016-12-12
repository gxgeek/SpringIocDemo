package com.gx;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;



@Component
public class FileWriterService {
	
    @Value("#{configProperties['url']}")
    private static String url="1.txt";
	private FileOutputStream out;	
	@PostConstruct
	public void init() throws IOException {
		System.out.println("init");
		File file = new File(url);
		if(file.exists()){
			
		}else{
			file.createNewFile();
		}
		out = new FileOutputStream(file);
	}
	
	
    public void write(String content){	
    	byte[] by = content.getBytes();    	
    	try {
			out.write(by, 0, by.length);
    	} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @PreDestroy
    public void destroy() {
    	System.out.println("destroy ");
    	if(out!=null){
        	try {
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
    	}
    }
}
