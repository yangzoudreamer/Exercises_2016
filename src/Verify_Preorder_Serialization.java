import java.util.Stack;


public class Verify_Preorder_Serialization {
    public static boolean isValidSerialization(String preorder) {
        //用栈由下至上
        String[] cS = preorder.split(",");
        Stack<String> stack = new Stack<String>();
        for(int i = 0; i < cS.length; i++){
            stack.push(cS[i]);
            // char a = 
            while(stack.size()>=3){
                if(stack.peek().equals("#")){
                    String a = stack.pop();
                    String b = stack.peek();
                    if(b.equals("#")){
                        b = stack.pop();
                        String c = stack.peek();
                        if(!c.equals("#")){
                            stack.pop();
                            stack.push("#");
                        }
                        else{
                            stack.push(b);
                            stack.push(a);
                            break;
                        }
                    }
                    else{
                        stack.push(a);
                        break;
                    }
                }
                else{
                    break;
                }
            }
            
//            continue;
            
        }
        
        return stack.size()==1 && stack.peek() == "#";
    }
    
    public static void main(String[] args) {
		System.out.println(isValidSerialization("#"));
	}
    
}
