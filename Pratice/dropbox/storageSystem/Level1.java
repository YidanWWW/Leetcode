import java.util.*;

public class Level1 {
    Map<String, String> files; //name->content

    public Level1(){
        files = new HashMap<>();
    }

    public boolean add(String name, String size) {
        if(!files.containsKey(name)) {
            files.put(name, size);
            return true;
        }
        return false;
    }

    public boolean copy(String from, String to) {
        if(files.containsKey(from) && !files.containsKey(to)) {
            files.put(to, files.get(from));
            //files.remove(from);
            return true;
        }
        return false;
    }

    public String getFileSize(String name) {
        if(files.containsKey(name)) {
            return files.get(name);
        }
        return "";
    }

    public static void main(String[] args) {
        Level2 fileManager = new Level2();
            List<String> output = new ArrayList<>();
    
            List<String[]> queries = new ArrayList<>();
            queries.add(new String[]{"ADD_FILE", "/dir1/dir2/file.txt", "10"});
            queries.add(new String[]{"COPY FILE", "/not-existing-file", "/dir1/file.txt"});
            queries.add(new String[]{"COPY FILE", "/dir1/file.txt", "/dir1/dir2/file.txt"});
            queries.add(new String[]{"ADD FILE", "/dir1/file.txt", "15"});
            queries.add(new String[]{"COPY_FILE", "/dir1/file.txt", "/dir1/dir2/file.txt"});
            queries.add(new String[]{"GET_FILE_SIZE", "/dir1/file.txt"});
            queries.add(new String[]{"GET_FILE_SIZE", "/not-existing-file"});
    
            for (String[] query : queries) {
                String command = query[0];
                String[] params = new String[query.length - 1];
                System.arraycopy(query, 1, params, 0, params.length);
    
                if ("ADD_FILE".equals(command)) {
                    boolean added = fileManager.add(params[0], params[1]);
                    output.add(Boolean.toString(added));
                } else if ("COPY FILE".equals(command)) {
                    boolean copied = fileManager.copy(params[0], params[1]);
                    output.add(Boolean.toString(copied));
                } else if ("GET_FILE_SIZE".equals(command)) {
                    String fileSize = fileManager.getFileSize(params[0]);
                    output.add(fileSize);
                }
            }
    
            // 输出结果
            for (String result : output) {
                System.out.println(result);
            }
        }
}
