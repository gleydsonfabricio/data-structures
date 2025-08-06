public class Tests{
	
	public static void main(String[] args){
		
		ClosedAdressHashTable hashtable = new ClosedAdressHashTable();

		hashtable.put(634, "Ola mundo");
		hashtable.put(632, "opa");

		System.out.println(hashtable.get(634));
		System.out.println(hashtable.get(632));
		
		System.out.println(hashtable.get(1));
		
		hashtable.put(634, "ih trocou");
		System.out.println(hashtable.get(634));


	}



}
