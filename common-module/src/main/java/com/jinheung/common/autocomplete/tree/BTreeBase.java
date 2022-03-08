package com.jinheung.common.autocomplete.tree;

import com.jinheung.common.autocomplete.GraphemeSeparate;
import com.jinheung.common.autocomplete.SeparationGrapheme;
import com.sun.source.tree.Tree;
import com.sun.source.util.Trees;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.nio.file.Path;
import java.rmi.UnexpectedException;
import java.util.*;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
@Setter
public class BTreeBase {

    private Map<Character, BTreeNodeBase> root;
    public BTreeBase() {
        root = new HashMap<>();
    }
    public void save(String word) {
        List<Character> characters = GraphemeSeparate.splitHangeulToConsonant(word);
        BTreeNodeBase current = root.get(characters.get(0));

        if (current == null) {
            current = new BTreeNodeBase(null, 30, false);
            root.put(characters.get(0), current);
        }

        BTreeNodeBase next = null;
        int size = characters.size() - 1;
        for (int i = 1; i <= size; i++) {
            if (size == i) {
                current.getChildren().put(characters.get(i), new BTreeNodeBase(word, 30, true));
            } else {
                next = current.getChildren().get(characters.get(i));
                if (next == null) {
                    next = new BTreeNodeBase(null, 30, false);
                    current.getChildren().put(characters.get(i), next);
                } else {
                    current = next;
                }
            }
        }

    }

    // 시간 복잡도 hashmap O(1)
    public List<String> search(String word) {
        List<Character> characters = GraphemeSeparate.splitHangeulToConsonant(word);
        TreeSet<BTreeNodeBase> treeSet = new TreeSet<>();
        for (int i = 0; i < characters.size(); i++) {

        }

        return treeSet.stream().map(t -> t.getWord()).collect(Collectors.toList());
    }

}
