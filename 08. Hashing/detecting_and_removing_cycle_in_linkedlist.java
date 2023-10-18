class node {
  int data;
  node next;
  node(int d) {
    data = d;
    next = null;
  }
}

class Main {

  public static void main(String args[]) {
    node head = new node(15);
    head.next = new node(10);
    head.next.next = new node(12);
    head.next.next.next = new node(20);
    head.next.next.next.next = head.next;
    loopDetDelBetter(head);
    if (FLD(head)) {
      System.out.println("Loop Detected");
    } else System.out.println("Loop not detected");
  }

static void loopDetDelBetter(node head) {
    // step 1
    node slow = head;
    node fast = head;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        break;
      }
    }
    if (slow != fast) return;

    node ptr1 = slow;
    node ptr2 = slow;

    // step 2
    int x = 1;
    while (ptr2.next != ptr1) {
      ptr2 = ptr2.next;
      x++;
    }

    // step 3
    ptr1 = head; // move one pointer to head
    ptr2 = head;
    for (int i = 0; i < x; i++) {
      ptr2 = ptr2.next; // move one pointer to xth node from head;
    }

    // step 4
    while (ptr1 != ptr2) {
      ptr1 = ptr1.next;
      ptr2 = ptr2.next;
    }

    // step 5
    while (ptr2.next != ptr1) {
      ptr2 = ptr2.next;
    }
    ptr2.next = null;
  }
  public static boolean FLD(node head) {
    node slow = head;
    node fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) return true;
    }
    return false;
  }
}
