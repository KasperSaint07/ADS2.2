# Custom Data Structures in Java

This project contains implementations of fundamental data structures in Java **without using Java's built-in collections**.  
Each structure is built from scratch and follows the `MyList<T>` interface.

---

##  Contents

### `MyArrayList<T>`
Custom dynamic array (resizable array):
- Methods: `add`, `get`, `remove`, `set`, `clear`, `sort`, `toArray`, `addFirst`, `addLast`, etc.

###  `MyLinkedList<T>`
Doubly linked list implementation:
- Methods: `add`, `get`, `remove`, `addFirst`, `addLast`, `removeFirst`, `removeLast`, `sort`, etc.

###  `MyStack<T>`
Stack (LIFO) structure built on `MyArrayList` or `MyLinkedList`:
- `push`, `pop`, `peek`, `isEmpty`, `size`

###  `MyQueue<T>`
Queue (FIFO) structure built on `MyArrayList` or `MyLinkedList`:
- `enqueue`, `dequeue`, `peek`, `isEmpty`, `size`

###  `MyMinHeap<T>`
Minimum heap built using `MyArrayList`:
- `insert`, `getMin`, `extractMin`, `printHeap`, `size`

---
