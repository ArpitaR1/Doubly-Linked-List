public class DLLTestCodeForAllTasks
{
	DoublyLinkedList list=new DoublyLinkedList();
	public DLLTestCodeForAllTasks()
	{
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(0,4);
		list.add(list.size(),5);
		list.add(list.size()-1,6);
		outputList();
		findSums();
		duplicateEvens();
		removeDivisibleBy3();
		add55555();
		sortList();
		list.sort();
		outputList();
		findMedian();
		list.clear();
		System.out.println("\nClear List!");
		System.out.println("\tList: "+list);
		System.out.println("\tList reversed: "+list.toReversedString());
		System.out.println();

		list.add(1);
		list.add(2);
		list.add(3);
		list.add(0,4);
		list.add(list.size(),5);
		list.add(list.size()-1,6);
		outputList();

		list.remove(1);
		list.remove(list.size()-1);
		outputList();

		System.out.println("Contains Test:");
		System.out.println("\tContains 3: "+list.contains(3));
		System.out.println("\tContains 4: "+list.contains(4));

	}
	public void fillList(int n)
	{
		for (int i=0;i<30;i++){
			int rand = (int)(Math.random()*1000)+1;
			list.add(rand);
		}
	}
	public void outputList()
	{
		System.out.println("List: "+list.toString());
		System.out.println("List reversed: "+list.toReversedString());
		System.out.println("Size: "+list.size());
		System.out.println();
	}
	public void findMedian()
	{
		if (list.size()%2!=0){
			DoublyLinkedList.ListNode node = list.getRoot();
			for (int i=0;i<list.size()/2;i++){
				if (node!=null)
				node = node.getNext();
			}
			if (node!=null)
			System.out.println("Median: "+node.getValue());
		}
		else if (list.size()%2==0){
			DoublyLinkedList.ListNode node = list.getRoot();
			int val2=0;
			int val1=0;
			for (int i=0;i<list.size()/2;i++){
				node = node.getNext();
			}
			val1=node.getValue();
			if (node.getPrevious()!=null){
				val2=node.getPrevious().getValue();
			}
			System.out.println("Median: "+val1+val2);
		}
	}
	public void findSums()
	{
		System.out.println("Sum: "+sum());
		System.out.println("Even Sum: "+sumEvenIndexes());
		System.out.println("Odd Sum: "+sumOddIndexes());
		System.out.println();
	}
	public void add55555()
	{
		list.add(3,55555);
		System.out.println("List (added 55555 to 4th position): "+list.toString());
		System.out.println();
	}
	public void sortList()
	{
		list.sort();
		System.out.println("List Sorted: "+list.toString());
		System.out.println();
	}
	public void removeDivisibleBy3()
	{
		DoublyLinkedList.ListNode node = list.getRoot();
		int counter=0;
		while (node!=null && list.getRoot()!=null){
			if (node.getValue()%3==0){
				if (!(counter<0 || counter>=list.size())){
				list.remove(counter);
				node=node.getPrevious();
				counter-=1;
				}

			}
			node=node.getNext();
			counter++;
		}
		System.out.println("List (values divisible by 3 removed): "+list.toString());
		System.out.println();
	}
	public void duplicateEvens()
	{
		int counter=0;
		DoublyLinkedList.ListNode node = list.getRoot();
		int size = list.size();
		while (node!=null && counter<size){
			if (node.getValue()%2==0){
				list.add(node.getValue());

			}
			node=node.getNext();
			counter++;
		}
		System.out.println("List (duplicate evens): "+list.toString());
		System.out.println();
	}
	public int sum()
	{
		DoublyLinkedList.ListNode node = list.getRoot();
		int sum=0;
			while (node!=null && list.getRoot()!=null){
				sum+=node.getValue();
				node=node.getNext();
		}
		return sum;
	}
	public int sumEvenIndexes()
	{
		DoublyLinkedList.ListNode node = list.getRoot();
		int sum=0;
		int counter=0;
			while (node!=null && list.getRoot()!=null && counter<list.size()){
				if (counter%2==0){
					sum+=node.getValue();
				}
				node=node.getNext();
				counter++;
			}
		return sum;
	}
	public int sumOddIndexes()
	{
		DoublyLinkedList.ListNode node = list.getRoot();
		int sum=0;
		int counter=0;
			while (node!=null && list.getRoot()!=null && counter<list.size()){
				if (counter%2!=0){
					sum+=node.getValue();
				}
				node=node.getNext();
				counter++;
			}
		return sum;
	}

	public static void main(String[] args)
	{
		DLLTestCodeForAllTasks app=new DLLTestCodeForAllTasks();
	}

}