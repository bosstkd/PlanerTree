package com.linkedList;




public class linkedList {

	
	
	noeud root;
	public int size;
	
	public linkedList(){
		root = new noeud();
		size = 0;
	}
	
	
	public noeud add(Object data){
		noeud nd = new noeud(root, data);
		this.root = nd;
		this.size++;
		return nd;
	}
	
	public noeud add(int position, Object data){
		if(size > position){
			noeud nd = this.root;
			noeud nd0 = new noeud(data);
			for(int i = 0; i<position; i++)
				try {nd = nd.getNextNoeud();} catch (Exception e) {return null;}
				nd0.setNextNoeud(nd.getNextNoeud());
				nd.setNextNoeud(nd0);
				size++;
				return nd;
			
		}else if(size <= position)add(data);
		
		return null;
	}
	
	 public noeud add(Object data, Object where){
		   noeud thisNode = this.root;
		    noeud prevNode = null;
		    noeud nxNode = getElementAt(where);
	    	if(nxNode!=null){
	    		noeud newNode = new noeud(nxNode,data);
			    	while(thisNode != null){
			    		if(thisNode.getDonnee() == where){
			    			prevNode.setNextNoeud(newNode);
			    			this.setSize(this.getSize()+1);
			    			return newNode;
			    		}
			    		prevNode = thisNode;
			    		thisNode = thisNode.getNextNoeud();
			    	}
	    	}
	    	return null;
	    }
	
	 
	 public noeud getElementAt(Object data){
		    noeud thisNode = this.root;
	    	while(thisNode!=null){
	    		if(thisNode.getDonnee() == data){
	    			return thisNode;
	    		}
	    		thisNode = thisNode.getNextNoeud();
	    	}
	    	return null;
	    }
	 
	public Object getElementAt(int x){
		if(size >= x){
			noeud nd = this.root;
			for(int i = 0; i<x; i++)try {nd = nd.getNextNoeud();} catch (Exception e) {return null;}
			return nd.getDonnee();
		}
			return null;
	}
	
	public int indexOf(Object data){
		if(this.root != null){
			noeud nd = this.root;
			for(int i = 0; i < this.size; i++)	if(nd.donnee == data)
													return i;
												else
													nd = nd.getNextNoeud();
			return -1;
		}
	  return -1;
	}
	

	public boolean delete(Object data){
		noeud thisNode = this.root;
		noeud prevNode = null;
		
		while(thisNode != null){
    		if(thisNode.getDonnee() == data){
    			prevNode.setNextNoeud(thisNode.getNextNoeud());
    			this.setSize(this.getSize()-1);
    			return true;
    		}
    		prevNode = thisNode;
    		thisNode = thisNode.getNextNoeud();
    	}
    	return false;
		
	}
	
	
	
	
	
	
	
	
	public noeud getRoot() {
		return root;
	}


	public void setRoot(noeud root) {
		this.root = root;
	}


	public int getSize() {
		return size;
	}


	public void setSize(int size) {
		this.size = size;
	}


	private class noeud{
		private noeud nextNoeud;
		private Object donnee;

		public noeud() {}
		
		public noeud(Object donnee) {
			this.donnee = donnee;
		}

		public noeud(noeud nextNoeud, Object donnee) {
			this.nextNoeud = nextNoeud;
			this.donnee = donnee;
		}

		public noeud getNextNoeud() {
			return nextNoeud;
		}
		public void setNextNoeud(noeud nextNoeud) {
			this.nextNoeud = nextNoeud;
		}
		public Object getDonnee() {
			return donnee;
		}
		public void setDonnee(Object donnee) {
			this.donnee = donnee;
		}
	}
	
}
