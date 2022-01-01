# BinarySearchTree

This class contains a simple binary search tree can perform basic BST operations using integers as a value
Insertion and Deletion take O(log2 n) time since the amount of nodes is halved for every iterated node.
In other words, for 8 nodes, it would take 3 units of time on average to insert a node

operations:
search -> returns index of specified value
remove -> removes node containing specified value
findMin -> returns node with lowest value in tree
print_inorder -> prints BST with in-order traversal
print_preorder -> prints BST with pre-order traversal
print_postorder -> prints BST with post-order traversal
