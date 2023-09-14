import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TextEditor2 {
    private List<Character> document;
    private int cursorPosition;
    private int selectionStart;
    private int selectionEnd;
    private Stack<String> clipboard;
    private Stack<String> undoStack;
    private Stack<String> redoStack;

    public TextEditor2() {
        document = new ArrayList<>();
        cursorPosition = 0;
        selectionStart = -1;
        selectionEnd = -1;
        clipboard = new Stack<>();
        undoStack = new Stack<>();
        redoStack = new Stack<>();
    }

    public void append(String text) {
        if (isTextSelected()) {
            deleteSelectedText();
        }

        char[] textArray = text.toCharArray();
        for (char c : textArray) {
            document.add(cursorPosition, c);
            cursorPosition++;
        }
        undoStack.push(document.toString());
        redoStack.clear();
    }

    public void move(int position) {
        cursorPosition = Math.min(Math.max(position, 0), document.size());
        clearSelection();
    }

    public void delete() {
        if (cursorPosition < document.size()) {
            document.remove(cursorPosition);
            //clearSelection();
        }
    }

    public String getDocument() {
        StringBuilder sb = new StringBuilder();
        for (Character c : document) {
            sb.append(c);
        }
        return sb.toString();
    }

    public void select(int left, int right) {
        selectionStart = Math.min(Math.max(left, 0), document.size());
        selectionEnd = Math.min(Math.max(right, 0), document.size());
    }

    public void copy() {
        if (isTextSelected()) {
            StringBuilder selectedText = new StringBuilder();
            for (int i = selectionStart; i < selectionEnd; i++) {
                selectedText.append(document.get(i));
            }
            clipboard.push(selectedText.toString());
        }
    }

    public void paste() {
        if (!clipboard.isEmpty()) {
            String copiedText = clipboard.peek();
            append(copiedText);
        }
    }

    private boolean isTextSelected() {
        return selectionStart != -1 && selectionEnd != -1 && selectionStart != selectionEnd;
    }

    private void clearSelection() {
        //undoStack.push()
        selectionStart = -1;
        selectionEnd = -1;
    }

    private void deleteSelectedText() {
        if (isTextSelected()) {
            for (int i = selectionEnd - 1; i >= selectionStart; i--) {
                document.remove(i);
            }
            cursorPosition = selectionStart;
            //clearSelection();
        }
    }

    

    public static void main(String[] args) {
        TextEditor2 editor = new TextEditor2();
        editor.append("Hello, world!");
        editor.select(5, 12);
        //editor.append(",");
        editor.copy();
        editor.move(12);
        editor.paste();
        editor.paste();
        String result = editor.getDocument();
        System.out.println(result);
    }
}