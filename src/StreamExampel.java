import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StreamExampel {
    public static void justRead(){
        FileInputStream fis = null;
        try {
//            fis = new FileInputStream("Test/test.txt");
            fis = new FileInputStream("C:\\Users\\Java Core Student 1\\IdeaProjects\\Lesson17\\Test");
        //
            System.out.println("file size in bytes: " + fis.available());
            int content;
            while ((content = fis.read())!= -1){
                System.out.print((char)content);
            }
        }catch (IOException e){
            System.out.print(e.getMessage());
        }finally {
            if (fis!= null){
                try{
                    fis.close();
                }catch (IOException e){
                    System.out.print(e.getMessage());
                }
            }
        }
    }

    public static void readWithReSources(){
        try(FileInputStream fis = new FileInputStream("Test1/test.txt")){
            System.out.println("file size " + fis.available());
            int content;
            while ((content = fis.read())!= -1){
                System.out.print((char)content);
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public static void readAndWrite(){
        try(FileInputStream fis = new FileInputStream("Test/test.txt");
            FileOutputStream fos = new FileOutputStream("Test1\\result.txt")) {
            int content;

            while ((content = fis.read()) != -1) {
                System.out.println((char)content);
                fos.write(content);
            }


        }catch (IOException e){
                e.printStackTrace();
        }
    }

    public static void  readAndWriteWithoundClosing(){
        FileInputStream fis= null;
        FileOutputStream fos = null;
        try{
            fis = new FileInputStream("Test/test.txt");
            fos = new FileOutputStream("Test1/test.txt");
            int content;
            while ((content= fis.read()) != -1){
                System.out.println((char)content);
                fos.write(content);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void bufferedInputStream(){
        InputStream inStream = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bas = null;
        try{
            inStream = new FileInputStream("Test/test.txt");
            bis =new BufferedInputStream(inStream);
            bas = new BufferedOutputStream(new FileOutputStream("Test/buff_res.txt"));

            while(bis.available() > 0){
                char c = (char)bis.read();
                System.out.println("char : " + c);
                bas.write(c);
            }
        } catch (Exception e){
            e.printStackTrace();
     }
             finally {
           if (inStream != null && bis!=null && bas != null){
                try{
                    inStream.close();
                    bis.close();
                   bas.close();
                }catch (IOException e ){
                   e.printStackTrace();
                }
            }
        }

    }

  public static List<String> getLinesfromFile(){
        File file =new File("Test/test.txt");
        List<String>result = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            String line;
            while((line =br.readLine())!= null){
                System.out.println(line);
                result.add(line);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return result;
  }



    public static void main(String[] args) {
        // justRead();
       // readWithReSources();
        // readAndWrite();
      //  readAndWriteWithoundClosing();
       // bufferedInputStream();

        List<String> file = getLinesfromFile();
        for(String s: file){
            System.out.println(s);
        }
    }

}
