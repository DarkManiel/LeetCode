__author__ = 'markdaniel'
class TrieNode(object):
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.char = None
        self.isWord = False
        self.children = {}
    def __str__(self):
        return str(self.char) + ' isWord: ' + str(self.isWord)


class Trie(object):

    def __init__(self):
        self.root = TrieNode()

    def insert(self, word):
        """
        Inserts a word into the trie.
        :type word: str
        :rtype: void
        """
        node = self.root
        index = 0
        while index < len(word):
            has_child = node.children[word[index]] if word[index] in node.children else None
            # Loop through existing matches
            while has_child and index < len(word):
                index += 1
                node = has_child
                has_child = node.children[word[index]] if word[index] in node.children else None
                if has_child:
                    node = has_child
                    if index == len(word) - 1:
                        node.isWord = True
                        return
            # Add new characters
            if index < len(word) and node and not word[index] in node.children:
                new_node = TrieNode()
                char = word[index]
                new_node.char = char
                node.children[char] = new_node
                node = new_node
            if index == len(word) - 1:
                node.isWord = True
            index += 1

    def search(self, word):
        """
        Returns if the word is in the trie.
        :type word: str
        :rtype: bool
        """
        node = self.root
        index = 0
        for char in word:
            has_char = node.children[char] if char in node.children else None
            if has_char:
                if index == len(word) - 1 and has_char.isWord:
                    return True
                node = has_char
            else:
                return False
            index += 1
        return False

    def startsWith(self, prefix):
        """
        Returns if there is any word in the trie
        that starts with the given prefix.
        :type prefix: str
        :rtype: bool
        """
        node = self.root
        for char in prefix:
            has_char = node.children[char] if char in node.children else None
            if not has_char:
                return False
            node = has_char
        return True

# Your Trie object will be instantiated and called as such:
# trie = Trie()
# trie.insert("somestring")
# trie.search("key")

if __name__ == '__main__':
    trie = Trie()
    # trie.insert('aple')
    # trie.printTree(trie.root)
    # trie.insert('ap')
    # trie.insert('atom')
    # trie.insert('beta')
    # print()
    # trie.printTree(trie.root)
    # print(trie.search('atom'))
    # print(trie.search('cat'))
    # print(trie.search('apple'))
    # print(trie.startsWith('ap'))
    # print(trie.startsWith('oo'))

    # trie.insert("abc")
    # print(trie.search("abc"))
    # print(trie.search("ab"))
    # trie.insert("ab")
    # print(trie.search("ab"))
    # trie.insert("ab")
    # print(trie.search("ab"))

    trie.insert("ab")
    print(trie.search("abc"))
    print(trie.search("ab"))
    print(trie.startsWith("abc"))
    print( trie.startsWith("ab"))
    trie.insert("ab")
    print(trie.search("abc"))
    print(trie.startsWith("abc"))
    trie.insert("abc")
    print(trie.search("abc"))
    print(trie.startsWith("abc"))
    #
    # trie.insert("p")
    # print(trie.startsWith("pr"))
    # print(trie.search("p"))
    # trie.insert("pr")
    # print(trie.startsWith("pre"))
    # print(trie.search("pr"))
    # trie.insert("pre")
    # print(trie.startsWith("pre"))
    # print(trie.search("pre"))
    # trie.insert("pref")
    # print(trie.startsWith("pref"))
    # print(trie.search("pref"))
    # trie.insert("prefi")
    # print(trie.startsWith("pref"))
    # print(trie.search("prefi"))
    # trie.insert("prefix")
    # print(trie.startsWith("prefi"))
    # trie.search("prefix")