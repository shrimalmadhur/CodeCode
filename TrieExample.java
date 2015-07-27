
public class TrieExample {
	private TrieNode root;
	public TrieExample(){
		root = new TrieNode();
	}
	public static void main(String[] args) {
		TrieExample tr = new TrieExample();
		tr.insert("abc");
		tr.insert("acb");
		System.out.println(tr.startsWith("ad"));
	}
	public void insert(String words){
		int len = words.length();
		TrieNode curr = root;
		for(int i=0; i < len; i++){
			int index = charToIndex(words.charAt(i));
			TrieNode[] ch = curr.getChildren();
			if(ch[index] == null){
				ch[index] = new TrieNode(words.charAt(i));
			}
			curr = ch[index];
			
		}
		curr.setValue(1);
	}
	
	public boolean search(String words){
		int len = words.length();
		TrieNode curr = root;
		for(int i=0; i<len; i++){
			int index = charToIndex(words.charAt(i));
			TrieNode[] ch = curr.getChildren();
			if(ch[index] == null){
				return false;
			}else{
				if(ch[index].getKey() == words.charAt(i)){
					curr = ch[index];
					continue;
				}
				else
					return false;
			}
		}
		if(curr.getValue() == 1)
			return true;
		return false;
	}
	public boolean startsWith(String words){
		int len = words.length();
		TrieNode curr = root;
		for(int i=0; i<len; i++){
			int index = charToIndex(words.charAt(i));
			TrieNode[] ch = curr.getChildren();
			if(ch[index] == null){
				return false;
			}else{
				if(ch[index].getKey() == words.charAt(i)){
					curr = ch[index];
					continue;
				}
				else
					return false;
			}
		}
		return true;
	}
	public int charToIndex(char c){
		return c - 'a';
	}
}
