public class DoublyLinkedList{

	ListNode root=null;
	ListNode end=null;
	int size=0;

	public DoublyLinkedList(){
		root=null;
		end=null;
	}

	public DoublyLinkedList(ListNode r){
		root = r;
		end = r;
	}

	public void add(int num){
		ListNode elem = new ListNode(num);
		if (root == null){
			root = elem;
			end = root;
		}
		else{
			end.setNext(elem);
			elem.setPrevious(end);
			end=elem;
		}
		size++;
	}

	public void add(int index,int num){
		ListNode temp = new ListNode(num);
		if (index<0 || index>size()){
			throw new ArrayIndexOutOfBoundsException();
		}
		else if (index==0){
			ListNode elem = new ListNode(num);
			if (root==null){
				root=elem;
				end=root;
			}
			else{
				elem.setNext(root);
				root.setPrevious(elem);
				root=elem;
			}
			size++;
		}
		else if (index==size()){
			add(num);
		}
		else{
			ListNode elem = root;
            for (int i = 0; i < index; i++) {
                elem = elem.getNext();
            }
            ListNode previ = elem.getPrevious();
            previ.setNext(temp);
            temp.setPrevious(previ);
            temp.setNext(elem);
            elem.setPrevious(temp);
            size++;
		}
	}

	public void clear(){
		root=null;
		end=null;
		size=0;
	}

	public ListNode get(int index){
		ListNode node = root;
		for (int i=0;i<index;i++){
			node=node.getNext();
		}
		return node;
	}

	public void sort(){
		ListNode node = root;
		ListNode jnode = root;
		int j=0;
		int counter=0;
		while (node!=null){

			for (j=counter+1;j<size;j++){
				if (node.getValue()>get(j).getValue()){
					int temp = node.getValue();
					node.setValue(get(j).getValue());
					get(j).setValue(temp);
				}
			}
			System.out.println(toString());
			node=node.getNext();
			counter++;
		}
	}


    public void remove(int index) {
        if (index<0 || index>=size()) {
            throw new ArrayIndexOutOfBoundsException();
        } else if (index==0) {
            root = root.getNext();
            root.setPrevious(null);
            size--;
        } else if (index == size-1) {
            end = end.getPrevious();
            end.setNext(null);
            size--;
        } else {
            ListNode temp = root;
            for (int i = 0; i < index; i++) {
                temp = temp.getNext();
            }
            ListNode previous = temp.getPrevious();
            ListNode next = temp.getNext();
            previous.setNext(temp.getNext());
            next.setPrevious(previous);
            size--;
        }
    }

	public String toString(){
		if (root==null){
			return "[]";
		}
		String str = "";
		ListNode node=root;
		for (int i=0;i<size();i++){
			if (node!=null){
				str = str+","+node.getValue();
				node = node.getNext();
			}
		}
		str=str.substring(1);
		str = "["+str+"]";
		return str;
	}

	public String toReversedString(){
		if (root==null){
			return "[]";
		}
		String str = "";
		ListNode node=end;
		for (int i=size()-1;i>=0;i--){
			if (node!=null){
				str = str+","+node.getValue();
				node = node.getPrevious();
			}
		}
		str=str.substring(1);
		str = "["+str+"]";
		return str;
	}

	public boolean contains(int a){
		ListNode val = root;
		while (val!=null && root!=null){

			if (val.getValue()==a){
				return true;
			}
			val = val.getNext();
		}
		return false;
	}

	public ListNode getEnd(){
		return end;
	}

	public ListNode getRoot(){
		return root;
	}

	public int size(){
		return size;
	}

	public class ListNode{

		int value;
		ListNode previous = null;
		ListNode next = null;

		public ListNode(int v){
			value=v;
		}

		public int getValue(){
			return value;
		}

		public void setValue(int val){
			value=val;
		}

		public void setPrevious(ListNode prev){
			previous=prev;
		}

		public void setNext(ListNode nex){
			next=nex;
		}

		public ListNode getPrevious(){
			return previous;
		}

		public ListNode getNext(){
			return next;
		}

		public boolean hasNext(){
			if (getNext()==null)
				return false;
			return true;
		}

		public boolean hasPrevious(){
			if (getPrevious()!=null)
				return true;
			return false;
		}

	}

}
