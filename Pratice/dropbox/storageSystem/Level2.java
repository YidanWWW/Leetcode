import java.util.*;

public class Level2 {
    Map<String, String> files; //name->content

    public Level2(){
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

    public String findFile(String prefix, String suffix) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(String s:files.keySet()) {
            if(s.startsWith(prefix) && s.endsWith(suffix)) {
                list.add(s);
            }
        }
        Collections.sort(list, Collections.reverseOrder());
        for(String s: list) {
            if(!sb.isEmpty()) sb.append(", ");
            sb.append(s);
            sb.append("(" + files.get(s)+")");
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        Level2 fileManager = new Level2();
        List<String> output = new ArrayList<>();

        List<String[]> queries = new ArrayList<>();
        queries.add(new String[]{"ADD FILE", "/root/dir/another dir/file.mp3", "10"});
        queries.add(new String[]{"ADD FILE", "/root/file.mp3", "5"});
        queries.add(new String[]{"ADD FILE", "/root/music/file.mp3", "7"});
        queries.add(new String[]{"COPY FILE", "/root/music/file.mp3", "/root/dir/file.mp3"});
        queries.add(new String[]{"FIND FILE", "/root", ".mp3"});
        queries.add(new String[]{"FIND FILE", "/root", "file.txt"});
        queries.add(new String[]{"FIND FILE", "/dir", "file.mp3"});

        for (String[] query : queries) {
            String command = query[0];
            String[] params = new String[query.length - 1];
            System.arraycopy(query, 1, params, 0, params.length);

            if ("ADD FILE".equals(command)) {
                boolean added = fileManager.add(params[0], params[1]);
                output.add(Boolean.toString(added));
            } else if ("COPY FILE".equals(command)) {
                boolean copied = fileManager.copy(params[0], params[1]);
                output.add(Boolean.toString(copied));
            } else if ("FIND FILE".equals(command)) {
                String foundFiles = fileManager.findFile(params[0], params[1]);
                output.add(foundFiles);
            }
        }

        // 输出结果
        for (String result : output) {
            System.out.println(result);
        }
    }


}
