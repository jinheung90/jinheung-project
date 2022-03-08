package com.jinheung.common.autocomplete.tree;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

@Getter
@Setter

public class BTreeNodeBase implements Comparator<BTreeNodeBase> {
    private String word;
    private Integer weight;

    private boolean isFinal;
    private HashMap<Character,BTreeNodeBase> children;

    public BTreeNodeBase(String word, Integer weight, boolean isFinal) {
        this.word = word;
        this.weight = weight;
        this.isFinal = isFinal;
        this.children = new HashMap<>();
    }

    public BTreeNodeBase() {
        this.children = new HashMap<>();
    }

    public void addChildren(Character character, BTreeNodeBase bTreeNodeBase) {
        children.put(character, bTreeNodeBase);
    }

    @Override
    public int compare(BTreeNodeBase o1, BTreeNodeBase o2) {
        if(o1.getWeight() > o2.getWeight()) {
            return 1;
        } else if(o1.getWeight() < o2.getWeight()) {
            return 0;
        } else {
            return o1.getWord().compareTo(o2.getWord());
        }
    }
}
