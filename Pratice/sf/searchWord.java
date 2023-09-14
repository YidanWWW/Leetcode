package sf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TrieNode {
    Map<Character, TrieNode> children; //can also be  TrieNode[] children, lenght is 26
    List<String> products;

    public TrieNode() {
        children = new HashMap<>();
        products = new ArrayList<>();
    }
}

public class searchWord {
    public static void addProductToTrie(TrieNode root, String product) {
        TrieNode node = root;
        for (char c : product.toCharArray()) {
            if (!node.children.containsKey(c)) {
                node.children.put(c, new TrieNode());
            }
            node = node.children.get(c);
            node.products.add(product);
            node.products.sort(null);
            if (node.products.size() > 3) {
                node.products.remove(3);
            }
        }
    }

    public static List<List<String>> searchSuggestions(List<String> products, String search) {
        TrieNode root = new TrieNode();
        for (String product : products) {
            addProductToTrie(root, product);
        }

        List<List<String>> suggestions = new ArrayList<>();
        TrieNode node = root;
        for (char c : search.toCharArray()) {
            if (node.children.containsKey(c)) {
                node = node.children.get(c);
                suggestions.add(node.products);
            } else {
                suggestions.add(new ArrayList<>());
                node = new TrieNode();  // 如果没有匹配的前缀则重置节点
            }
        }
        return suggestions;
    }

    public static void main(String[] args) {
        
        List<String> products = new ArrayList<>();
        products.add("carpet");
        products.add("cart");
        products.add("car");
        products.add("camera");
        products.add("crate");
        String search = "camera";
        List<List<String>> result = searchSuggestions(products, search);
        for (List<String> suggestion : result) {
            System.out.println(suggestion);
        }
    }
}

