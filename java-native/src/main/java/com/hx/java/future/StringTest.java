package com.hx.java.future;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class StringTest {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://www.baidu.com");

        System.out.println("host:"+url.getHost());
        System.out.println("port:"+url.getPort());
        System.out.println("uri_path:"+url.getPath());

        for (int i = 0; i < 1; i++) {
            URLConnection connection = url.openConnection();
            System.out.println(connection.toString());
            try (InputStream in = connection.getInputStream();) {

                ByteArrayOutputStream output = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int len = -1;
                while ((len = in.read(buffer)) != -1) {
                    output.write(buffer, 0, len);
                }

                System.out.println(new String(output.toByteArray()));

            } catch (IOException e) {
                e.printStackTrace();
            }
        }



        Integer integer = 20;
        String s = String.valueOf(integer);
        for (int i = 0; i < s.length(); i++) {
            System.out.println(s.charAt(i));
        }
    }
}
