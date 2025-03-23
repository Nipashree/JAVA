#include <iostream>
using namespace std;

// Base class
class A {
public:
    void showA() {
        cout << "Class A" << endl;
    }
};

// Derived from A (Single Inheritance)
class B : public A {
public:
    void showB() {
        cout << "Class B" << endl;
    }
};

// Another class derived from A (Hierarchical Inheritance)
class C : public A {
public:
    void showC() {
        cout << "Class C" << endl;
    }
};

// Class D inherits from both B and C (Multiple Inheritance)
class D : public B, public C {
public:
    void showD() {
        cout << "Class D" << endl;
    }
};

int main() {
    D obj;
    
    // Calling functions from different classes
    obj.showB(); // From Class B
    obj.showC(); // From Class C
    obj.showD(); // From Class D

    // Ambiguity occurs while accessing showA(), as both B and C inherit A.
    // obj.showA(); // This will cause ambiguity

    // To resolve ambiguity, we explicitly specify the class
    obj.B::showA();
    obj.C::showA();

    return 0;
}
