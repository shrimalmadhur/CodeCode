public class HashTableNode{
	private Object key;
	private Object val;
	public HashTableNode(){
		this.key = null;
		this.val = null;
	}
	public HashTableNode(Object key, Object val){
		this.key = key;
		this.val = val;
	}
	public void setKey(Object key){
		this.key = key;
	}
	public Object getKey(){
		return this.key;
	}
	public void setVal(Object val){
		this.val = val;
	}
	public Object getVal(){
		return this.val;
	}
	public boolean equals(Object obj){
		if(obj instanceof HashTableNode){

			HashTableNode node = (HashTableNode)obj;
			return node.getKey().equals(this.getKey());
		}
		return false;
	}
}
