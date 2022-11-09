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
    public  int iData; // інформація
    public int dData; // інформація
    public Link next; // посилання на наступний елемент списку
    
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

        Link newLink = new Link(iD, dD); //створюємо новий елемент списку
        newLink.next = first;            //вказали на старий "перший" елемент і таким чином зробили його другим
        first = newLink;                 // позначили створений елемент, як перший
        if(dD %2 == 0){           
        sum ++;
        }
       
    }
    
        
    public Link find(int key) { // пошук елемента с заданим ключем
        Link current = first;   // починаємо пошук з першого елемента
        	 while (current.iData != key) { // якщо, ключ не знайдено,то..
        	     if (current.next == null) { //якщо ключа немає в списку взагалі, повертаємо null
        	         return null; 
        	     } else {
        	         current = current.next; //то переходимо до наступного елемента і шукаємо ключ
        	     }

        }
        return current;
      }
       
     	
    
    public Link delete(int key) { //видалення елементу по заданому ключу
        Link current = first; 
        Link previous = first;
        
        while (current.next != null) { // пошук елемента
            if (current.next == null) {
                return null;    // елемент не знайдено
            } else {
                previous = current; // перейти до наступного елементу
                current = current.next;
            }
            // ключ знайдено
            if (current == first) {
                first = first.next; // якщо шуканий елемент - перший
            } else {
                previous.next = current.next; // якщо шуканий елемент лежить всередині списку, обійдемо його
            }
        }
        return current;
    }
    
    public void displayList() {
        Link current = first;
        System.out.print("List (first --> last): ");
        
        while(current != null) { //доки список не закінчився, відображаємо дані
            current.displayLink(); // відображаємо дані елементу, на якому знаходимося
            current = current.next; // переходимо до наступного елементу
        }
        System.out.println("");
    }
}

