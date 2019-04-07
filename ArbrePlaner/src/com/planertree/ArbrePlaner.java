package com.planertree;


import com.linkedList.linkedList;




public class ArbrePlaner {

	public static void main(String[] args) {
		ArbrePlaner ll = new ArbrePlaner();
		
		ll.add(1,"A");
		ll.add(2,"B");
		ll.add(1,"C");
		ll.add(3,"D");
		ll.add(1,"Z");
		
		for(int i = 0; i < ll.size; i++){
		//	System.out.println(ll.isIdExist(i));
			System.out.println("-----------------");
			System.out.println(ll.getIdAt(i)+" :");
			linkedList lst = ll.getListDataById(ll.getIdAt(i));
			for(int j = 0; j < lst.size; j++){
				System.out.println(lst.getElementAt(j));
			}
		}
		
		
		
		
	}
	
	
	private int size;
	private Noeud root;
	
	public Noeud add(long Id, Object data){
		if(isIdExist(Id)){
			Noeud nd = getNoeudId(Id);
			nd.add(data);
			return nd;
		}else{
			Noeud nd = new Noeud(Id, data, this.root);
			this.root = nd;
			this.size++;
			return nd;
		}
	}
	
	
	 
	 public Object getDataById(long Id, int x){
		 	Noeud thisNode = this.root;
	    	while(thisNode!=null){
	    		if(thisNode.getId() == Id){
	    			return thisNode.getLl().getElementAt(x);
	    		}
	    		thisNode = thisNode.getNextNoeud();
	    	}
	    	return null;
	    }
	 

	 
	 public long getIdAt(int x){
			if(size >= x){
				Noeud nd = this.root;
				for(int i = 0; i<x; i++)try {nd = nd.getNextNoeud();} catch (Exception e) {return -1;}
				return nd.getId();
			}
				return -1;
		}
	 
	 public linkedList getListDataById(long Id){
		 	Noeud thisNode = this.root;
	    	while(thisNode!=null){
	    		if(thisNode.getId() == Id){
	    			return thisNode.getLl();
	    		}
	    		thisNode = thisNode.getNextNoeud();
	    	}
	    	return null;
	    }
	 
	
	public boolean deleteById(long id){
		Noeud thisNode = this.root;
		Noeud prevNode = null;
		
		while(thisNode != null){
    		if(thisNode.getId() == id){
    			prevNode.setNextNoeud(thisNode.getNextNoeud());
    			this.setSize(this.getSize()-1);
    			return true;
    		}
    		prevNode = thisNode;
    		thisNode = thisNode.getNextNoeud();
    	}
    	return false;
	}
	

	 public boolean isIdExist(long Id){
		    Noeud thisNode = this.root;
	    	while(thisNode!=null){
	    		if(thisNode.getId()== Id){
	    			return true;
	    		}
	    		thisNode = thisNode.getNextNoeud();
	    	}
	    	return false;
	    }
	 
	 
	 
	 
	 public boolean isDataExist(long Id, Object data){
		 if(isIdExist(Id)){
			 Noeud thisNode = this.root;
		    	while(thisNode!=null){
		    		if(thisNode.getId() == Id){
		    			linkedList ll = thisNode.getLl();
		    			long x = ll.hashCode();
		    			long y = data.hashCode();
		    			if(x==y) return true;
		    		}
		    		thisNode = thisNode.getNextNoeud();
		    	}
		 }
		 return false;
	 }
	 
	 public Noeud getNoeudId(long Id){
		 	Noeud thisNode = this.root;
	    	while(thisNode!=null){
	    		if(thisNode.getId() == Id){
	    			return thisNode;
	    		}
	    		thisNode = thisNode.getNextNoeud();
	    	}
	    	return null;
	    }
	
	public ArbrePlaner() {
		this.root = root;
	}
	
	public ArbrePlaner(Noeud root) {
		this.root = root;
	}

	public ArbrePlaner(int size, Noeud root) {
		this.size = size;
		this.root = root;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Noeud getRoot() {
		return root;
	}

	public void setRoot(Noeud root) {
		this.root = root;
	}






	private class Noeud{
		private long id;
		private Noeud nextNoeud;
		private linkedList Ll;
		
		public void add(Object data){
			Ll.add(data);
		}
		
		public Noeud(long id, Object data ,Noeud nextNoeud){
			this.id = id;
			this.nextNoeud = nextNoeud;
			Ll = new linkedList();
			Ll.add(data);
		}
		
		public long getId() {
			return id;
		}
		
		public Noeud(Object data){
			Ll.add(data);
		}
				
		public void setId(long id) {
			this.id = id;
		}
		public Noeud getNextNoeud() {
			return nextNoeud;
		}
		public void setNextNoeud(Noeud nextNoeud) {
			this.nextNoeud = nextNoeud;
		}
		public linkedList getLl() {
			return Ll;
		}
		public void setLl(linkedList ll) {
			Ll = ll;
		}
		
		
		
	}
	
}
