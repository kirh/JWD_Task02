package by.tc.task02.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Element extends Node {

    private static final long serialVersionUID = 1L;

    private String tagName;

    private Map<String, String> attributes = new HashMap<>();

    private List<Node> childNodes = new ArrayList();

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }

    public boolean hasAttributes() {
        return !attributes.isEmpty();
    }

    public List<Node> getChildNodes() {
        return childNodes;
    }

    public void setChildNodes(List<Node> childNodes) {
        this.childNodes = childNodes;
    }

    public boolean hasChildNodes() {
        return !childNodes.isEmpty();
    }

    public void addChild(Node node) {
        childNodes.add(node);
        node.setParent(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Element element = (Element) o;

        if (tagName != null ? !tagName.equals(element.tagName) : element.tagName != null) return false;
        if (!attributes.equals(element.attributes)) return false;
        return childNodes.equals(element.childNodes);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (tagName != null ? tagName.hashCode() : 0);
        result = 31 * result + attributes.hashCode();
        result = 31 * result + childNodes.hashCode();
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Element{");
        sb.append("tagName='").append(tagName).append('\'');
        sb.append(", attributes=").append(attributes);
        sb.append(", childNodes=");
        sb.append('}');
        return sb.toString();
    }
}
