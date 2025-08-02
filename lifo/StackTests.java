public class StackTests{
	
	//running tests: java -ea
	public static void main(String[] args){

		Stack<String> stack = new Stack(5);
		
		assert stack.isEmpty();

		//cant remove
		try{
			stack.pop();
			assert false;
		}catch (Exception e){}
		
		//no such element
		try{
			stack.peek();
			assert false;
		}catch (Exception e){}


		stack.push("Bortoleto");
		stack.push("Hamilton");

		assert stack.peek().equals("Hamilton"); // dont remove
		assert stack.pop().equals("Hamilton"); // remove
		assert !stack.peek().equals("Hamilton"); // hamilton removed
		
		stack.push("Leclerc");
		stack.push("Alonso");
		stack.push("Piastri");
		stack.push("Norris");
	
		assert stack.isFull();

		//full stack, dont add
		try{
			stack.push("Antonelli");
			assert false;
		}catch (Exception e){}
		
		
		assert stack.contains("Alonso");
		assert !stack.contains("Gasly");
		
		assert stack.indexOf("Massa") == -1;
		assert stack.indexOf("Bortoleto") == 0;
		assert stack.indexOf("Norris") == 4;
			
		assert stack.size() == 5;
		stack.pop();
		assert stack.size() == 4;
		stack.peek();
		assert stack.size() == 4;
		
		stack.clear();
		assert stack.isEmpty();
		assert stack.size() == 0;


	}

}
