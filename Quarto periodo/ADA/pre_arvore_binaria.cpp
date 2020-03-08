#include <iostream>
#include <vector>
#include <list>

using namespace std;

template <class T>
class Node {
    public:
        T value;
        Node *left;
        Node *right;
        Node(T value, Node* left, Node* right);
        Node(T value) : Node(value, nullptr, nullptr){};
};

template <class T>
Node<T>::Node(T value, Node* left, Node* right){
    this->value = value;
    this->left = left;
    this->right = right;
}

// begin BinaryTree
template <class T>
class BinaryTree {
    private:
        Node<T> *root;
        Node<T>* insert(T value, Node<T> *node);
        Node<T>* remove(T value, Node<T> *node);
        Node<T>* predecessor(Node<T> *n1, Node<T> *n2);
        void delete_all(Node<T> *node);
        void print(Node<T> *node);
        void print_esq(Node<T> *node);
        void print_dir(Node<T> *node);
    public:
        BinaryTree();
        ~BinaryTree();
        void insert(T value);
        Node<T>* remove(T value);
        void print();
        void print_esq();
        void print_dir();
};

template <class T>
BinaryTree<T>::BinaryTree(){
    this->root = nullptr;
}

template <class T>
BinaryTree<T>::~BinaryTree(){
    if(root != nullptr){
        this->delete_all(root);
    }
}

template <class T>
void BinaryTree<T>::delete_all(Node<T> *node){
    if(node != nullptr){
        this->delete_all(node->left);
        this->delete_all(node->right);
        delete node;
        node = nullptr;
    }
}

template <class T>
Node<T>* BinaryTree<T>::insert(T value, Node<T> *node){
    if (node == nullptr){
        node = new Node<T>(value);
    }
    else if (value < node->value){
        node->left = insert(value, node->left);
    }
    else if (value > node->value){
        node->right = insert(value, node->right);
    }
    return node;
}

template <class T>
void BinaryTree<T>::insert(T value){
    root = this->insert(value, root);
}

template <class T>
Node<T>* BinaryTree<T>::remove(T value, Node<T> *node){
    if(node != nullptr){
        if(value < node->value){
            node->left = remove(value, node->left);
        }
        else if(value > node->value){
            node->right = remove(value, node->right);
        }
        else if (node->left == nullptr){
            auto tmp = node->right;
            delete node;
            node = tmp;
        }
        else if (node->right == nullptr){
            auto tmp = node->left;
            delete node;
            node = tmp;
        }
        else {
            node->left = this->predecessor(node, node->left);
        }
    }
    return node;
}

template <class T>
Node<T>* BinaryTree<T>::remove(T value){
    return remove(value, root);
}

template <class T>
Node<T>* BinaryTree<T>::predecessor(Node<T> *n1, Node<T> *n2){
    if(n2->right != nullptr){
        n2->right = predecessor(n1, n2->right);
    }
    else{
        n1->value = n2->value;
        auto tmp = n2->left;
        delete n2;
        n2 = tmp;
    }
    return n2;
}

template <class T>
void BinaryTree<T>::print(Node<T> *node){
    if(node != nullptr){
        this->print(node->left);
        cout << node->value << " ";
        this->print(node->right);
    }
}

template <class T>
void BinaryTree<T>::print(){
    this->print(root);
}

template <class T>
void BinaryTree<T>::print_esq(Node<T> *node){
    if(node != nullptr){
        cout << node->value << " ";
        this->print_esq(node->left);
        this->print_esq(node->right);
    }
}

template <class T>
void BinaryTree<T>::print_esq(){
    this->print_esq(root);
}

template <class T>
void BinaryTree<T>::print_dir(Node<T> *node){
    if(node != nullptr){
        this->print_dir(node->left);
        this->print_dir(node->right);
        cout << node->value << " ";
    }
}

template <class T>
void BinaryTree<T>::print_dir(){
    this->print_dir(root);
}
// end BinaryTree

int main() {
    int num {};
    cin >> num;
    while(num != 0){
        auto *bt = new BinaryTree<int>();
        for(int i = 0; i < num; i++){
            int value {};
            cin >> value;
            bt->insert(value);
        }
        bt->print_esq();
        cout << endl;
        delete bt;
        bt = nullptr;
        cin >> num;
    }
    return 0;
}