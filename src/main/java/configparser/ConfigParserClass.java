package configparser;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class ConfigParserClass {
    private String filePath;
    Map<String, String> mapList = new HashMap<>();

    public ConfigParserClass(String fileName) {
        this.filePath = "week-2-task-Stevedeey/src/main/resources/config_files/" + fileName;
    }


    private void fileMatters() throws IOException {
        List<String> arrayList = new ArrayList<>();

        //BufferedReader bufferR = new BufferedReader(reader); //combining buffered reader with file reader to expedite the reading process for efficiency
        try (FileReader reader = new FileReader(filePath);
             BufferedReader bufferR = Files.newBufferedReader(Paths.get(filePath))) {

            Stream<String> stream = Files.lines(Paths.get(filePath));
            int numberOfLine = (int) stream.count();  //this is needed to know the no of lines in the file

            for (int i = 0; i < numberOfLine; i++) {
                arrayList.add(bufferR.readLine());
                String line = arrayList.get(i);

                //checking if there is no empty line
                if (!line.isEmpty()) {

                    if (line.indexOf("=") != -1)  //trick to skip any line that does not have equal to
                    {
                        String key = line.substring(0, line.indexOf("="));  //line.indexOf("=") returns a no and that tells the substring method where to stop.
                        String value = line.substring(line.indexOf("=") + 1);
                        if (!(mapList.containsKey(key))) {  //ensures that no two keys enter the map.
                            mapList.put(key, value);

                        }
                    }

                }


            }



        } catch (IOException ex) {
            System.out.println("Something Went Wrong " + ex);
        }
//        finally {
//            reader.close();
//            bufferR.close();    //this is not required as try with resource featues has handled it
//        }

    }

    public String getFieldValue(String key) throws IOException {
        this.fileMatters();
        String value = "";
        if(key.equals("application.name")) return mapList.get("name");
        if(key.equals("application.host")) return mapList.get("host");
        if(key.equals("application.context-url")) return mapList.get("context-url");
        for (Map.Entry<String, String> data : mapList.entrySet()) {
            if (data.getKey().equals(key)) {
                value = data.getValue();
            }
        }
        if (value.length() > 0) {
            return value;
        } else {
            return "No such data";
        }

    }
}
