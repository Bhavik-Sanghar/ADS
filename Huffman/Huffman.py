from collections import Counter

# Step 1: Calculate frequencies
def calculate_frequencies(data):
    return Counter(data)

# Step 2: Build the Huffman Tree (Naive approach)
class Node:
    def __init__(self, char, freq):
        self.char = char        # Character
        self.freq = freq        # Frequency
        self.left = None        # Left child
        self.right = None       # Right child

def build_huffman_tree(frequencies):
    # Create a list of nodes for each character
    nodes = [Node(char, freq) for char, freq in frequencies.items()]
    
    # Build the tree by combining nodes with the smallest frequencies
    while len(nodes) > 1:
        # Sort nodes by frequency (naive sorting, not efficient)
        nodes = sorted(nodes, key=lambda x: x.freq)
        
        # Take the two smallest nodes
        left = nodes.pop(0)
        right = nodes.pop(0)
        
        # Create a new internal node with the combined frequency
        new_node = Node(None, left.freq + right.freq)
        new_node.left = left
        new_node.right = right
        
        # Add the new node back to the list
        nodes.append(new_node)
    
    # The remaining node is the root of the Huffman Tree
    return nodes[0]

# Step 3: Assign binary codes to characters
def assign_codes(node, current_code="", codes={}):
    if node is None:
        return
    
    # If it's a leaf node, assign the current code
    if node.char is not None:
        codes[node.char] = current_code
    
    # Recur on left and right children
    assign_codes(node.left, current_code + "0", codes)
    assign_codes(node.right, current_code + "1", codes)
    
    return codes

# Step 4: Encode the input string
def encode(data, codes):
    return ''.join([codes[char] for char in data])

# Step 5: Decode the binary string (optional)
def decode(encoded_data, root):
    decoded_str = ""
    current_node = root
    
    for bit in encoded_data:
        if bit == '0':
            current_node = current_node.left
        else:
            current_node = current_node.right
        
        # If it's a leaf node, append the character
        if current_node.char is not None:
            decoded_str += current_node.char
            current_node = root  # Reset to root for the next character
    
    return decoded_str

# Example usage:
if __name__ == "__main__":
    data = "hello"
    
    # Step 1: Calculate frequencies
    frequencies = calculate_frequencies(data)
    print("Character Frequencies:", frequencies)
    
    # Step 2: Build Huffman Tree
    huffman_tree_root = build_huffman_tree(frequencies)
    
    # Step 3: Assign codes
    huffman_codes = assign_codes(huffman_tree_root)
    print("Huffman Codes:", huffman_codes)
    
    # Step 4: Encode the data
    encoded_data = encode(data, huffman_codes)
    print("Encoded Data:", encoded_data)
    
    # Optional: Decode the data
    decoded_data = decode(encoded_data, huffman_tree_root)
    print("Decoded Data:", decoded_data)
