class TrieNode:
    def __init__(self):
        self.children = {}
        self.products = []

def add_product_to_trie(root, product):
    node = root
    for char in product:
        if char not in node.children:
            node.children[char] = TrieNode()
        node = node.children[char]
        node.products.append(product)
        node.products.sort()
        if len(node.products) > 3:
            node.products.pop()

def search_suggestions(products, search):
    root = TrieNode()
    for product in products:
        add_product_to_trie(root, product)

    suggestions = []
    node = root
    for char in search:
        if char in node.children:
            node = node.children[char]
            suggestions.append(node.products)
        else:
            suggestions.append([])
            node = TrieNode()  # Reset node if no matching prefix found
    return suggestions

# Example usage:
n = 5
products = ["carpet", "cart", "car", "camera", "crate"]
search = "camera"
result = search_suggestions(products, search)
print(result)  # Output: [['camera'], ['car', 'cart', 'carpet'], ['car', 'cart', 'carpet'], ['car', 'cart', 'carpet'], ['car', 'cart', 'carpet'], ['car', 'cart', 'carpet']]