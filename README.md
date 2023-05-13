# Hashtable

This code defines a custom implementation of a hash table called MyHashTable, which uses a separate string to resolve conflicts. The MyHashTable class uses a generic parameter of type K for the key type and V for the value type.

The MyHashTable class contains a private inner HashNode class that represents a node in a separate string data structure. Each hash node contains a key-value pair and a link to the next node in the chain, forming a linked list structure within each bucket.

The MyHashTable class provides several methods for inserting, finding, and removing hash table elements, as well as for validating values and retrieving keys with values.

To test the MyHashTable class, this code defines a custom MyTestingClass class and overrides the hashCode() method to ensure hash codes are evenly distributed. The code then creates a new instance of MyHashTable with MyTestingClass as the key type and Student as the value type and fills the hash table with 10000 random key-value pairs. Finally, the code outputs the number of elements in each cell of the hash table.
