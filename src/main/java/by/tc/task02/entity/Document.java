package by.tc.task02.entity;

import java.io.Serializable;

public class Document implements Serializable {

    private static final long serialVersionUID = 1L;

    private Element rootNode;

    public Element getRootNode() {
        return rootNode;
    }

    public void setRootNode(Element rootNode) {
        this.rootNode = rootNode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Document document = (Document) o;

        return rootNode != null ? rootNode.equals(document.rootNode) : document.rootNode == null;
    }

    @Override
    public int hashCode() {
        return rootNode != null ? rootNode.hashCode() : 0;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Document{");
        sb.append("rootNode=").append(rootNode);
        sb.append('}');
        return sb.toString();
    }
}
