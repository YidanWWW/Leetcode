import java.util.ArrayList;
import java.util.List;

public class TextEditor {
    private List<Character> document;
    private int cursorPosition;

    public TextEditor() {
        document = new ArrayList<>();
        cursorPosition = 0;
    }

    public void append(String text) {
        char[] textArray = text.toCharArray();
        for (char c : textArray) {
            document.add(cursorPosition, c);
            cursorPosition++;
        }
    }

    public void move(int position) {
        cursorPosition = Math.min(Math.max(position, 0), document.size());
    }

    public void delete() {
        if (cursorPosition < document.size()) {
            document.remove(cursorPosition);
        }
    }

    public String getDocument() {
        StringBuilder sb = new StringBuilder();
        for (Character c : document) {
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        editor.append("Hello! world!");
        editor.move(5);
        editor.delete();
        editor.append(", ");
        String result = editor.getDocument();
        System.out.println(result);
    }
}