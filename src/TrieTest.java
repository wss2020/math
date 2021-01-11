/**
 * 下面是构建前缀树和查询的代码实现：
 * Created by hanyonglu on 2019/1/7.
 */
public class TrieTest {
    private static final int CHARACTER_SIZE = 26;

    private TrieNode root;

    private static class TrieNode {
        private TrieNode[] children;

        private boolean isWordEnd;

        public TrieNode() {
            isWordEnd = false;

            children = new TrieNode[CHARACTER_SIZE];
            for (int index = 0; index < CHARACTER_SIZE; index++) {
                children[index] = null;
            }
        }
    }

    public void insert(String key) {
        TrieNode newNode = root;
        int index;

        for (int i = 0; i < key.length(); i++) {
            index = key.charAt(i) - 'a';

            if (newNode.children[index] == null) {
                newNode.children[index] = new TrieNode();
            }

            newNode = newNode.children[index];
        }

        newNode.isWordEnd = true;
    }

    public boolean search(String key) {
        TrieNode searchNode = root;
        int index;

        for (int i = 0; i < key.length(); i++) {
            index = key.charAt(i) - 'a';

            if (searchNode.children[index] == null) {
                return false;
            }

            searchNode = searchNode.children[index];
        }

        return (searchNode != null && searchNode.isWordEnd);
    }

    public static void main(String args[]) {
        String[] keys = {"my", "name", "is", "hanyonglu", "the", "son", "handongyang", "home", "near", "not", "their"};

        TrieTest tree = new TrieTest();
        tree.root = new TrieNode();

        for (int index = 0; index < keys.length ; index++) {
            tree.insert(keys[index]);
        }

        System.out.println("home result : " + tree.search("home"));
        System.out.println("their result : " + tree.search("their"));
        System.out.println("t result : " + tree.search("t"));
        System.out.println("t result : " + tree.search("homer"));
    }
}