class TextState {
    String content;
    TextState prev, next;

    public TextState(String content) {
        this.content = content;
        this.prev = this.next = null;
    }
}

public class UndoRedoTextEditorDLL {
    private TextState current;
    private int maxSize = 10;
    private int size = 0;

    public void type(String content) {
        TextState newState = new TextState(content);
        if (current != null) {
            current.next = newState;
            newState.prev = current;
        }
        current = newState;
        size++;
        if (size > maxSize) {
            while (current.prev != null && current.prev.prev != null) {
                current.prev.prev.next = current;
                current.prev = current.prev.prev;
                size--;
            }
        }
    }

    public void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
        }
    }

    public void redo() {
        if (current != null && current.next != null) {
            current = current.next;
        }
    }

    public void showCurrent() {
        if (current != null) {
            System.out.println("Current Text: " + current.content);
        } else {
            System.out.println("No content yet.");
        }
    }

    public static void main(String[] args) {
        UndoRedoTextEditorDLL editor = new UndoRedoTextEditorDLL();
        editor.type("Hello");
        editor.type("Hello World");
        editor.type("Hello World Again");
        editor.showCurrent();
        editor.undo();
        editor.showCurrent();
        editor.redo();
        editor.showCurrent();
    }
}