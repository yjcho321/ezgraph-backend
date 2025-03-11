package yjcho.ezgraph.app.content;

import javax.swing.text.AbstractDocument;

public class ContentNotFoundException extends RuntimeException {

    public ContentNotFoundException(String id) {
        super("Could not find content with Id: " + id);
    }
}
