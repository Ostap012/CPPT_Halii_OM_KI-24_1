package lab7;


import java.util.ArrayList;

public class LinkedList {
    public static void main(String[] args) {

        LinkList <? super Data>newList = new LinkList<Data>();
        
        newList.insertFirst(13, 50);
        newList.insertFirst(40, 345);
        newList.insertFirst(15, 25);
        newList.insertFirst(5, 102);
        newList.insertFirst(54, 12);
        newList.insertFirst(10, 30);
        
        newList.displayList();
        
        Link f = newList.find(5);
        System.out.print("The smallest data on LinkedList is: \n");
        
       
        f.print();
        
        System.out.print("Sum = " + newList.sum + "\n");

        
    }

}

interface Data extends Comparable<Data> {
	   public int getKey();
	   public void print();
	 }

class Link implements Data{
    public  int iData; // ����������
    public int dData; // ����������
    public Link next; // ��������� �� ��������� ������� ������
    
    public Link(int iData, int dData) {
        this.iData = iData;
        this.dData = dData;
    }
    
    public void displayLink() {
        System.out.print(" {" + iData + ", " + dData + "}");
        
    }


	public int compareTo(Data o) {
		Integer s = iData;
		   return s.compareTo(o.getKey());
	}

	
	public int getKey() {
		
		int sum = 0;
		if(dData%2 ==0) {
		//System.out.print("Info: " + dData + "\n");
		sum++;
		}
		System.out.print(sum + "\n");
		return dData;
	}


	public void print() {
		
		System.out.print("Key: " + iData + "\n");
		
	}

	
}

class LinkList <T extends Data> {
    private Link first;
    private ArrayList<T> arr;
    public  static int sum = 0;

    public LinkList(){
      arr = new ArrayList<T>();
    }
    
    public void insertFirst(int iD, int dD) {

        Link newLink = new Link(iD, dD); //��������� ����� ������� ������
        newLink.next = first;            //������� �� ������ "������" ������� � ����� ����� ������� ���� ������
        first = newLink;                 // ��������� ��������� �������, �� ������
        if(dD %2 == 0){           
        sum ++;
        }
       
    }
    
        
    public Link find(int key) { // ����� �������� � ������� ������
        Link current = first;   // �������� ����� � ������� ��������
        	 while (current.iData != key) { // ����, ���� �� ��������,��..
        	     if (current.next == null) { //���� ����� ���� � ������ ������, ��������� null
        	         return null; 
        	     } else {
        	         current = current.next; //�� ���������� �� ���������� �������� � ������ ����
        	     }

        }
        return current;
      }
       
     	
    
    public Link delete(int key) { //��������� �������� �� �������� �����
        Link current = first; 
        Link previous = first;
        
        while (current.next != null) { // ����� ��������
            if (current.next == null) {
                return null;    // ������� �� ��������
            } else {
                previous = current; // ������� �� ���������� ��������
                current = current.next;
            }
            // ���� ��������
            if (current == first) {
                first = first.next; // ���� ������� ������� - ������
            } else {
                previous.next = current.next; // ���� ������� ������� ������ �������� ������, ������� ����
            }
        }
        return current;
    }
    
    public void displayList() {
        Link current = first;
        System.out.print("List (first --> last): ");
        
        while(current != null) { //���� ������ �� ���������, ���������� ���
            current.displayLink(); // ���������� ��� ��������, �� ����� �����������
            current = current.next; // ���������� �� ���������� ��������
        }
        System.out.println("");
    }
}

