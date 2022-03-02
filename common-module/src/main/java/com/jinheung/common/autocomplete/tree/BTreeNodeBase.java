package com.jinheung.common.autocomplete.tree;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BTreeNodeBase {
    private String grapheme;
    private Integer weight;
}
